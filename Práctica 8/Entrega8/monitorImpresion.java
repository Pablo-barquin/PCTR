/**
 * @author Pablo Velicias Barquín
 */
public class monitorImpresion {
    private int impresoras;
    private boolean[] Libres;
    
    /**
     * Constructor para inicializar la clase
     */
    monitorImpresion()
    {
        impresoras = 3;
        Libres = new boolean[3];
        for(int i=0; i<impresoras; i++) Libres[i] = true;
    }

    /**
     * Metodo para asignar una impresora disponible a una hebra
     * @return  Devuelve la impresora que ha sido seleccionada a esa hebra
     */
    public synchronized int take_print()
    {
        while(impresoras == 0)
        {
            try
            {
                System.out.println("Hilo " + Thread.currentThread().getName() + " esperando impresora libre");
                wait();
            }catch(InterruptedException e){}
        }

        int aux = 0;
        while(!Libres[aux]) aux++;
        Libres[aux] = false;
        impresoras--;
        System.out.println("Hilo " + Thread.currentThread().getName() + " ocupa la impresora " + (aux+1));
        return aux;
    }

    /**
     * Metodo para liberar una impresora ocupada por una hebra
     * @param i La impresora que va a ser liberada
     */
    public synchronized void drop_print(int i)
    {
        Libres[i] = true;
        impresoras++;
        System.out.println("Hilo " + Thread.currentThread().getName() + " deja la impresora " + (i+1) + " libre");
        notifyAll();
    }
}
