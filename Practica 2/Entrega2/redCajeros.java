import java.util.Scanner;

public class redCajeros {
   
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        
        cuentaCorriente C1 = new cuentaCorriente(10239);

        Runnable cajero1 = new cajero(C1, 1, 10);
        Runnable cajero2 = new cajero(C1, 0, 10);
      
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
