import java.net.*;
import java.util.concurrent.*;
import java.io.*;

/**
 * @author Pablo Velicias Barquín
 */
public class ServidorHiloconPool implements Runnable{
    
    Socket enchufe;

    /**
     * Constructor de la clase
     * @param s Socket recibido
     */
    ServidorHiloconPool(Socket s)
    {
        this.enchufe = s;
    }
    
    /**
     * Metodo run() para los hilos
     */
    public void run()
    {
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(enchufe.getInputStream()));
            String datos = entrada.readLine();
            int j;
            int i = Integer.valueOf(datos).intValue();
            for(j=1; j<=20; j++)
            {
                System.out.println("El hilo "+Thread.currentThread().getName()+" escribiendo el dato "+i);
                Thread.sleep(1000);
            }
            enchufe.close();
            System.out.println("El hilo "+Thread.currentThread().getName()+" cierra su conexion...");
        
        }catch(Exception e) {System.out.println("Error...");}
    }

    public static void main (String[] args){
        int puerto = 2001;
        int NumHilos = Runtime.getRuntime().availableProcessors();

        ThreadPoolExecutor Pool = new ThreadPoolExecutor(NumHilos, NumHilos, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

            try{
                ServerSocket chuff = new ServerSocket (puerto, 3000);
                while (true)
                {
                    System.out.println("Esperando solicitud de conexion...");
                    Socket cable = chuff.accept();
                    System.out.println("Recibida solicitud de conexion...");
                    Runnable aux = new ServidorHiloconPool(cable);
                    Pool.execute(aux);
                }
            } catch (Exception e)
            {System.out.println("Error en sockets...");}
    }
}
