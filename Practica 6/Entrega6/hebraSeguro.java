/**
 * @author Pablo Velicias Barquín
 */
public class hebraSeguro extends Thread{
    
    private Object lock;
    private int tipoHilo;
    public static int n=0;
    private int nVueltas;

    /**
     * Constructor de la clase
     * @param nVueltas Numero de repeticiones del bucle
     * @param tipoHilo Tipo de acción que va a realizar el hilo
     * @param p Objeto que sirve para Synchronized
     */
    public hebraSeguro(int nVueltas, int tipoHilo, Object p)
    {
        this.nVueltas = nVueltas;
        this.tipoHilo = tipoHilo;
        this.lock = p;
    }
    
    /**
     * Metodo run() de los hilos
     */
    public void run()
    {
        synchronized(lock)
        {  
            switch(tipoHilo)
            {
                case 0: for(int i=0; i<nVueltas; i++) n++; break;
                case 1: for(int i=0; i<nVueltas; i++) n--; break;
            }
        }
    }
}
