import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Pablo Velicias Barquín
 */
public class filoApiAN {
    private int[] fork;
    private ReentrantLock L = new ReentrantLock();
    private Condition[] C;
    private int N;

    filoApiAN(int num)
    {
        this.N = num;
        this.fork = new int[N];
        for(int i=0; i<N; i++) fork[i] = 2;
        
        this.C = new Condition[N];
        for(int i=0; i<N; i++) C[i] = L.newCondition();
    }

    public void takeForks(int i)
    {
        L.lock();
        try
        {
            i--;
            while(fork[i] != 2) 
            {
                System.out.println("Hilo " + Thread.currentThread().getName() + " espera a 2 tenedores");                
                try{ C[i].await(); } catch(InterruptedException e){}
            }
            System.out.println("Hilo " + Thread.currentThread().getName() + " coge 2 tenedores");
            if(i == 0) fork[N-1] = fork[N-1] - 1;
            else fork[i-1] = fork[i-1] - 1;
    
            if(i == N-1) fork[0] = fork[0] - 1;
            else fork[i+1] = fork[i+1] - 1;
        
        }finally{L.unlock();}        
    }

    public void releaseForks(int i)
    {
        L.lock();
        try
        {
            i--;
            int aux1, aux2;
            if(i == N-1) aux1 = 0;
            else aux1 = i+1;
            
            if(i == 0) aux2 = N-1;
            else aux2 = i-1;
            
            System.out.println("Hilo " + Thread.currentThread().getName() + " suelta 2 tenedores");
            fork[aux1] = fork[aux1] + 1;
            fork[aux2] = fork[aux2] + 1;
            
            if(fork[aux1] == 2)
                C[aux1].signal();
            if(fork[aux2] == 2)
                C[aux2].signal();

        }finally{L.unlock();} 
    }
}
