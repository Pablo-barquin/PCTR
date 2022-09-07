public class algHyman implements Runnable{
    private static volatile int n = 0;
    private static volatile int c1, c2, turno;
    private int tipoHilo;

    public algHyman(int tipo)
    {
        this.tipoHilo = tipo;
    }

    public void run()
    {
        switch(tipoHilo)
        {
            case 1:
            {
                for(int i=0; i<100000; i++)
                {
                    c1 = 0;
                    while(turno != 1) 
                    {
                        while(c2 == 0);
                        turno = 1;
                    }
                    n++;
                    c1 = 1;
                }
                break;
            }
            case 2:
            {
                for(int i=0; i<100000; i++)
                {
                    c2 = 0;
                    while(turno != 2) 
                    {
                        while(c1 == 0);
                        turno = 2;
                    }
                    n--;
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
        turno = 1;

        Runnable a = new algHyman(1);
        Runnable b = new algHyman(2);

        Thread P1 = new Thread(a);
        Thread P2 = new Thread(b);

        P1.start(); P2.start();
        P1.join(); P2.join();

        System.out.println(n);
    }
}
