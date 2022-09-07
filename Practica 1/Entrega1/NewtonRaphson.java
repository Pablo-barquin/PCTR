import java.util.Scanner;

public class NewtonRaphson {
    
    public static double DerivadaPol(double PuntoX0)
    {
        return 2*PuntoX0;
    }

    public static double DerivadaCos(double PuntoX0)
    {
        return (-Math.sin(PuntoX0)) - Math.pow(3*PuntoX0, 2);
    }

    public static double FunPolinomica(double PuntoX0)
    {
        return Math.pow(PuntoX0, 2) - 5.0;
    }

    public static double FunCoseno(double PuntoX0)
    {
        return Math.cos(PuntoX0) - Math.pow(PuntoX0, 3);
    }

    public static double AproxCoseno(double PuntoX0, int nIter)
    {
        double PuntoX1 = 0.0;

        if(PuntoX0 < 0 || PuntoX0 > 1)
        {
            PuntoX0 = 0.0;
            System.out.println("El punto inicial no esta dentro del Rango");
        }
        else
        {
            for(int j = 0; j < nIter ; j++)
            {           
                if(DerivadaCos(PuntoX0) != 0.0)
                {
                    PuntoX1 = PuntoX0 - (FunCoseno(PuntoX0)/DerivadaCos(PuntoX0));
                    System.out.println("Iteracion: " + (j+1) + ", Aproximacion: " + PuntoX1);
                    PuntoX0 = PuntoX1;
                }
            }
        }

        return PuntoX0;
    }

    public static double AproxPolinomio(double PuntoX0, int nIter)
    {
        double PuntoX1 = 0.0;

        if(PuntoX0 < 2 || PuntoX0 > 3)
        {
            PuntoX0 = 0.0;
            System.out.println("El punto inicial no esta dentro del Rango");
        }
        else
        {
            for(int j = 0; j < nIter ; j++)
            {           
                if(DerivadaPol(PuntoX0) != 0.0)
                {
                    PuntoX1 = PuntoX0 - (FunPolinomica(PuntoX0)/DerivadaPol(PuntoX0));
                    System.out.println("Iteracion: " + (j+1) + ", Aproximacion: " + PuntoX1);
                    PuntoX0 = PuntoX1;
                }
            }
        }

        return PuntoX0;
    }

    public static void main(String[] args)
    {
        System.out.println("1. Cos(x) - x^3 en  [0, 1]");
        System.out.println("2. x^2 - 5 en [2, 3]");        
        System.out.print("Funcion que deseas aproximar: ");
        
        Scanner in = new Scanner(System.in);
        int Opcion = in.nextInt();

        System.out.print("Valor inicial para aproximar: ");
        double valor = in.nextDouble();

        System.out.print("Numero de iteraciones: ");
        int Iter = in.nextInt();
        
        double PuntoX = 0.0;
        switch(Opcion)
        {
            case 1: PuntoX = AproxCoseno(valor, Iter); break;
            case 2: PuntoX = AproxPolinomio(valor, Iter); break;
            default: System.out.println("Valor no valido"); break;    
        }
        System.out.println("Resultado: " + PuntoX);

        in.close();
    }
}
