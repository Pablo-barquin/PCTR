public class cajero implements Runnable {
    
    cuentaCorriente A;
    int metodo = 0;
    int dinero = 0;

    cajero(cuentaCorriente Aux, int accion, int dinero2)
    {
        A = Aux;
        this.metodo = accion;
        this.dinero = dinero2;
    }

    public void run()
    {
        switch(metodo)
        {
            case 0: for(int i=0; i<2000; i++) A.deposito(dinero); break;
            case 1: for(int i=0; i<2000; i++) A.reintegro(dinero); break;

            default: System.out.print("No se puede realizar la operacion");
        }
    }
}
