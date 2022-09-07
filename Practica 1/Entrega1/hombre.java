public class hombre extends omnivoro {
    public double altura;
    public String DNI;
    public String Nombre;

    public hombre(int nPatas, boolean Acuatico, int Dientes, float Peso, boolean Felino, double Altura, String DNIp, String NombreP) 
    {
        super(nPatas, Acuatico, Dientes, Peso, Felino);
        this.altura = Altura;
        this.DNI = DNIp;
        this.Nombre = NombreP;
    }
}
