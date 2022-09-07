import java.util.Random;
import java.util.Scanner;

/**
 * @author Pablo Velicias Barquín
 */
public class resImagen{
    
    public static int aux = 0;
    
    /**
     * Condición de frontera Nula. No consideramos los bordes de la imagen
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        
        System.out.print("Indica el valor de N para la matriz NxN: ");
        int N = in.nextInt();

        short[][] Matriz1 = new short[N][N];
        short[][] Resultado = new short[N][N];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                Matriz1[i][j] = (short) r.nextInt(256);
            }
        }

        long inicio = System.currentTimeMillis();
        for(int i=1; i<N-1; i++)
        {
            for(int j=1; j<N-1; j++)
            {
                Resultado[i][j] = (short)((4*Matriz1[i][j] - Matriz1[i+1][j] - Matriz1[i][j+1] - Matriz1[i-1][j] - Matriz1[i][j-1])/8);
            }
        }
        long fin = System.currentTimeMillis() - inicio;

        System.out.println("El tiempo de ejecucion en milisegundos: " + fin + " ms");
        in.close();
    }
}   
