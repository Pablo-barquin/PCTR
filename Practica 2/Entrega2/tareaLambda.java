public class tareaLambda{

  public static int n = 0;

  public static void main (String[] args) throws Exception{

    Runnable r1 = () -> { for(int i = 0; i < 10000; ++i) ++n; };
    Runnable r2 = () -> { for(int i = 0; i < 10000; ++i) --n; };
    
    Thread p1 = new Thread(r1);
    Thread p2 = new Thread(r2);

    p1.start(); p2.start();
    p1.join();  p2.join();

    System.out.println(n);
  }
}