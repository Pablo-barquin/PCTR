/**
* @author Pablo Velicias Barquín
*/

public class prodEscalarParalelo extends Thread
{
    int id, inicio, fin;
    static int[] V1 = new int[1000000];
    static int[] V2 = new int[1000000];
    static int[] productoParcial;

    /**
     * Constructor del hilo dado un determinado rango
     * @param idHebra   Identificador de la hebra
     * @param inicio    Inicio del vector principal    
     * @param fin       Final del vector principal
     */
    public prodEscalarParalelo(int idHebra, int inicio, int fin)
    {
        this.id = idHebra;
        this.inicio = inicio;
        this.fin = fin;
    }

    /**
     * Calculo de forma secuencial del producto escalar de dos vectores desde el rango inicio hasta fin
     */
    public void run()
    {
        for(int i=inicio; i<fin; i++)
        {
            productoParcial[id] = (V1[i] * V2[i]) + productoParcial[id];
        }
    }

    public static void main(String args[]) throws Exception
    {
        long duracionTotal;
        long inicio;
        
        int NumeroHilos = 10;
        int tamanoVector = V1.length/NumeroHilos;
        int avance = 0;
        int Resultado = 0;

        //Inicializar los vectores con valores aleatorios entre 0 y 5
        for(int i=0; i<V1.length; i++)
        {
            V1[i] = (int)(Math.random()*5);
            V2[i] = (int)(Math.random()*5);
        }

        //Inicializamos vector productoParcial, dependiendo de los hilos creados
        productoParcial = new int[NumeroHilos];
        for(int j=0; j<NumeroHilos; j++) productoParcial[j] = 0;

        //Creamos los hilos
        prodEscalarParalelo[] hilos = new prodEscalarParalelo[NumeroHilos];
        int it=0;
        while(it < NumeroHilos)
        {
            if(it == NumeroHilos-1)
            {
                hilos[it] = new prodEscalarParalelo(it, avance, V1.length);
            }
            else
            {
                hilos[it] = new prodEscalarParalelo(it, avance, avance+tamanoVector);
            }

            avance += tamanoVector;
            it++;
        }

        //Cronometramos el tiempo de ejecución de los hilos
        inicio = System.currentTimeMillis();
        for(int i=0; i<NumeroHilos; i++) hilos[i].start();
        for(int i=0; i<NumeroHilos; i++) hilos[i].join();
        duracionTotal = System.currentTimeMillis() - inicio;

        //Sumamos el resultado Final
        for(int i=0; i<NumeroHilos; i++) Resultado += productoParcial[i];

  
        System.out.println("Producto escalar obtenido para N=10^6 -> " + Resultado);
        System.out.print("Tiempo en milisegundos usando la forma secuencial -> " + duracionTotal + " Ms");

    }

}
