/**
 * @author Pablo Velicias Barquín
 */
public class tryThree extends Thread {
    //Inicializamos Variables
	private static volatile int nVueltas = 100000;
	private static volatile int n = 0, c1, c2;
    int tipoHilo;

    /**
     * 
     * @param tipo Indica el tipo de proceso que va a realizar
     */
    tryThree(int tipo)
    {
        this.tipoHilo = tipo;
    }

    /**
     * Metodo run() para los hilos
     */
    public void run()
    {
        switch(tipoHilo)
        {
            case 1:
            {
                for(int i=0; i<nVueltas; i++)
                {
                    c1 = 0;
                    while(c2 == 0);
                    n++;
                    c1 = 1;
                }
                break;
            }
            case 2:
            {
                for(int i=0; i<nVueltas; i++)
                {
                    c2 = 0;
                    while(c1 == 0);
                    n--;
                    c2 = 1;
                }
                break;
            }
            default: System.out.println("Tipo Incorrecto. Error"); 
        }
    }

    public static void main(String[] args) throws Exception
    {
        c1 = 1;
        c2 = 1;

        tryThree P1 = new tryThree(1);
        tryThree P2 = new tryThree(2);

        P1.start(); P2.start();
        P1.join(); P2.join();

        System.out.println(n);

    }



}
