public class herviboro extends animal {
    public int nDientes;
    public float peso;
    public String sisDigestivo;

    public herviboro(int n, boolean a, int d, float p, String sistema) 
    {
        super(n, a);
        this.nDientes = d;
        this.peso = p;
        this.sisDigestivo = sistema;
    }
}
