/**
 * @author Pablo Velicias Barquín
 */
public class usaDrakkarVikingo extends Thread{
    
    public int tipo = 0;
    public drakkarVikingo barco;

    /**
     * Constructor de la clase
     * @param b Valor que se le asigna barco
     */
    usaDrakkarVikingo(drakkarVikingo b, int tipoHilo)
    {
        this.barco = b;
        this.tipo = tipoHilo;
    }

    /**
     * Metodo run() de los hilos
     */
    public void run()
    {             
        switch(tipo)
        {
            case 0: for(int i=0; i<20; i++) barco.Comer(); break;
            case 1: for(int i=0; i<10; i++) barco.Cocinar(); break;
            default: System.out.println("Error, tipo de hilo incorrecto (0 o 1)");
        }       
    }

    public static void main(String[] args) throws Exception
    {
        drakkarVikingo barco = new drakkarVikingo(10);

        Thread VikingoA = new usaDrakkarVikingo(barco, 0);
        Thread VikingoB = new usaDrakkarVikingo(barco, 1);

        VikingoA.start(); VikingoB.start();
        VikingoA.join(); VikingoB.join();
    }
}
