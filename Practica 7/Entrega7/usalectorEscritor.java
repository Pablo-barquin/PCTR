/**
 * @author Pablo Velicias Barquín
 */
public class usalectorEscritor extends Thread {
    
    public lectorEscritor lecEsc;
    public int tipo;
    
    /**
     * Constructor de la clase
     * @param s Monitor para los hilos
     */
    usalectorEscritor(lectorEscritor s, int tipoHilo)
    {
        this.lecEsc = s;
        this.tipo = tipoHilo;
    }

    /**
     * Metodo run() de los hilos
     */
    public void run()
    {
        try
        {
            switch(tipo)
            {
                case 0:  sleep(10); lecEsc.StartRead(); sleep(1000); lecEsc.EndRead(); sleep(10); break;
                case 1:  lecEsc.StartWrite();  sleep(1000); lecEsc.EndWrite(); break;
                default: System.out.println("Error, tipo de hilo incorrecto (0 o 1)");
            }  
        }catch(InterruptedException e){}
 
    }

    public static void main(String[] args) throws Exception {
        lectorEscritor lE = new lectorEscritor(0, 0);

        Thread Lector1 = new usalectorEscritor(lE, 0);
        Thread Lector2 = new usalectorEscritor(lE, 0);
        Thread Escritor1 = new usalectorEscritor(lE, 1);
        Thread Escritor2 = new usalectorEscritor(lE, 1);       

        Lector1.start(); Escritor1.start(); Lector2.start(); Escritor2.start();
        Lector1.join(); Escritor1.join(); Lector2.join(); Escritor2.join();
    }
}
