import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class jerarquiaClases {

    public static void main(String[] args)
    {
        System.out.print("Escriba el nombre de un animal: ");
        Scanner in = new Scanner(System.in);
        String NombreAnimal = in.nextLine();

        System.out.print("Escriba el numero de patas del animal: ");
        int nPatas = in.nextInt();

        System.out.print("Escriba si es acuatico: ");
        boolean Acuatico = in.nextBoolean();

        animal an = new animal(nPatas, Acuatico);
        System.out.print("El " + NombreAnimal + " tiene " + an.nPatas + " patas y ");
        if(an.acuatico) System.out.println("es acuatico.\n");
        else System.out.println("no es acuatico.\n");

        in.nextLine();

        conejo con = new conejo(4, false, 28, 2, "monogastrico", 40, "blanco");
        System.out.println("El conejo tiene " + con.nPatas + " patas. Es de sistema " + con.sisDigestivo + ", de color " + con.color + " y tiene un peso aproximado de " + con.peso + " kg.");
        System.out.print("Escriba color de un conejo: ");
        String Aux = in.nextLine();

        con.color = Aux;
        System.out.println("El conejo tiene " + con.nPatas + " patas. Es de sistema " + con.sisDigestivo + ", de color " + con.color + " y tiene un peso aproximado de " + con.peso + " kg.");


        System.out.print("\nIntroduzca tu nombre: ");
        Aux = in.nextLine();

        System.out.print("Introduzca tu altura: ");
        float alt = in.nextFloat();

        in.nextLine();

        System.out.print("Introduzca tu dni: ");
        String Aux2 = in.nextLine();

        hombre h = new hombre(2, false, 32, 60, false, alt, Aux2, Aux);

        System.out.println("Te llamas " + h.Nombre + ", mides " + h.altura + ", y tu DNI es " + h.DNI + ". Tienes " + h.nDientes + " dientes y " + h.nPatas + " patas.");

        in.close();
    }

}
