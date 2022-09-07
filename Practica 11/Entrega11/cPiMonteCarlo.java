import java.rmi.Naming;
import java.sql.Ref;
import java.util.Scanner;

/**
 * @author Pablo Velicias Barquín
 */
public class cPiMonteCarlo {
    


    public static void main(String[] args) throws Exception {
       
        iPiMonteCarlo RefObRemoto = (iPiMonteCarlo) Naming.lookup("//localhost/ServidorMonteCarlo");
        
        Scanner in = new Scanner(System.in);

        int opcion = 0;
        while(opcion != 4)
        {
            System.out.println("Introduzca que accion quiere realizar: ");
            System.out.print("  1) Agregar Puntos\n  2) Resetear Puntos\n  3) Calcular aproximacion actual\n  4) Salir\nEscribe la opcion: ");
            opcion = in.nextInt();

            switch(opcion)
            {
                case 1: 
                    System.out.print("Puntos que va agregar: ");
                    RefObRemoto.masPuntos(in.nextInt());
                    break;
                case 2: RefObRemoto.reset(); System.out.println("Se han reseteado los puntos del servidor"); break;
                case 3: System.out.println("La aproximacion actual es de: " + RefObRemoto.aproxActual()); break;
                case 4: break;
                default: System.out.println("Error. Elige entre el 1 y el 4");
            }
            System.out.println(" ");
        }

        in.close();
    }
}
