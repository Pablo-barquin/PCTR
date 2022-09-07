/**
 * @author Pablo Velicias Barquín
 */
public class numPerfectos {
    
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
        long intervalo = Long.parseLong(args[0]), num = 0;
        int total = 0;

        long inicTiempo = System.currentTimeMillis();
        for(long i=0; i<=intervalo; i++)
        {
            num = Potencia(2, i)-1;
            if(Potencia(2, i-1) * num > 0 && Potencia(2, i-1) * num <= intervalo)
            {
                if(esPrimo(num))
                {
                    System.out.println("Numero Perfecto: " + (Potencia(2, i-1) * num));
                    total++;
                }
            }
        }
        long tiempoTotal = System.currentTimeMillis() - inicTiempo;

        System.out.println("Encontrados " + total + " numeros perfectos" + " en " + tiempoTotal + " milisegundos");
    }
}