import java.net.*;
import java.util.Scanner;
import java.io.*;

/**
 * @author Pablo Velicias Barquín
 */
public class clienteMultiple {
    
    public static void main (String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Introduzca numero de peticiones que desea realizar: ");
        int N = in.nextInt();
        int puerto = 2001;
        for(int j=0; j<N; j++)
        { 
            int i = (int)(Math.random()*10);
            try{
                System.out.println("Realizando conexion...");
                Socket cable = new Socket("localhost", puerto);
                System.out.println("Realizada conexion a "+cable);
                PrintWriter salida= new PrintWriter(new BufferedWriter(new OutputStreamWriter(cable.getOutputStream())));
                salida.println(i);
                salida.flush();
                System.out.println("Cerrando conexion...\n");
                cable.close();
                
                Thread.sleep(1000);
            }catch (Exception e){System.out.println("Error en sockets...");}
        }
        in.close();
    }    
}

