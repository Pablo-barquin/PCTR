import java.util.Scanner;

/**
 * @author Pablo Velicias Barquín
 */
public class Usa_hebraSeguro {
    
    public static void main(String[] args) throws Exception
    {
        Object monitor = new Object();
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduzca el numero de iteraciones a realizar: ");
        int Niter = in.nextInt();
        
        hebraSeguro p = new hebraSeguro(Niter, 0, monitor);
        hebraSeguro q = new hebraSeguro(Niter, 1, monitor);

        p.start();
        q.start();

        p.join();
        q.join();

        System.out.print("N = " + hebraSeguro.n);

        in.close();
    }
}
