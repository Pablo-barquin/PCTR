/**
 * @author Pablo Velicias Barquín
 */
public class algDekker extends Thread {
    //Inicializamos Variables
    private static volatile int Turno = 1;
	private static volatile int nVueltas = 1000000;
	private static volatile int n = 0, c1, c2;
    private int tipoHilo;

    /**
     * Constructor de la clase
     * @param tipo Indica el proceso que va a realizar el hilo
     */
    algDekker(int tipo) { this.tipoHilo = tipo; }

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
                    while(c2 == 0)
                    {
                        if(Turno == 2) 
                        {
                            c1 = 1;
                            while(Turno == 2);
                            c1 = 0;
                        }
                    }
                    n++;
                    Turno = 2;
                    c1 = 1;
                }
                break;
            }
            case 2:
            {
                for(int i=0; i<nVueltas; i++)
                {
                    c2 = 0;
                    while(c1 == 0)
                    {
                        if(Turno == 1) 
                        {
                            c2 = 1;
                            while(Turno == 1);
                            c2 = 0;
                        }
                    }
                    n--;
                    Turno = 1;
                    c2 = 1;
                }
                break;
            }
            default: System.out.println("Tipo Incorrecto. ERROR");
        }
    }

    public static void main(String[] args) throws Exception
    {
        c1 = 1;
        c2 = 1;
        Turno = 1;
        algDekker P1 = new algDekker(1);
        algDekker P2 = new algDekker(2);

        P1.start(); P2.start();
        P1.join(); P2.join();

        System.out.println(n);
    }
}
