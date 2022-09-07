import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author Pablo Velicias Barquín
 */
public class integCallable implements Callable {
    
    long n=0;
    long inicio, fin;

    /**
     * Constructor de la clase
     * @param in Inicio del segmento
     * @param fn Fin del segmento
     */
    integCallable(long in, long fn)
    {
        this.inicio = in;
        this.fin = fn;
    }


    /**
     * Metodo call() para los hilos
     */
    public Long call()
    {
        Random r = new Random();
        double coorX, coorY;
        for(long i=inicio; i<fin; i++)
        {
            coorX = r.nextDouble();
            coorY = r.nextDouble();

            if(coorY <= Math.cos(coorX))
                n++;
        }
        
        return n;
    }

    public static void main(String[] args)
    { 
        Scanner in = new Scanner(System.in);
        long resultado = 0;
        System.out.print("Introduzca el numero de iteraciones del bucle: ");
        long NumeroPuntos = in.nextInt();
        int NumHilos = Runtime.getRuntime().availableProcessors();

        ArrayList<Future<Long>> ContParcial = new ArrayList<Future<Long>>();
        ExecutorService Pool = Executors.newFixedThreadPool(NumHilos);

        int it=0, inicio=0, tam=(int)(NumeroPuntos/NumHilos);
        while(it < NumHilos && inicio < NumeroPuntos)
        {
            if(it == NumHilos-1 || tam == 0)
            {
                ContParcial.add(Pool.submit(new integCallable(inicio, inicio+tam)));
                it = NumHilos;
            }
            else
            {
                ContParcial.add(Pool.submit(new integCallable(inicio, inicio+tam)));
                it++;
                inicio += tam;
            }
        }

        for(Future<Long> iterador:ContParcial)
        {
            try
            {
                resultado += iterador.get();
            }catch(ExecutionException e){}
             catch(InterruptedException e){}
             catch(CancellationException e){}
        }

        Pool.shutdown();

        float res = ((float)resultado/(float)NumeroPuntos);

        System.out.println("La aproximacion para cos(x) es: " + res);

        in.close();
    }
}
