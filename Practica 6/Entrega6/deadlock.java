/**
 * @author Pablo Velicias Barquín
 */
public class deadlock extends Thread{

    private static Object[] lock;
    int valor;

    /**
     * Constructor de la clase
     * @param v Indica que metodo va a ejecutar el hilo
     */
    deadlock(int v)
    {
        this.valor = v;
    }

    /**
     * Metodo run() para los hilos
     */
    public void run()
    {
        try
        {
            switch(valor)
            {
                case 0: MetodoA(); break;
                case 1: MetodoB(); break;
                case 2: MetodoC(); break;
            }
        }catch(Exception e){}
    }

    /**
     * MetodoA que usa código Synchronized
     * @throws Exception
     */
    private void MetodoA() throws Exception
    {
        synchronized(lock[0]){
            sleep(100);
            System.out.println("Hilo 1 Esperando Hilo 2");
            synchronized(lock[1]){                 
                    System.out.println("Hilo 1 Ejecutado");
            }
        }
    }

    /**
     * MetodoB que usa código Synchronized
     * @throws Exception
     */
    private void MetodoB() throws Exception
    {
        synchronized(lock[1]){
            sleep(100);
            System.out.println("Hilo 2 Esperando Hilo 3");
            synchronized(lock[2]){              
                    System.out.println("Hilo 2 Ejecutado");
                
            }
        }
    }

    /**
     * MetodoC que usa código Synchronized
     * @throws Exception
     */
    private void MetodoC() throws Exception
    {
        synchronized(lock[2]){
            sleep(100);
            System.out.println("Hilo 3 Esperando Hilo 1");
            synchronized(lock[0]){
                System.out.println("Hilo 3 Ejecutado");
                
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        Object[] monitor = new Object[3];
        Thread[] hilos = new Thread[3];

        for(int i=0; i<3; i++) monitor[i] = new Object();
        lock = monitor;
        for(int i=0; i<3; i++) hilos[i] = new deadlock(i);

        for(int i=0; i<3; i++) hilos[i].start();
        for(int j=0; j<3; j++) hilos[j].join();

        System.out.println("Codigo Finalizado");
    
    }
}
