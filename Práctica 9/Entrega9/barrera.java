import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Pablo Velicias Barquín
 */
public class barrera extends Thread{
    CyclicBarrier bar = null;

    /**
     * Constructor de la clase
     * @param br    CyclicBarrier que tienen en común los hilos
     */
    barrera(CyclicBarrier br)
    {
        bar = br;
    }

    /**
     * Metodo run() para los hilos
     */
    public void run()
    {
        try
        {    
            System.out.println("Hilo " + Thread.currentThread().getName() + " espera en la barrera");
            bar.await();
        }catch(BrokenBarrierException e){}
         catch(InterruptedException e){}
        System.out.println("Hilo " + Thread.currentThread().getName() + " pasa la barrera");
    }

    public static void main(String[] args) throws Exception {
        int numHilos = 3;
        CyclicBarrier BarreraAux = new CyclicBarrier(numHilos);

        Thread[] hilos = new Thread[numHilos];
        for(int i=0; i<numHilos; i++) hilos[i] = new barrera(BarreraAux);

        for(int i=0; i<numHilos; i++) hilos[i].start();
        for(int i=0; i<numHilos; i++) hilos[i].join();
    }
}