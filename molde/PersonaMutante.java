package molde;

public class PersonaMutante{
    private int Id;
    private boolean Estado;
    private int Vida = 100;
    private int Defensa;
    private int AtaqueAumento=0;
    private int X;
    private int Y;
    private Poder PoderMutante;

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

    public void setId(int pId) {
        this.Id = pId;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean pEstado) {
        this.Estado = pEstado;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int pVida) {
        this.Vida = pVida;
    }

    public int getDefensa() {
        return Defensa;
    }

    public void setDefensa(int pDefensa) {
        this.Defensa = pDefensa;
    }

    public int getX() {
        return X;
    }

    public void setX(int pX) {
        this.X = pX;
    }

    public int getY() {
        return Y;
    }

    public void setY(int pY) {
        this.Y = pY;
    }

    public int getAtaqueAumento() {
        return AtaqueAumento;
    }

    public void setAtaqueAumento(int pAtaqueAumento) {
        this.Y = pAtaqueAumento;
    }

    public Poder getPoderMutante() {
        return PoderMutante;
    }

    public void setPoderMutante(Poder pPoderMutante) {
        this.PoderMutante = pPoderMutante;
    }

    public int UsarPoder(){
        return PoderMutante.UsarPoder()+AtaqueAumento;
    }
}