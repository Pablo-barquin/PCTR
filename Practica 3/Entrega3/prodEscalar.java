/**
* @author Pablo Velicias Barquín
*/

public class prodEscalar{
    
    public static void main(String[] args)
    {
        //Para obtener el tiempo de la operación
        long duracionTotal;
        long ini;
        
        //Declaramos los vectores que vamos a usar
        int[] v1 = new int[1000000];
        int[] v2 = new int[1000000];
        int vFinal = 0;
        
        //Inicializamos los vectores con datos aleatorios entre 0 y 5
        for(int i=0; i<v1.length; i++)
        {
            v1[i] = (int)(Math.random()*5);
            v2[i] = (int)(Math.random()*5);
        } 

        ini = System.currentTimeMillis();
        for(int i=0; i<v1.length; i++)
        {
            vFinal = (v1[i] * v2[i]) + vFinal;
        }

        duracionTotal = System.currentTimeMillis() - ini;
        System.out.println("Producto escalar obtenido para N=10^6 -> " + vFinal);
        System.out.print("Tiempo en milisegundos usando la forma secuencial -> " + duracionTotal + " Ms");
    }
}