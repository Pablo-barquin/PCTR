
public class escalaVPar extends Thread{
    static double[] vector = new double[9*1000000];
    private int limiteinf = 0, limitesup = 0;

    escalaVPar(int inf, int sup)
    {
        this.limiteinf = inf;
        this.limitesup = sup;
    }

    public void run()
    {
        int i=0;
        for(i=this.limiteinf; i<this.limitesup; i++)
        {
            vector[i] = vector[i] * 5;
        }
    }

    public static void main(String[] args) throws Exception
    {
        int linf        = 0;
        int numHilos    = 8;
        int tam         = vector.length/numHilos;
        int i           = 0;

        escalaVPar[] hilos = new escalaVPar[numHilos];
        
        for(int j=0; j<vector.length; j++) vector[j] = Math.random();
        while(linf < vector.length)
        {
            hilos[i] = new escalaVPar(linf, linf+tam);
            i++;
            linf += tam;
        }

        for(i=0; i< numHilos; i++) hilos[i].start();
        for(i=0; i< numHilos; i++) hilos[i].join();
    }
}
