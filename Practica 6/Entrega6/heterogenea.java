/**
 * @author Pablo Velicias Barquín
 */
public class heterogenea {
    public static int n, m;

    /**
     * Metodo que incrementa usando Synchronized
     */
    public synchronized void ConCerrojo()
    {
        n++;
    }

    /**
     * Metodo que incrementa sin usar Synchronized
     */
    public void SinCerrojo()
    {
        m++;
    }
}
