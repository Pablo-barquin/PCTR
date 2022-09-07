import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Pablo Velicias Barquín
 */
public class cCRL {
    //Atributos
    public int NumCuenta;
    public int saldo;
    public ReentrantLock Lock = new ReentrantLock();

    /**
     * Constructor de la Clase
     * @param Num   Numero de cuenta asociado. Inicializa en 0 el saldo.
     */
    cCRL(int Num)
    {
        this.NumCuenta = Num;
        this.saldo = 0;
    }

    /**
     * Realiza un ingreso a la cuenta de dinero
     * @param dinero    Dinero a ingresar
     */
    void deposito(int dinero)
    {
        Lock.lock();
        try
        {
            saldo += dinero;
        } finally {Lock.unlock();}
    }

    /**
     * Realiza un retiro de dinero de la cuenta
     * @param dinero    Dinero a retirar
     */
    void reintegro(int dinero)
    {
        Lock.lock();
        try
        {
            saldo -= dinero;
        } finally {Lock.unlock();}
    }
}