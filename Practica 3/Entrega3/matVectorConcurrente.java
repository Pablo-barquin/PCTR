import java.util.Random;
import java.util.Scanner;

/**
 * @author Pablo Velicias Barquín
 */
public class matVectorConcurrente implements Runnable{

    //Inicializamos las variables que vamos a utilizar
    int inicio, fin;
    static int N;
    static int[][] Matriz;
    static int[] Vector;
    static int[] ResultadoParcial;

    /**
     * 
     * @param inicio    Fila inicial donde comenzará el hilo a trabajar    
     * @param fin       Fila final que el hilo trabajará
     */
    public matVectorConcurrente(int inicio, int fin)
    {
        this.inicio = inicio;
        this.fin = fin;
    }

    //Metodo run() para los hilos
    public void run()
    {
        int aux = 0;
        for(int i=inicio; i<fin; i++)
        {
            for(int j=0; j<N; j++)
            {
                aux = (Matriz[i][j]*Vector[j]) + aux;
            }

            ResultadoParcial[i] = aux;
        }
    }

    public static void main(String[] args) throws Exception
    {
        long inicio;
        long duracionTotal;
       
        int NumeroHilos = 16;
        Random r = new Random();

        Scanner in = new Scanner(System.in);
        System.out.print("Introduzca Tam. N: ");
        N = in.nextInt();

        Matriz = new int[N][N];
        Vector = new int[N];
        ResultadoParcial = new int[N];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                Matriz[i][j] = r.nextInt(7);
            }

            Vector[i] = r.nextInt(7);
        }

        Runnable Auxiliar;
        Thread[] H = new Thread[NumeroHilos];
        int tamanoHilo = N/NumeroHilos;
        int avance = 0, it = 0;

        inicio = System.currentTimeMillis();
        while(it < NumeroHilos)
        {
            if(it == NumeroHilos-1)
            {
                Auxiliar = new matVectorConcurrente(avance, N);
                H[it] = new Thread(Auxiliar);    
            }
            else
            {
                Auxiliar = new matVectorConcurrente(avance, avance+tamanoHilo);
                H[it] = new Thread(Auxiliar);    
            }

            avance += tamanoHilo;
            it++;
        }

        for(int i=0; i<NumeroHilos; i++) H[i].start();
        for(int i=0; i<NumeroHilos; i++) H[i].join();
        duracionTotal = System.currentTimeMillis() - inicio;

        /*for(int i=0; i<N; i++)
        {
            System.out.println(Arrays.toString(Matriz[i]) + "  [" + Vector[i] + "] ---- [" + ResultadoParcial[i] + "]");
        }*/

        System.out.println("Duracion en milisegundos de la ejecucion: " + duracionTotal + " ms");

        in.close();
    }

}
