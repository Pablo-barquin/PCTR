/**
 * @author Pablo Velicias Barquín
 */
public class lectorEscritor {
    private int readers, writers;
    
    /**
     * Constructor de la clase
     * @param s Estado inicial de lectores
     * @param p Estado inicial de escritores
     */
    lectorEscritor(int s, int p)
    {
        this.readers = s;
        this.writers = p;
    }

    /**
     * Función StarRead() para comprobar que se puede empezar a leer
     */
    public synchronized void StartRead()
    {
        while(writers != 0)
        {
            try
            {
                System.out.println("Hilo " + Thread.currentThread().getName() + " espera a los escritores");
                wait();
            }catch(InterruptedException e){}
        }
        readers++; 
        System.out.println("Hilo " + Thread.currentThread().getName() + " comienza a leer");
        notifyAll();
    }

    /**
     * Función EndRead() para avisar de que se ha acabado de leer
     */
    public synchronized void EndRead()
    {
        readers--;
        System.out.println("Hilo " + Thread.currentThread().getName() + " termina de leer");
        if(readers == 0)
            notifyAll();
    }

    /**
     * Función StartWrite() para comprobar que se puede empezar a escribir
     */
    public synchronized void StartWrite()
    {
        while(writers != 0 || readers != 0)
        {
            try
            {
                System.out.println("Hilo " + Thread.currentThread().getName() + " espera a lectores y escritores");
                wait();
            }catch(InterruptedException e){}
        }
        System.out.println("Hilo " + Thread.currentThread().getName() + " comienza a escribir");
        writers++;
    }

    /**
     * Función EndWrite() para avisar que se ha finalizado de escribir
     */
    public synchronized void EndWrite()
    {
        writers--;
        System.out.println("Hilo " + Thread.currentThread().getName() + " termina de escribir");
        notifyAll();
    }
}
