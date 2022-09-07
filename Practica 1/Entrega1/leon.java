public class leon extends carnivoro {
    public int nDientes;
    public float peso;
    public float tamanno;
    public String color;

    public leon(int n, boolean a, int d, float p, boolean f, float tam, String col) 
    {
        super(n, a, d, p, f);
        this.nDientes = d;
        this.peso = p;
        this.tamanno = tam;
        this.color = col;
    }
}