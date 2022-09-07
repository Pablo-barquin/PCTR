/**
 * @author Pablo Velicias Barquín
 */
public class usaforkMonitor extends Thread{
    public forkMonitor Monitor;
    public int id;

    /**
     * Constructor de la clase
     * @param id    Identificador del filosofo, desde 1 hasta N filosofos
     * @param mon   Monitor que vamos a usar
     */
    usaforkMonitor(int id, forkMonitor mon)
    {
        this.id = id;
        this.Monitor = mon;
    }

    /**
     * Metodo run() para las hebras
     */
    public void run()
    {
        try
        {
            sleep(10);
            Monitor.takeForks(id);
            sleep(1000);
            Monitor.releaseForks(id);
        }catch(InterruptedException e){}
    }

    public static void main(String[] args) throws Exception {
        int Filosofos = 5;
        forkMonitor monitorUso = new forkMonitor(Filosofos);

        Thread[] hilos = new Thread[Filosofos];
        for(int i=0; i<Filosofos; i++) hilos[i] = new usaforkMonitor(i+1, monitorUso);
        
        for(int i=0; i<Filosofos; i++) hilos[i].start();
        for(int i=0; i<Filosofos; i++) hilos[i].join();
    }
}
