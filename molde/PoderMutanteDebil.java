package molde;

public class PoderMutanteDebil extends Poder {

    public PoderMutanteDebil() {
        this.setDanno(1); 
    }

    @Override
    public int UsarPoder(){
       return getDanno();
    }
}