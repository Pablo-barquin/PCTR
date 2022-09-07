import java.util.Arrays;
import java.util.Random;
import mpi.*;

/**
 * Compilar: javac -cp "%MPJ_HOME%\lib\mpj.jar" escalMultiple.java
 * Ejecutar: mpjrun.bat -np 5 escalMultiple
 */

/**
 * @author Pablo Velicias Barquín
 */
public class escalMultiple {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        int id = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int master = 0, unitsize = 10;
        int tag = 23;

        int[] VectorEnvio = new int[10];
        if(id == master)
        {  
            Random r = new Random();
            for(int i=0; i<unitsize; i++)   VectorEnvio[i] = r.nextInt(5);
            System.out.println("El vector creado es: " + Arrays.toString(VectorEnvio));
        }
        MPI.COMM_WORLD.Bcast(VectorEnvio, 0, unitsize, MPI.INT, 0);
        if(id == 1)
        {
            for(int i=0; i<unitsize; i++) VectorEnvio[i] = VectorEnvio[i]*id;
            System.out.println("Vector enviado multiplicado por " + id + ": " + Arrays.toString(VectorEnvio));
        }
        else if(id == 2)
        {
            for(int i=0; i<unitsize; i++) VectorEnvio[i] = VectorEnvio[i]*id;
            System.out.println("Vector enviado multiplicado por " + id + ": " + Arrays.toString(VectorEnvio));
        }
        else if(id == 3)
        {
            for(int i=0; i<unitsize; i++) VectorEnvio[i] = VectorEnvio[i]*id;
            System.out.println("Vector enviado multiplicado por " + id + ": " + Arrays.toString(VectorEnvio));
        }
        else if(id == 4)
        {
            for(int i=0; i<unitsize; i++) VectorEnvio[i] = VectorEnvio[i]*id;
            System.out.println("Vector enviado multiplicado por " + id + ": " + Arrays.toString(VectorEnvio));
        }
        MPI.Finalize();
    }
}
