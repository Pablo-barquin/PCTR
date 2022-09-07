import java.util.*;

/**
 * @author Pablo Velicias Barquín
 */


public class matVector {
  
    
    public static void main(String[] args)
    {
        long inicio;
        long duracionTotal;
        
        //Introduce valor de N
        Scanner in = new Scanner(System.in);       
        System.out.print("Introduzca Tam. N: ");
        int N = in.nextInt();

        //Declaramos variables
        int[][] Matriz = new int[N][N];
        int[] Vector = new int[N];
        int[] Resultado = new int[N];

        Random r = new Random();

        //Inicializamos la matriz y el vector utilizando la clase Random()
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                Matriz[i][j] = r.nextInt(7);
            }

            Vector[i] = r.nextInt(7);
        }
        
        inicio = System.currentTimeMillis();
        int Aux = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                Aux = (Matriz[i][j] * Vector[j]) + Aux; 
            }

            Resultado[i] = Aux;
            Aux = 0;
        }
        duracionTotal = System.currentTimeMillis() - inicio;

        /*for(int i=0; i<N; i++)
        {
            System.out.println(Arrays.toString(Matriz[i]) + "  [" + Vector[i] + "] ---- [" + Resultado[i] + "]");
        }*/

        System.out.println("Duracion en milisegundos de la ejecucion: " + duracionTotal + " ms");

        in.close();
    }
}
