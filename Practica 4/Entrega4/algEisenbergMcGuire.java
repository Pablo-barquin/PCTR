import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pablo Velicias Barquín
 */
public class algEisenbergMcGuire implements Runnable {
    //Inicializamos las variables
    public static enum estado {IDLE, ESPERANDO, ACTIVO}    //Los posibles estados que puede tomar un hilo
    public static estado[] flags;  //Creo un vector de estados, donde el indice será el identificador del hilo
    public static volatile int turno, N, n=0;
    private int indice, idHilo = 0, tipoHilo;
    
    /**
     * Constructor de la clase
     * @param tipo  Indica que tipo de proceso va a realizar el hilo
     * @param ID    Identificador del HIlo
     */
    public algEisenbergMcGuire(int tipo, int ID) 
    {
        this.tipoHilo = tipo;
        this.idHilo = ID; 
        flags[idHilo] = estado.IDLE;    //Inicializamos su estado a Inactivo usando el identificador
    }

    /**
     * Metodo run() para los hilos
     */
    public void run()
    {
        switch(tipoHilo)
        {
            case 0: ProcesoTipo1(); break;
            case 1: ProcesoTipo2(); break;
        }
    }

    /**
     * Proceso que realiza como operación crítica n++
     */
    public void ProcesoTipo1()
    {
        for(int j=0; j < 100000; j++)
        {
            do
            {
                flags[idHilo] = estado.ESPERANDO;   //Indica como estado que esta esperando para realizar su sección critica
                indice = turno; //Miramos a quien le pertenece el turno
                while(indice != idHilo) //Mientras no sea nuestro turno, esperamos
                {
                    if(flags[indice] != estado.IDLE) indice = turno;    //Si el hilo no esta en estado INACTIVO, le pertenece el turno
                    else indice = (indice+1) % N;   //Si no, avanzamos el turno
                }
    
                flags[idHilo] = estado.ACTIVO;  //Indicamos estado ACTIVO temporalmente
                indice = 0;
                while((indice < N) && ((indice == idHilo) || (flags[indice] != estado.ACTIVO)))     //Buscamos el primer Hilo en estado ACTIVO, o ninguno, si no existe
                {
                    indice = indice+1;
                }
                
            //Realizamos el bucle hasta que no haya ningún hilo ACTIVO y sea nuestro turno, o los otros hilos esten INACTIVOS, sino continuamos dentro
            }while(!((indice >= N) && (turno == idHilo) || (flags[turno] == estado.IDLE)));
            
            turno = idHilo;     //Indicamos nuestro turno
            n++;    //Realizamos la sección Critica
    
            indice = (turno+1) % N; 
            while(flags[indice] == estado.IDLE) //Avanzamos hasta encontrar el siguiente Hilo que no este INACTIVO
            {
                indice = (indice+1) % N;
            }
    
            turno = indice; //Asignamos el nuevo turno
    
            flags[idHilo] = estado.IDLE;    //Pasamos a estado INACTIVO
        }
    }
    
    /**
     * Proceso que realiza como operación crítica n--
     */
    public void ProcesoTipo2()
    {
        for(int j=0; j < 100000; j++)
        {
            do
            {
                flags[idHilo] = estado.ESPERANDO;
                indice = turno;
                while(indice != idHilo)
                {
                    if(flags[indice] != estado.IDLE) indice = turno;
                    else indice = (indice+1) % N;
                }
    
                flags[idHilo] = estado.ACTIVO;
                indice = 0;
                while((indice < N) && ((indice == idHilo) || (flags[indice] != estado.ACTIVO)))
                {
                    indice = indice+1;
                }
    
            }while(!((indice >= N) && (turno == idHilo) || (flags[turno] == estado.IDLE)));
            
            turno = idHilo;
            n--;
    
            indice = (turno+1) % N;
            while(flags[indice] == estado.IDLE)
            {
                indice = (indice+1) % N;
            }
    
            turno = indice;
    
            flags[idHilo] = estado.IDLE;
        }
    }

    public static void main(String[] args) throws Exception
    {
        N = 16; //Numero de Hilos
        flags = new estado[N];  //Creamos vector de estados con el número de hilos

        ExecutorService Pool = Executors.newFixedThreadPool(4);
        Runnable aux;   //Runnable auxiliar para crear el vector de hilos

        Random r = new Random();
        turno = r.nextInt(4); //Damos el turno a un hilo aleatorio

        for(int i=0; i<N; i++)
        {
            aux = new algEisenbergMcGuire((i+1)%2, i);    //Creamos cada hilo usando implementación Runnable
            Pool.execute(aux);     //Lo añadimos al vector de hilos
        }
        
        Pool.shutdown();
        while(!Pool.isTerminated());
        System.out.println(n);

    }
}
