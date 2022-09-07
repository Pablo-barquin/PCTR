import java.util.concurrent.Semaphore;

/**
 * @author Pablo Velicias Barquín
 */
public class ccSem {
    //Atributos
    public int NumCuenta;
    public int saldo;
    public Semaphore Lock = new Semaphore(1);

    /**
     * Constructor de la Clase
     * @param Num   Numero de cuenta asociado. Inicializa en 0 el saldo.
     */
    ccSem(int Num)
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
        try{Lock.acquire();}catch(InterruptedException e){}
        try
        {
            saldo += dinero;
        } finally {Lock.release();}
    }

    /**
     * Realiza un retiro de dinero de la cuenta
     * @param dinero    Dinero a retirar
     */
    void reintegro(int dinero)
    {
        try{Lock.acquire();}catch(InterruptedException e){}
        try
        {
            saldo -= dinero;
        } finally {Lock.release();}
    }    
}
