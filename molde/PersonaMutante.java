package molde;

public class PersonaMutante{
    private int Id;
    private boolean Estado;
    private int Vida = 100;
    private int Defensa;
    private int X;
    private int Y;
    private Poder PoderMutante;
    private boolean ModoInmune = false;

    public PersonaMutante(int Id, boolean Estado, int Defensa, int X, int Y, Poder PoderMutante) {
        this.Id = Id;
        this.Estado = Estado;
        this.Defensa = Defensa;
        this.X = X;
        this.Y = Y;
        this.PoderMutante = PoderMutante;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int Vida) {
        this.Vida = Vida;
    }

    public int getDefensa() {
        return Defensa;
    }

    public void setDefensa(int Defensa) {
        this.Defensa = Defensa;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public Poder getPoderMutante() {
        return PoderMutante;
    }

    public void setPoderMutante(Poder PoderMutante) {
        this.PoderMutante = PoderMutante;
    }

    public boolean isModoInmune() {
        return ModoInmune;
    }

    public void setModoInmune(boolean ModoInmune) {
        this.ModoInmune = ModoInmune;
    }
    public int UsarPoder(){
        return PoderMutante.UsarPoder();
    }
}