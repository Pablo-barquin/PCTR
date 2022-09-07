/**
 * @author Pablo Velicias Barquín
 */
public class UsamonitorImpresion extends Thread{
    public monitorImpresion Monitor;
    public int ID_Impresora;

    /**
     * Constructor de la clase 
     * @param mon   Indica el monitor que se va a usar
     */
    UsamonitorImpresion(monitorImpresion mon)
    {
        this.Monitor = mon;
    }

    /**
     * Metodo run() para las hebras
     */
    public void run()
    {
        try
        {
            this.ID_Impresora = Monitor.take_print();
            sleep(1000);
            Monitor.drop_print(ID_Impresora);
        }catch(InterruptedException e){}
    }

    public static void main(String[] args) throws Exception{
        monitorImpresion MonitorUso = new monitorImpresion();
        int Procesos = 6;

        Thread[] hilos = new Thread[Procesos];
        for(int i=0; i<Procesos; i++) hilos[i] = new UsamonitorImpresion(MonitorUso);

        for(int i=0; i<Procesos; i++) hilos[i].start();
        for(int i=0; i<Procesos; i++) hilos[i].join();        
    }
}
