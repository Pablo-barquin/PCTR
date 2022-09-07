/**
 * @author Pablo Velicias Barquín
 */
public class tareaLambdaSeguro{

  public static int n = 0;

  public static void main (String[] args) throws Exception{

    Object monitor = new Object();
    
    Runnable r1 = () -> { synchronized(monitor) { for(int i = 0; i < 10000; ++i) ++n; } };
    Runnable r2 = () -> { synchronized(monitor) { for(int i = 0; i < 10000; ++i) --n; } };
    
    Thread p1 = new Thread(r1);
    Thread p2 = new Thread(r2);

    p1.start(); p2.start();
    p1.join();  p2.join();

    System.out.println(n);
  }
}