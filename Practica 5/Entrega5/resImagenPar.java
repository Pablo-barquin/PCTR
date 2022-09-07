import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pablo Velicias Barquín
 */
public class resImagenPar implements Runnable{
    
    public static short[][] Entrada;
    public static short[][] Salida;
    public static int N, aux = 0;

    public int inicio, fin;

    /**
     * Constructor de la clase
     * @param inicio Punto inicial desde donde trabajará el hilo
     * @param fin Punto final hasta que el hilo trabajará
     */
    resImagenPar(int inicio, int fin)
    {
        this.inicio = inicio;
        this.fin = fin;

        if(inicio == 0) this.inicio++;
        if(fin == N) this.fin--;
    }

    /**
     * Metodo run() de los hilos. Condición de frontera Nula. No se tienen en cuenta los bordes
     */
    public void run()
    {
        for(int i=inicio; i<fin; i++)
        {
            for(int j=1; j<N-1; j++)
            {
                Salida[i][j] = (short)((4*Entrada[i][j] - Entrada[i+1][j] - Entrada[i][j+1] - Entrada[i-1][j] - Entrada[i][j-1])/8);
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int NumHilos = Runtime.getRuntime().availableProcessors();

        System.out.print("Indica el valor de N para la matriz NxN: ");
        N = in.nextInt();

        Entrada = new short[N][N];
        Salida = new short[N][N];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                Entrada[i][j] = (short) r.nextInt(256);
            }
        }

        ExecutorService Pool = Executors.newFixedThreadPool(NumHilos);
        Runnable aux;
        int tam = N/NumHilos, it=0, inicio=0;

        long inicioTiempo = System.currentTimeMillis();
        while(it < NumHilos && inicio <= N)
        {
            if(it == NumHilos-1 || tam == 0)
            {
                aux = new resImagenPar(inicio, N);
                it = NumHilos;
                inicio = N;
            }
            else
            {
                aux = new resImagenPar(inicio, inicio+tam);
                it++;
                inicio += tam;
            }

                Pool.execute(aux);
        }

        Pool.shutdown();
        while(!Pool.isTerminated());
        long fin = System.currentTimeMillis() - inicioTiempo;

        System.out.println("El tiempo de ejecucion en milisegundos: " + fin + " ms");
        in.close();

    }

}
