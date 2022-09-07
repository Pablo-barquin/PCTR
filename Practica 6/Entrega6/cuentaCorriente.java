/**
 * @author Pablo Velicias Barquín
 */
public class cuentaCorriente {
    //Atributos
    public int NumCuenta;
    public static int saldo = 0;

    /**
     * Constructor de la clase
     * @param Num ID de la cuenta corriente
     */
    cuentaCorriente(int Num)
    {
        this.NumCuenta = Num;
    }

    /**
     * Ingreso de dinero en la cuenta
     * @param dinero Dinero a ingresar
     */
    void deposito(int dinero)
    {
        saldo += dinero;
    }

    /**
     * Retiro de dinero de la cuenta
     * @param dinero Dinero a retirar
     */
    void reintegro(int dinero)
    {
        saldo -= dinero;
    }

}
