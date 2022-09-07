import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pablo Velicias Barquín
 */
public class prodMatricesParalelo implements Runnable{
    private static int[][] Matriz1, Matriz2, Resultado;
    private static int N;
    private int inicio, fin;

    /**
     * Constructor de la clase
     * @param in Punto inicial desde el que trabajara el hilo
     * @param lfin  Punto final hasta que trabajara el hilo
     */
    prodMatricesParalelo(int in, int lfin)
    {  
        this.inicio = in;
        this.fin = lfin;
    }

    /**
     * Metodo run() para los hilos
     */
    public void run()
    {
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                for(int z=inicio; z<fin; z++)
                {
                    Resultado[i][j] = Matriz1[i][z] * Matriz2[z][j] + Resultado[i][j];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int numHilos = Runtime.getRuntime().availableProcessors();
        int inicio=0;

        System.out.print("Introduzca valor de N para matrices NxN: " );
        N = in.nextInt();
        int tam = N/numHilos;

        Matriz1 = new int[N][N];
        Matriz2 = new int[N][N];
        Resultado = new int[N][N];    
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                Matriz1[i][j] = r.nextInt(5);
                Matriz2[i][j] = r.nextInt(5);
            }
        }

        long inicioTiempo = System.currentTimeMillis();
        ExecutorService Pool = Executors.newFixedThreadPool(numHilos);
        Runnable aux;
        int it = 0;
        while(it < numHilos && inicio < N)
        {
            if(it == numHilos-1 || tam == 0)
            {
                aux = new prodMatricesParalelo(inicio, N);
                inicio = N;
                it = numHilos;
            }
            else
            {
                aux = new prodMatricesParalelo(inicio, inicio+tam);
                inicio += tam;
                it++;
            }
            
            Pool.execute(aux);
        }

        Pool.shutdown();
        while(!Pool.isTerminated());
        long FinTiempo = System.currentTimeMillis() - inicioTiempo;

        System.out.print("Tiempo de ejecucion en milisegundos: " + FinTiempo + " ms");
        in.close();
    }
}
