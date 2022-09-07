/**
 * @author Pablo Velicias Barquín
 */
public class usaProdCon extends Thread {
    public PCMonitor Mon;
    public int tipo;

    /**
     * Constructor de la clase
     * @param pc    Indica el monitor que va a usar
     * @param tipoHilo  Indica el tipo de hilo que va a ser
     */
    usaProdCon(PCMonitor pc, int tipoHilo)
    {
        this.Mon = pc;
        this.tipo = tipoHilo;
    }

    /**
     * Metodo run() para los hilos
     */ 
    public void run()
    {
        switch(tipo)
        {
            case 0:  Mon.Append(0); break;
            case 1:  Mon.Take(); break;
        }
    }

    public static void main(String[] args) throws Exception {
        PCMonitor MiMonitor = new PCMonitor();

        Thread A1 = new usaProdCon(MiMonitor, 0);
        Thread B1 = new usaProdCon(MiMonitor, 1);
        Thread B2 = new usaProdCon(MiMonitor, 0);

        A1.start(); B1.start(); B2.start();
        A1.join(); B1.join(); B2.join();
        
    }
}
