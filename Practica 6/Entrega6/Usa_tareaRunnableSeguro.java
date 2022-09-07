import java.util.Scanner;

/**
 * @author Pablo Velicias Barquín
 */
public class Usa_tareaRunnableSeguro {

    public static void main(String[] args) throws Exception
    {
        Object monitor = new Object();
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduzca el numero de iteraciones a realizar: ");
        int Niter = in.nextInt();
        

        Critica p = new Critica();
        Runnable h1 = new tareaRunnableSeguro(Niter, 0, p, monitor);
        Runnable h2 = new tareaRunnableSeguro(Niter, 1, p, monitor);

        Thread A = new Thread(h1);
        Thread B = new Thread(h2);

        A.start();
        B.start();

        A.join();
        B.join();

        System.out.print("N = " + p.vDato());

        in.close();
    }
}
