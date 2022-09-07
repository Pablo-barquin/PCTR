/**
 * @author Pablo Velicias Barquín
 */
public class drakkarVikingo {

    private int anguilas;

    /**
     * Constructor de la clase
     * @param s Valor inicial de anguilas
     */
    drakkarVikingo(int s)
    {
        this.anguilas = s;
    }

    /**
     * Metodo WaitS de las hebras
     */
    public synchronized void Comer()
    {
        while(anguilas == 0)
        {
            try
            {
                System.out.println("Hilo " + Thread.currentThread().getName() + " espera a los cocineros");
                notifyAll();
                wait();
            }catch(InterruptedException e){}
        }
        System.out.println("Hilo " + Thread.currentThread().getName() + " come una anguila");
        anguilas--;
    }

    /**
     * Metodo SignalS de las hebras
     */
    public synchronized void Cocinar()
    {
        while(anguilas > 0)
        {
            try
            {
                System.out.println("Hilo " + Thread.currentThread().getName() + " espera a que se consuman las anguilas");
                wait();
            }catch(InterruptedException e){}            
        }
        anguilas++;
        System.out.println("Hilo " + Thread.currentThread().getName() + " ha cocinado anguila");
        notifyAll();
    }
}