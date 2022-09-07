import java.util.Random;
import java.util.Scanner;

public class intDefinidaMonteCarlo 
{
    private static double FuncionSeno(double x)
    {
        return Math.cos(x);
    }

    //Creamos el Main principal dentro de la clase
    public static void main(String[] args)
    { 
        Scanner in = new Scanner(System.in);
        System.out.print("Introduzca el numero de iteraciones del bucle: ");
        int NumeroPuntos = in.nextInt();
        float ContadorX = 0, ContadorSeno = 0;
        double CoordenadaX = 0.0, CoordenadaY = 0.0;
        
        Random r = new Random();

        for(int j = 0; j < NumeroPuntos; j++)
        {
            CoordenadaX = r.nextDouble();
            CoordenadaY = r.nextDouble();

            if(CoordenadaY <= FuncionSeno(CoordenadaX))
            {
                ContadorSeno++;
            }
            
            if(CoordenadaY <= CoordenadaX)
            {
                ContadorX++;
            }
        }

        ContadorSeno = ContadorSeno/NumeroPuntos;
        ContadorX = ContadorX/NumeroPuntos;

        System.out.println("La aproximacion para sin(x) es: " + ContadorSeno);
        System.out.println("La aproximacion para x es: " + ContadorX);

        in.close();
    }
}
