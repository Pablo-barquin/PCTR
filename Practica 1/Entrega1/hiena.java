public class hiena extends carnivoro {
    public int nDientes;
    public float peso;
    public float tamanno;
    public String color;

    public hiena(int n, boolean a, int d, float p, boolean f, float tam, String col) 
    {
        super(n, a, d, p, f);
        this.nDientes = d;
        this.peso = p;
        this.tamanno = tam;
        this.color = col;
    }
}
