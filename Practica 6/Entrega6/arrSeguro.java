import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pablo Velicias Barquín
 */
public class arrSeguro extends Thread{

    public static int N=0;
    public static int[] M;
    private Object lock;
    public int i;

    arrSeguro(Object p)
    {
        lock = p;
    }

    /**
     * Metodo run() de los hilos
     * Metodo que utiliza código synchronized. Solo un hilo puede entrar en este código a la vez, mientras los demas se mantienen en espera.
     * Los hilos incrementaran y decrementaran 100000 veces todas las posiciones del vector. El resultado final debe ser 0.
     */
    public void run()
    {
        synchronized(lock)
        {
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<100000; j++)
                {
                    M[i]++;
                    M[i]--; 
                }         
            }   
        }
    }

    public static void main(String[] args) throws Exception
    {
        Object Monitor = new Object();
        Scanner in = new Scanner(System.in);
        System.out.print("Indique tamaño N del vector para hacer la operación: ");
        N = in.nextInt();

        M = new int[N];
        for(int i=0; i<N; i++)
        {
            M[i] = 0;   
        }

        int hilos = 10;
        Thread[] pool = new Thread[hilos];
        for(int i=0; i<hilos; i++) pool[i] = new arrSeguro(Monitor);

        for(int i=0; i<hilos; i++) pool[i].start();
        for(int i=0; i<hilos; i++) pool[i].join();

        System.out.println("El resultado de la matriz es: ");
        System.out.println(Arrays.toString(M));
        in.close();

    }

}