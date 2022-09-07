/**
 * @author Pablo Velicias Barquín
 */
public class tareaRunnableSeguro implements Runnable{
    
    private int tipoHilo;
    private int nIter;
    private Critica c;
    private Object lock;

    /**
     * Constructor de la clase
     * @param num Numero de iteraciones a realizar
     * @param tipo Tipo de acción que va a realizar el hilo
     * @param c Clase de tipo Critica
     * @param p Objeto que sirve para Synchronized
     */
    tareaRunnableSeguro(int num, int tipo, Critica c, Object p)
    {
        this.nIter = num;
        this.tipoHilo = tipo;
        this.c = c;
        this.lock = p;
    }

    /**
     * Metodo run() de los hilos
     */
    public void run()
    {
        synchronized(lock)  
        {  
            switch(tipoHilo)
            {
                case 0: for(int i=0; i<nIter; i++) c.inc(); break;
                case 1: for(int j=0; j<nIter; j++) c.dec(); break;

                default: System.out.println("Operacion no valida");
            }
        }
    }
}
