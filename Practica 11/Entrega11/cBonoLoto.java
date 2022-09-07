import java.rmi.Naming;
import java.util.Scanner;

/**
 * @author Pablo Velicias Barquín
 * Cliente
 */
public class cBonoLoto  {

    Scanner in = new Scanner(System.in);

    /**
     * Crea una combinación de numeros introducidos por el usuario
     * @return  Devuelve la nueva combinación de números
     */
    public int[] CrearApuesta()
    {
        int[] apuesta = new int[6];
       
        System.out.println("Introduzca los numeros con los que deseas probar suerte (Desde el 1 al 49)");

        for(int i=0; i<6; i++)
        {
            System.out.print("Numero " + (i+1) +": ");
            apuesta[i] = in.nextInt();
        }

        return apuesta;
    }

    public static void main(String[] args) throws Exception {
        
        iBonoLoto RefObRemoto = (iBonoLoto) Naming.lookup("//localhost/ServidorBonoloto");
        boolean flag = false;

        cBonoLoto ClaseCliente = new cBonoLoto();
        int[] apuesta = new int[6];

        while(true)
        {
            apuesta = ClaseCliente.CrearApuesta();
            flag = RefObRemoto.compApuesta(apuesta);
            if(flag == false)
                System.out.println("\nLa apuesta es incorrecta");
            else
            {
                System.out.println("\nHa acertado los numeros. Enhorabuena");
                RefObRemoto.resetServidor();
                System.out.println("\nLa combinacion de numeros ha cambiado, comienza el juego de nuevo");
            }
        }
    } 
}
