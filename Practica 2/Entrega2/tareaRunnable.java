public class tareaRunnable implements Runnable{
    
    private int tipoHilo;
    private int nIter;
    private Critica c;

    tareaRunnable(int num, int tipo, Critica c)
    {
        this.nIter = num;
        this.tipoHilo = tipo;
        this.c = c;
    }

    public void run()
    {
        switch(tipoHilo)
        {
           case 0: for(int i=0; i<nIter; i++) c.inc(); break;
           case 1: for(int j=0; j<nIter; j++) c.dec(); break;

           default: System.out.println("Operacion no valida");
        }
    }
}
