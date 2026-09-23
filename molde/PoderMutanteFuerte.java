package molde;

public class PoderMutanteFuerte extends Poder {

    public PoderMutanteFuerte() {
        this.setDanno(3); 
    }

    @Override
    public int UsarPoder(){
       return getDanno();
    }
}