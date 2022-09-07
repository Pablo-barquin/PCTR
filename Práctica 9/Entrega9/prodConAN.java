import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Pablo Velicias Barquín
 */
public class prodConAN {
    private int N, cont;
    private int Oldest = 0, Newest = 0;
    private int[] Buffer;
    
    private ReentrantLock L = new ReentrantLock();
    private Condition notEmpty = L.newCondition();
    private Condition notFull = L.newCondition();

    /**
     * Constructor de la clase. Sirve para inicializar las variables
     */
    prodConAN()
    {
        this.N = 100;
        this.cont = 0;
        this.Buffer = new int[N];
    }

    /**
     * Añade un numero al buffer
     * @param v Numero que se añade al final de la cola
     */
    public void append(int v)
    {
        L.lock();
        try
        {
            while(cont == N-1)
            {
                System.out.println("Hilo " + Thread.currentThread().getName() + " esperando a que el buffer tenga espacio");
                try { notFull.await(); } catch(InterruptedException e){}
            } 
            
                
            Buffer[Newest] = v;
            Newest = (Newest + 1) % N;
            cont++;
            notEmpty.signalAll();
        }finally{L.unlock();}
    }

    /**
     * Se coge un numero del buffer
     * @return Devuelve el numero que lleve mas tiempo dentro
     */
    public int take()
    {
        L.lock();
        try
        {
            while(cont == 0) 
            {
                System.out.println("Hilo " + Thread.currentThread().getName() + " esperando a que el buffer tenga alguna request");
                try { notEmpty.await(); } catch(InterruptedException e){}
            }
            int w = Buffer[Oldest];
            Oldest = (Oldest + 1) % N;
            cont--;
            notFull.signalAll();
            return w;
        }finally{L.unlock();}
        
    }
}
