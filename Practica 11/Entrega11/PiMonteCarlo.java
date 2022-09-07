import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 * @author Pablo Velicias Barquín
 */
public class PiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo{
    
    public int NumPuntos = 0;

    /**
     * Constructor del servidor
     * @throws RemoteException
     */
    PiMonteCarlo() throws RemoteException {}

    /**
     * Resetea la nube de puntos a 0
     * @throws RemoteException
     */
    public void reset() throws RemoteException
    {
        NumPuntos = 0;
        System.out.println("Los puntos ha sido reiniciado a 0");
    }

    /**
     * Añade nPuntos a la nube de puntos total
     * @param nPuntos Número de puntos que vamos a añadir
     * @throws RemoteException
     */
    public void masPuntos(int nPuntos) throws RemoteException
    {
        NumPuntos += nPuntos;
        System.out.println(nPuntos + " puntos han sido agregados");
    }

    /**
     * Devuelve la aproximación que hay ahora mismo con la cantidad de puntos del sistema
     * @return Aproximación en ese momento
     * @throws RemoteException
     */
    public double aproxActual() throws RemoteException
    {
        double ContadorPi = 0;
        double CoordenadaX = 0.0, CoordenadaY = 0.0;
        
        Random r = new Random();

        for(int j = 0; j < NumPuntos; j++)
        {
            CoordenadaX = r.nextDouble();
            CoordenadaY = r.nextDouble();

            if(Math.sqrt((CoordenadaX*CoordenadaX + CoordenadaY*CoordenadaY)) <= 1.0)
            {
                ContadorPi++;
            }
            
        }

        ContadorPi = 4*(ContadorPi/NumPuntos);
        System.out.println("Calculo realizado: " + ContadorPi);

        return ContadorPi;
    }

    public static void main(String[] args) throws Exception{
        iPiMonteCarlo ClaseServidor = new PiMonteCarlo();

        Naming.rebind("ServidorMonteCarlo", ClaseServidor);

        System.out.println("Servidor lanzado con exito");
        ClaseServidor.reset();
    }
}
