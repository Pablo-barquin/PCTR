/**
 * @author Pablo Velicias Barquín
 */
public class cajeroSeguro implements Runnable {
    
    private cuentaCorriente A;
    private int metodo = 0;
    private int dinero = 0;
    private Object lock;

    /**
     * Constructor de la clase
     * @param Aux Objeto de la clase cuentaCorriente
     * @param accion Acción que vamos a realizar
     * @param dinero2 Dinero que vamos a usar en nuestra acción
     * @param p Objeto que sirve para sinchronized
     */
    cajeroSeguro(cuentaCorriente Aux, int accion, int dinero2, Object p)
    {
        A = Aux;
        this.metodo = accion;
        this.dinero = dinero2;
        this.lock = p;
    }

    /**
     * Función run() de los hilos
     */
    public void run()
    {
        synchronized(lock)
        {    
            switch(metodo)
            {
                case 0: for(int i=0; i<2000; i++) A.deposito(dinero); break;
                case 1: for(int i=0; i<2000; i++) A.reintegro(dinero); break;

                default: System.out.print("No se puede realizar la operacion");
            }
        }
    }
}
