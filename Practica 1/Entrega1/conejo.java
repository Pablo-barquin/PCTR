public class conejo extends herviboro {
    public int nDientes;
    public float peso;
    public float tamanno;
    public String color;

    public conejo(int n, boolean a, int d, float p, String sistema, float tam, String col) 
    {
        super(n, a, d, p, sistema);
        this.nDientes = d;
        this.peso = p;
        this.tamanno = tam;
        this.color = col;
    }
}
