import java.util.Scanner;

public class usaComplejos {
    
    public static Complejos InfoSuma()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Escriba el numero de complejos que desea sumar: ");
        int Tamanno = in.nextInt();

        Complejos[] Numeros = new Complejos[Tamanno];
        for(int i=0; i<Tamanno; i++)
        {
            Numeros[i] = new Complejos();
        }

        System.out.println("A continuacion, escriba los numeros complejos. Primero, la parte real y luego la imaginaria");
        for(int j=0; j<Tamanno; j++)
        {
            System.out.print("Num." + (j+1) + " Parte Real: ");
            Numeros[j].Real = in.nextDouble();
            System.out.print("Num." + (j+1) + " Parte Imaginaria: ");
            Numeros[j].Imaginario = in.nextDouble();
            System.out.println("");

        }

        in.close();
        return Complejos.Suma(Numeros);
    }
   
    public static Complejos InfoResta()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Escriba el numero de complejos que desea restar: ");
        int Tamanno = in.nextInt();
        
        Complejos[] Numeros = new Complejos[Tamanno];
        for(int i=0; i<Tamanno; i++)
        {
            Numeros[i] = new Complejos();
        }

        System.out.println("A continuacion, escriba los numeros complejos. Primero, la parte real y luego la imaginaria");
        for(int j=0; j<Tamanno; j++)
        {
            System.out.print("Num." + (j+1) + " Parte Real: ");
            Numeros[j].Real = in.nextDouble();
            System.out.print("Num." + (j+1) + " Parte Imaginaria: ");
            Numeros[j].Imaginario = in.nextDouble();
            System.out.println("");

        }

        in.close();
        return Complejos.Resta(Numeros);
    }

    public static double InfoModulo()
    {
        Complejos Numeros = new Complejos();
        
        System.out.println("A continuacion, escriba el numero complejo. Primero, la parte real y luego la imaginaria");
        Scanner in = new Scanner(System.in);

        System.out.print("Parte Real: ");
        Numeros.Real = in.nextDouble();
        System.out.print("Parte Imaginaria: ");
        Numeros.Imaginario = in.nextDouble();
        System.out.println("");
        in.close();

        return Complejos.Modulo(Numeros);
    }

    public static Complejos InfoProducto()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Escriba el numero de complejos que desea multiplicar: ");
        int Tamanno = in.nextInt();

        Complejos[] Numeros = new Complejos[Tamanno];
        for(int i=0; i<Tamanno; i++)
        {
            Numeros[i] = new Complejos();
        }

        System.out.println("A continuacion, escriba los numeros complejos. Primero, la parte real y luego la imaginaria");
        for(int j=0; j<Tamanno; j++)
        {
            System.out.print("Num." + (j+1) + " Parte Real: ");
            Numeros[j].Real = in.nextDouble();
            System.out.print("Num." + (j+1) + " Parte Imaginaria: ");
            Numeros[j].Imaginario = in.nextDouble();
            System.out.println("");

        }

        in.close();
        return Complejos.Producto(Numeros);
    }

    public static double[] InfoCociente()
    {
        Scanner in = new Scanner(System.in);
        Complejos[] Numeros = new Complejos[2];
        
        for(int i=0; i<2; i++)
        {
            Numeros[i] = new Complejos();
        }

        System.out.println("A continuacion, escriba los dos numeros complejos que desea dividir. Primero, la parte real y luego la imaginaria");
        for(int j=0; j<2; j++)
        {
            if(j==0)
            {
                System.out.println("--NUMERADOR--");

                System.out.print("Num." + (j+1) + " Parte Real: ");
                Numeros[j].Real = in.nextDouble();
                System.out.print("Num." + (j+1) + " Parte Imaginaria: ");
                Numeros[j].Imaginario = in.nextDouble();
                System.out.println("");
            }
            else
            {
                System.out.println("--DENOMINADOR--");

                System.out.print("Num." + (j+1) + " Parte Real: ");
                Numeros[j].Real = in.nextDouble();
                System.out.print("Num." + (j+1) + " Parte Imaginaria: ");
                Numeros[j].Imaginario = in.nextDouble();
                System.out.println("");                
            }
        }

        in.close();

        return Complejos.Cociente(Numeros);
    }

    public static boolean ComprobarComplejo()
    {
        Complejos Numeros = new Complejos();
        
        System.out.println("A continuacion, escriba el numero complejo que desea comprobar. Primero, la parte real y luego la imaginaria");
        Scanner in = new Scanner(System.in);

        System.out.print("Parte Real: ");
        Numeros.Real = in.nextDouble();
        System.out.print("Parte Imaginaria: ");
        Numeros.Imaginario = in.nextDouble();
        System.out.println("");
        in.close();

        return Complejos.Comprobacion(Numeros);        

    }

    public static int InfoCuadrante()
    {
        Complejos Numeros = new Complejos();
        
        System.out.println("A continuacion, escriba el numero complejo que desea comprobar. Primero, la parte real y luego la imaginaria");
        Scanner in = new Scanner(System.in);

        System.out.print("Parte Real: ");
        Numeros.Real = in.nextDouble();
        System.out.print("Parte Imaginaria: ");
        Numeros.Imaginario = in.nextDouble();
        System.out.println("");
        in.close();

        return Complejos.Cuadrante(Numeros);          
    }

    public static void main(String[] args)
    {
        System.out.println("Bienvenido al menu de Numeros Complejos: ");
        System.out.print("1)Realizar suma\n2)Realizar Resta\n3)Realizar Modulo\n4)Realizar Producto\n5)Realizar cociente \n6)Comprobar si es 0 + 0i\n7)Calcular cuadrante de un complejo\n\nEliga la operacion que desea realizar: ");
        Scanner in = new Scanner(System.in);
        
        Complejos c = new Complejos();
        double[] Division = new double[3];
        
        int Opcion = in.nextInt();
        switch(Opcion)
        {
            case 1: c = InfoSuma(); 
                    System.out.print("El resultado de la suma es: " + c.Real + " + " + c.Imaginario + "i"); break;

            case 2: c = InfoResta(); 
                    System.out.print("El resultado de la resta es: " + c.Real + " + " + c.Imaginario + "i"); break;

            case 3: System.out.print("El modulo del numero complejo es: " + InfoModulo()); break;

            case 4: c = InfoProducto(); 
                    System.out.print("El resultado del producto es: " + c.Real + " + " + c.Imaginario + "i"); break;

            case 5: Division = InfoCociente(); 
                    System.out.println("El resultado de la division es: " + Division[0] + "/" + Division[2] + " + " + Division[1] + "/" + Division[2] + "i"); 
                    System.out.print("Realizando la division, el resultado es: " + Division[0]/Division[2] + " + " + Division[1]/Division[2] + "i"); break;
        
            case 6: if(ComprobarComplejo()) System.out.print("El complejo es del tipo 0 + 0i"); 
                    else System.out.print("El complejo no es del tipo 0 + 0i"); break;

            case 7: System.out.println("El complejo se encuentra en el " + InfoCuadrante() + "º cuadrante"); break;
            
            default: System.out.println("Opcion no valida"); break;
        }

        in.close();
    }

}
