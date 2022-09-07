import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author Pablo Velicias Barquín
 */
public class numPerfectosParalelo implements Callable{

    long inicio, fin;
    long num, total=0;

    /**
     * Constructor de la clase
     * @param linf Inicio del hilo
     * @param lsup Fin del rango de trabajo del hilo
     */
    public numPerfectosParalelo(long linf, long lsup)
    {
        this.inicio = linf;
        this.fin = lsup;
    }
    
    /**
     * Comprueba que es primo 
     * @param n Numero a comprobar
     * @return Devuelve true o false
     */
    public static boolean esPrimo(long n){
        if(n<=1) return(false);
        for(long i=2; i<=Math.sqrt(n); i++)
          if(n%i == 0) return(false);
        return(true);
    }

    /**
     * Metodo call para los hilos
     */
    public Long call()
    {
        
        for(long i=inicio; i<=fin; i++)
        {
            num = Potencia(2, i)-1;
            if(Potencia(2, i-1) * num > 0 && Potencia(2, i-1) * num <= fin)
            {
                if(esPrimo(num))
                {
                    System.out.println("Numero Perfecto: " + (Potencia(2, i-1) * num));
                    total++;
                }
            }
        }

        return total;
    }

    /**
     * Realiza la potencia para numeros Long
     * @param a Número
     * @param b Exponente
     * @return  Potencia realizada
     */
    public static long Potencia(long a, long b)
    {
        long num = 1;
        for(int i=0; i<b; i++)
        {
            num = num*a;
        }
        
        return num;
    }

    public static void main(String[] args) throws Exception
    {
        long intervalo = Long.parseLong(args[0]);
        int NumHilos = Runtime.getRuntime().availableProcessors();
        long numerostotal = 0;
        long linf = 0;
        long lsup = 0; 

        ArrayList<Future<Long>> contParciales = new ArrayList<Future<Long>>();

        long tam = intervalo/NumHilos;

        long inicTiempo = System.currentTimeMillis();
        ThreadPoolExecutor ept = new ThreadPoolExecutor(
            NumHilos,
            NumHilos,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());
        
        int i = 0;
        while(i < NumHilos && tam <= intervalo)
        {
            if(i == NumHilos-1 || tam == 0)
            {
                contParciales.add(ept.submit(new numPerfectosParalelo(linf, intervalo)));
                i = NumHilos;
            }
            else
            {
                contParciales.add(ept.submit(new numPerfectosParalelo(linf, lsup)));
                linf = lsup+1;
                lsup += tam; 
                i++;             
            }

        }

        for(Future<Long> iterador:contParciales)
            try{
                numerostotal +=  iterador.get(); 
            }catch (CancellationException e){}
            catch (ExecutionException e){}
            catch (InterruptedException e){} 

        long tiempoTotal = System.currentTimeMillis() - inicTiempo;   
        ept.shutdown();
        
        System.out.println("Encontrados " + numerostotal + " numeros perfectos" + " en " + tiempoTotal + " milisegundos");

    }
}