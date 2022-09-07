import java.util.Scanner;

public class Usa_hebra {
    
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduzca el numero de iteraciones a realizar: ");
        int Niter = in.nextInt();
        
        hebra p = new hebra(Niter, 0);
        hebra q = new hebra(Niter, 1);

        p.start();
        q.start();

        p.join();
        q.join();

        System.out.print("N = " + hebra.n);

        in.close();
    }
}
