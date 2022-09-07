/**
 * @author Pablo Velicias Barquín
 */
public class tryFour extends Thread{
    //Inicializamos Variables
	private static volatile int nVueltas = 100000;
	private static volatile int n = 0, c1, c2;
    int tipoHilo;

    /**
     * 
     * @param tipo Indica que tipo de proceso va a ejecutar
     */
    public tryFour(int tipo)
    {
        this.tipoHilo = tipo;
    }

    /**
     * Metodo run() para los hilos
     * */
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
                        c1 = 1;
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        c1 = 0;
                    }
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
                    while(c1 == 0)
                    {
                        c2 = 1;
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        c2 = 0;
                    }
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

        tryFour P1 = new tryFour(1);
        tryFour P2 = new tryFour(2);

        P1.start(); P2.start();
        P1.join(); P2.join();

        System.out.println(n);
    }
}
