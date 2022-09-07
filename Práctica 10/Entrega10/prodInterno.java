import java.util.Arrays;
import java.util.Random;
import mpi.*;

/**
 * Compilar: javac -cp "%MPJ_HOME%\lib\mpj.jar" prodInterno.java
 * Ejecutar: mpjrun.bat -np 2 prodInterno
 */

/**
 * @author Pablo Velicias Barquín
 */
public class prodInterno {

    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        int id = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
    
        int emisor = 0, receptor = 1;
        int tag = 23, unitsize = 4;
    
        if(id == emisor)
        {
            Random r = new Random();
            int[] vec1 = new int[unitsize];
            int[] vec2 = new int[unitsize];
            for(int i=0; i<unitsize; i++) 
            {
                vec1[i] = r.nextInt(5);
                vec2[i] = r.nextInt(5);
            }

            int[] VectorEnvio = new int[vec1.length + vec2.length];
            System.arraycopy(vec1, 0, VectorEnvio, 0, vec1.length);
            System.arraycopy(vec2, 0, VectorEnvio, vec1.length, vec2.length);

            System.out.println("Enviando los dos vectores concatenados, son: " + Arrays.toString(VectorEnvio));
            MPI.COMM_WORLD.Send(VectorEnvio, 0, unitsize*2, MPI.INT, receptor, tag);
            
            int[] Resultado = new int[1];
            MPI.COMM_WORLD.Recv(Resultado, 0, 1, MPI.INT, receptor, tag);
            System.out.println("El resultado recibido del producto escalar es: " + Resultado[0]);
        }
        else if(id == receptor)
        {
            int[] vecRecepcion = new int[unitsize*2];

            MPI.COMM_WORLD.Recv(vecRecepcion, 0, unitsize*2, MPI.INT, emisor, tag);
            int[] vecDiv1 = Arrays.copyOfRange(vecRecepcion, 0, vecRecepcion.length/2);
            int[] vecDiv2 = Arrays.copyOfRange(vecRecepcion, vecRecepcion.length/2, vecRecepcion.length);

            int[] Resultado = new int[1];
            for(int i=0; i<vecDiv1.length; i++)
                Resultado[0] = vecDiv1[i]*vecDiv2[i] + Resultado[0];

            MPI.COMM_WORLD.Send(Resultado, 0, 1, MPI.INT, emisor, tag);
        }

        MPI.Finalize();
    }
}
