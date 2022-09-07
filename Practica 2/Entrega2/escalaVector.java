/**
* @author Pablo Velicias Barquín
*/
import java.util.Arrays;

public class escalaVector {
    
    public static void main(String[] args)
    {
        double[] vector = new double[9*1000000];
        double factor = 2;
        
        for(int i=0; i<vector.length; i++) vector[i] = Math.random()*5;

        for(int i=0; i<vector.length; i++) 
        {
            vector[i] *= factor;
        }
    }
}
