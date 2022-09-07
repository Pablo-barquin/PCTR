public class hebra extends Thread {
    
    private int tipoHilo;
    public static int n=0;
    private int nVueltas;

    public hebra(int nVueltas, int tipoHilo)
    {
        this.nVueltas = nVueltas;
        this.tipoHilo = tipoHilo;
    }
    
    public void run()
    {
        switch(tipoHilo)
        {
            case 0: for(int i=0; i<nVueltas; i++) n++; break;
            case 1: for(int i=0; i<nVueltas; i++) n--; break;
        }
    }
}
