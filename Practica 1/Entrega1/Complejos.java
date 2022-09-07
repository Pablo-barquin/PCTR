public class Complejos {
    
    public double Real;
    public double Imaginario;

    public Complejos()
    {
        this.Real = 0.0;
        this.Imaginario = 0.0;
    }

    public static Complejos Suma(Complejos[] Numeros)
    {
        Complejos c = new Complejos();

        for(int j=0; j<Numeros.length; j++)
        {
            c.Real = c.Real + Numeros[j].Real;
            c.Imaginario = c.Imaginario + Numeros[j].Imaginario;
        }

        return c;
    }

    public static Complejos Resta(Complejos[] Numeros)
    {
        Complejos c = new Complejos();

        c.Real = Numeros[0].Real;
        c.Imaginario = Numeros[0].Imaginario;

        for(int j=1; j<Numeros.length; j++)
        {
            c.Real = c.Real - Numeros[j].Real;
            c.Imaginario = c.Imaginario - Numeros[j].Imaginario;
        }

        return c;
    }

    public static double Modulo(Complejos Numero)
    {
        double aux = Math.pow(Numero.Real, 2) + Math.pow(Numero.Imaginario, 2);
        return Math.sqrt(aux);
    }

    public static Complejos Producto(Complejos[] Numeros)
    {
        Complejos c = new Complejos();
        double aux1 = 0.0;
        double aux2 = 0.0;

        int j=0;
        for(j=0; j<Numeros.length-1; j++)
        {
            aux1 = Numeros[j].Real*Numeros[j+1].Real + (Numeros[j].Imaginario*Numeros[j+1].Imaginario*-1);
            aux2 = Numeros[j].Real*Numeros[j+1].Imaginario + Numeros[j].Imaginario*Numeros[j+1].Real;

            Numeros[j+1].Real = aux1;
            Numeros[j+1].Imaginario = aux2;

        }

        c.Real = Numeros[j].Real;
        c.Imaginario = Numeros[j].Imaginario;

        return c;
    }

    public static double[] Cociente(Complejos[] Numeros)
    {
        double[] cociente = new double[3];
        double aux1 = 0.0;
        double aux2 = 0.0;

        Complejos[] aux = Numeros;

        aux1 = Math.pow(aux[1].Real, 2);
        aux2 = Math.pow(aux[1].Imaginario, 2);

        aux[1].Imaginario = -aux[1].Imaginario;
        Complejos c = Producto(aux);

        cociente[0] = c.Real;
        cociente[1] = c.Imaginario;
        cociente[2] = aux1+aux2;

        return cociente;
    }

    public static boolean Comprobacion(Complejos Numero)
    {
        return (Numero.Real == 0 && Numero.Imaginario == 0);
    }

    public static int Cuadrante(Complejos Numero)
    {
        if(Numero.Real > 0)
        {
            if(Numero.Imaginario > 0)
                return 1;
            else return 4;
        }
        else
        {
            if(Numero.Imaginario > 0)
                return 2;
            else return 3;
        }
    }

}


