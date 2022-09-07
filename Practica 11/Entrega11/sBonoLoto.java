import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 * @author Pablo Velicias Barquín
 * Servidor
 */
public class sBonoLoto extends UnicastRemoteObject implements iBonoLoto {
    
    public int[] NumeroGanador = new int[6];

    /**
     * Constructor del servidor
     * @throws RemoteException
     */
    sBonoLoto() throws RemoteException {}

    /**
     * Función que sirve para resetear el número ganador y seguir jugando
     * @throws RemoteException
     */
    public void resetServidor() throws RemoteException
    {
        Random r = new Random();
        System.out.print("\nCreando nueva combinacion ganadora: ");
        for(int i=0; i<6; i++)
        {
            this.NumeroGanador[i] = (1 + r.nextInt(49));
            System.out.print(NumeroGanador[i] + " ");
        }    
    }

    /**
     * Comprobar que la apuesta es ganadora
     * @param apuesta   Número a probar
     * @return  Devuelve true si el cliente ha acertado y false si es incorrecto
     * @throws RemoteException
     */
    public boolean compApuesta(int[] apuesta)  throws RemoteException
    {
        boolean flag = true;

        for(int i=0; i<6; i++)
        {
            if(apuesta[i] != NumeroGanador[i])
                flag = false;
        }

        return flag;
    }

    public static void main(String[] args) throws Exception {
        iBonoLoto ClaseServidor = new sBonoLoto();

        Naming.rebind("ServidorBonoloto", ClaseServidor);

        System.out.println("Servidor lanzado con exito");
        ClaseServidor.resetServidor();
    }
}
