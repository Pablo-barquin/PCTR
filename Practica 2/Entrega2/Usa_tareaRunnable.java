import java.util.Scanner;

public class Usa_tareaRunnable {

    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introduzca el numero de iteraciones a realizar: ");
        int Niter = in.nextInt();
        

        Critica p = new Critica();
        Runnable h1 = new tareaRunnable(Niter, 0, p);
        Runnable h2 = new tareaRunnable(Niter, 1, p);

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
