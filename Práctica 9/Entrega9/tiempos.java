import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;

/**
 * @author Pablo Velicias Barquín
 */
public class tiempos {

    public static long Semaforos(long iter) {
        int n = 0;
        Semaphore s = new Semaphore(1);
        long ini = System.nanoTime();
        for (long i = 0; i < iter; i++) {
            try { s.acquire(); } catch (InterruptedException e) {}
            try { n++; } finally { s.release(); }
        }
        long fin = System.nanoTime();

        return (fin - ini);
    }

    public static long Synchronized(long iter){
        int n = 0;
        Object o = new Object();
        long ini=System.nanoTime();
        for(long i=0; i<iter; i++){
            synchronized(o){ n++; }
        }
        long fin=System.nanoTime();

        return(fin-ini);
    }

    public static long ReentrantLock(long iter){
        int n = 0;
        ReentrantLock L = new ReentrantLock();
        long ini=System.nanoTime();
        for(long i=0; i<iter; i++){
            L.lock();
            try { n++; } finally {L.unlock();}
        }
        long fin=System.nanoTime();

        return(fin-ini);
    }

    public static long Atomic(long iter){
        AtomicInteger n = new AtomicInteger();
        long ini=System.nanoTime();
        for(long i=0; i<iter; i++){
            n.getAndIncrement();
        }
        long fin=System.nanoTime();

        return(fin-ini);
    }

    public static void main(String[] args) {
        long it = 100000000;

        System.out.println("Tiempos obtenidos para " + it + " iteraciones");
        System.out.println("Tiempo usando Semaphore: " + (double)Semaforos(it)/1_000_000_000 + " segundos");
        System.out.println("Tiempo usando Synchronized: " + (double)Synchronized(it)/1_000_000_000 + " segundos");
        System.out.println("Tiempo usando ReentrantLock: " + (double)ReentrantLock(it)/1_000_000_000 + " segundos");
        System.out.println("Tiempo usando Atomic: " + (double)Atomic(it)/1_000_000_000 + " segundos");
    }
}
