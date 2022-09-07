import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pablo Velicias Barquín
 */
public class usaheterogenea implements Runnable{
    private heterogenea hp;
    private int caso;

    /**
     * Constructor de la clase
     * @param in Clase de tipo heterogenea
     * @param valor Tipo de acción que va a realizar el hilo
     */
    usaheterogenea(heterogenea in, int valor)
    {
        this.hp = in;
        caso = valor;
    }

    /**
     * Metodo run() de la clase
     */
    public void run()
    {
        switch(caso)
        {
            case 0: for(int i=0; i<10000; i++) hp.ConCerrojo(); break;
            case 1: for(int j=0; j<10000; j++) hp.SinCerrojo(); break;
            default: System.out.print("ERROR. Tipo de hilo no permitido");
        }
    }

    public static void main(String[] args) throws Exception
    {
        heterogenea monitor = new heterogenea();
        
        int NumHebras = 20;
        System.out.println("Num. de hebras en total que se van a utilizar: " + NumHebras);
        System.out.println("Se utilizan " + NumHebras/2 + " hebras para incrementar cada valor 10000 veces");
    
        ExecutorService pool = Executors.newFixedThreadPool(NumHebras);

        for(int i=0; i<NumHebras; i++) 
        {
            pool.execute(new usaheterogenea(monitor, i%2));
        }

        pool.shutdown();
        while(!pool.isTerminated());

        System.out.println("\nResultado Deseado: " + (NumHebras/2)*10000);
        System.out.println("Valor N (Synchronized): " + heterogenea.n + "|| Valor M (No Synchronized): " + heterogenea.m);
    
    }

}
