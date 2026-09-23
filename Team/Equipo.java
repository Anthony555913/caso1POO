package Team;

import java.util.ArrayList;
import molde.PersonaMutante;
public class Equipo{
    private ArrayList<PersonaMutante> Integrantes;
    private int CanIntegrantes;
    private String Color;
    private int Vivos;
    private boolean EstadoEquipo = true;

    public Equipo() {
    }

    public Equipo(ArrayList<PersonaMutante> pIntegrantes, int pCanIntegrantes, String pColor, int pVivos) {
        this.Integrantes = pIntegrantes;
        this.CanIntegrantes = pCanIntegrantes;
        this.Color = pColor;
        this.Vivos = pVivos;
    }

    public int getCanIntegrantes() {
        return CanIntegrantes;
    }

    public void setCanIntegrantes(int pCanIntegrantes) {
        this.CanIntegrantes = pCanIntegrantes;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String pColor) {
        this.Color = pColor;
    }

    public int getVivos() {
        return Vivos;
    }

    public void setVivos(int pVivos) {
        this.Vivos = pVivos;
    }

    public boolean getEstadoEquipo() {
        return EstadoEquipo;
    }

    public void setEstadoEquipo(boolean pEstadoEquipo) {
        this.EstadoEquipo = pEstadoEquipo;
    }
    public void RestarIntegrantes(int pResta){
        this.CanIntegrantes-=pResta;
        if (this.CanIntegrantes <= 0) {
            setEstadoEquipo(false);
            
        }
    }
    public ArrayList<PersonaMutante> getIntegrantes(){
        return this.Integrantes;
    }
}