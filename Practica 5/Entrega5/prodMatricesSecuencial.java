import java.util.Random;
import java.util.Scanner;

/**
 * @author Pablo Velicias Barquín
 */
public class prodMatricesSecuencial{

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Indica valor de N para Matriz NxN: ");
        int N = in.nextInt();

        int[][] Matriz1 = new int[N][N];
        int[][] Matriz2 = new int[N][N];
        int[][] Resultado = new int[N][N];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                Matriz1[i][j] = r.nextInt(5);
                Matriz2[i][j] = r.nextInt(5);
            }
        }

        long InicioTiempo = System.currentTimeMillis();
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                for(int z=0; z<N; z++)
                {
                    Resultado[i][j] = Matriz1[i][z] * Matriz2[z][j] + Resultado[i][j];
                }
            }
        }
        long FinTiempo = System.currentTimeMillis() - InicioTiempo;

        System.out.print("Tiempo de ejecucion en milisegundos: " + FinTiempo + " ms");
        in.close();
    }


}