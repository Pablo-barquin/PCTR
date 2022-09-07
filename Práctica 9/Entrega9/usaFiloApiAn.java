import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pablo Velicias Barquín
 */
public class usaFiloApiAn implements Runnable{
    filoApiAN filosofos;
    int id;
   
    usaFiloApiAn(filoApiAN fil, int ID)
    {
       this.filosofos = fil;
       this.id = ID;
    }

    public void run()
    {
        try
        {
            filosofos.takeForks(id);
            Thread.sleep(1000);
            filosofos.releaseForks(id);
        }catch(InterruptedException e){}
    }

    public static void main(String[] args) throws Exception{
       
        int NumFilosofos = 5;
        filoApiAN Mifilo = new filoApiAN(NumFilosofos);

        ExecutorService pool = Executors.newFixedThreadPool(NumFilosofos);

        Runnable aux;
        for(int i=0; i<NumFilosofos; i++)
        {
            aux = new usaFiloApiAn(Mifilo, i+1);
            pool.execute(aux);
        }

        pool.shutdown();
        while(!pool.isTerminated());
    }
}
