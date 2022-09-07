/**
 * @author Pablo Velicias Barquín
 */
public class forkMonitor {

    private int[] fork;
    private int N;

    /**
     * Constructor de la clase 
     * @param Filosofos Nº de filosofos que vamos a inicializar
     */
    forkMonitor(int Filosofos)
    {
        fork = new int[Filosofos];
        N = Filosofos;
        for(int i=0; i<N; i++) fork[i] = 2;
    }

    /**
     * Metodo para Coger Palillos (La traducción es tenedor, pero queda mejor con palillos)
     * @param i Indica que filosofo va a coger palillos
     */
    public synchronized void takeForks(int i)
    {
        i--;
        while(fork[i] != 2)
        {
            try
            {
                System.out.println("Filosofo " + Thread.currentThread().getName() + " esperando palillos libres");
                wait();
            }catch(InterruptedException e) {}
        }
        System.out.println("Filosofo " + Thread.currentThread().getName() + " coge dos palillos");
        if(i == 0) fork[N-1]--;
        else fork[i-1]--;

        if(i == N-1) fork[0]--;
        else fork[i+1]--;
    }

    /**
     * Metodo para Soltar Palillos
     * @param i Indica que filósofo va a soltar los palillos
     */
    public synchronized void releaseForks(int i)
    {
        int aux1, aux2;
        System.out.println("Filosofo " + Thread.currentThread().getName() + " suelta dos palillos");        
        i--;
        if(i == 0) aux1 = N-1;
        else aux1 = i-1;

        if(i == N-1) aux2 = 0;
        else aux2 = i+1; 

        fork[aux1]++;
        fork[aux2]++;


        if(fork[aux1] == 2 || fork[aux2] == 2)
            notifyAll();
    }
}