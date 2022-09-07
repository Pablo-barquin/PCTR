import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pablo Velicias Barquín
 */
public class usaProdConAn implements Runnable {
    prodConAN prod1;
    int Accion;
    
    /**
     * Constructor de la clase 
     * @param pr    Clase donde se encuentran los metodos y que compartiran los hilos
     * @param tipoHilo  Tipo de accion que va a realizar el hilo
     */
    usaProdConAn(prodConAN pr, int tipoHilo)
    {
        this.prod1 = pr;
        this.Accion = tipoHilo;
    }

    /**
     * Metodo run() para las hebras
     */
    public void run()
    {
        switch(Accion)
        {
            case 0: for(int i=0; i<10000; i++) prod1.append(i); break;
            case 1: for(int i=0; i<10000; i++) prod1.take(); break;
            default: System.out.println("Tipo de accion incorrecta (Solo 0 o 1)");
        }
    }

    public static void main(String[] args) throws Exception {
        int NumHebras = 6;
        prodConAN prod = new prodConAN();

        ExecutorService pool = Executors.newFixedThreadPool(NumHebras);

        Runnable aux;
        for(int i=0; i<NumHebras; i++)
        {
            aux = new usaProdConAn(prod, i%2);
            pool.execute(aux);
        }

        pool.shutdown();
        while(!pool.isTerminated());
    }
}
