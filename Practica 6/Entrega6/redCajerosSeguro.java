import java.util.Scanner;

/**
 * @author Pablo Velicias Barquín
 */
public class redCajerosSeguro {
   
    public static void main(String[] args) throws Exception
    {
        Object monitor = new Object();
        Scanner in = new Scanner(System.in);
        
        cuentaCorriente C1 = new cuentaCorriente(10239);

        Runnable cajero1 = new cajeroSeguro(C1, 1, 10, monitor);
        Runnable cajero2 = new cajeroSeguro(C1, 0, 10, monitor);
      
        Thread A = new Thread(cajero1);
        Thread B = new Thread(cajero2);

        A.start();
        B.start();

        A.join();
        B.join();


        System.out.println("La cuentaCorriente1 tiene de saldo actual = " + cuentaCorriente.saldo);

        in.close();
    }
}
