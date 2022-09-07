public class cuentaCorriente {
    //Atributos
    public int NumCuenta;
    public static int saldo = 0;

    cuentaCorriente(int Num)
    {
        this.NumCuenta = Num;
    }

    void deposito(int dinero)
    {
        saldo += dinero;
    }

    void reintegro(int dinero)
    {
        saldo -= dinero;
    }

}
