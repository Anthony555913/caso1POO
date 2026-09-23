package molde;

public class PoderMutanteMedio extends Poder {

    public PoderMutanteMedio() {
        this.setDanno(2); 
    }

    @Override
    public int UsarPoder(){
       return getDanno();
    }
}