package molde;
abstract class Poder{
    private int Danno;
    public void setDanno(int pDanno){
        this.Danno=pDanno;
    }
    public int getDanno() {
        return this.Danno;
    }
    public abstract void UsarPoder();
}