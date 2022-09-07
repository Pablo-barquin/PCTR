import java.util.Scanner;

public class Estadistica {
    
    public static double Media(double[] Numeros)
    {
        double M = 0;

        for(int j=0; j<Numeros.length; j++)
        {
            M = Numeros[j] + M;
        }

        return M/Numeros.length;
    }

    public static double Varianza(double[] Numeros)
    {
        double V=0, M = Media(Numeros);

        for(int j=0; j<Numeros.length; j++)
        {
            V = Math.pow(Numeros[j]-M, 2) + V;
        }

        return V/Numeros.length;
    }

    public static double DesviacionTipica(double[] Numeros)
    {
        double Var = Varianza(Numeros);
        return Math.sqrt(Var);
    }

    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            System.out.println("ERROR. Sintaxis Incorrecta");
            System.exit(-1);
        }

        int N = Integer.parseInt(args[0]);
        double[] Numeros = new double[N];

        for(int j=0; j<N; j++)
        {
            Numeros[j] = Double.parseDouble(args[j+1]);
        }

        System.out.print("\n1. Media\n2. Varianza\n3. Desviacion Tipica\n\nOPERACION A REALIZAR: ");
        Scanner in = new Scanner(System.in);
        int Opcion = in.nextInt();

        switch(Opcion)
        {
            case 1: System.out.println("La media es: " + Media(Numeros)); break;
            case 2: System.out.println("La Varianza es: " + Varianza(Numeros)); break;
            case 3: System.out.println("La Desviacion Tipica es: " + DesviacionTipica(Numeros)); break;
            default: System.out.println("Opcion Incorrecta");
        }

        in.close();
    }
}
