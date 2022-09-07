public class omnivoro extends animal {
    public int nDientes;
    public float peso;
    public boolean felino;
    
    public omnivoro(int n, boolean a, int d, float p, boolean f) 
    {
        super(n, a);
        this.nDientes = d;
        this.peso = p;
        this.felino = f;
    }    
}
