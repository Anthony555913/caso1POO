package Control;

import BattleField.BattleField;
import Team.Equipo;
import molde.PersonaMutante;


public class ControlJuego {
    private Equipo Equipo1;
    private Equipo Equipo2;
    private BattleField Tablero;
    private int CanIntegrantePorEquipo;

    public ControlJuego(int pCanIntegrantePorEquipo) {
        this.CanIntegrantePorEquipo = pCanIntegrantePorEquipo;
    }

    // Getters y setters
    public Equipo getEquipo1() {
        return Equipo1;
    }

    public void setEquipo1(Equipo pEquipo1) {
        this.Equipo1 = pEquipo1;
    }

    public Equipo getEquipo2() {
        return Equipo2;
    }

    public void setEquipo2(Equipo pEquipo2) {
        this.Equipo2 = pEquipo2;
    }

    public BattleField getTablero() {
        return Tablero;
    }

    public void setTablero(BattleField pTablero) {
        this.Tablero = pTablero;
    }

    public int getCanIntegrantePorEquipo() {
        return CanIntegrantePorEquipo;
    }

    public void setCanIntegrantePorEquipo(int pCanIntegrantePorEquipo) {
        this.CanIntegrantePorEquipo = pCanIntegrantePorEquipo;
    }
    public double CalDistancia(PersonaMutante pMutante1, PersonaMutante pMutante2) {
    int deltaX = pMutante1.getX() - pMutante2.getX();
    int deltaY = pMutante1.getY() - pMutante2.getY();
    return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
    public boolean  CalcularEstadoEquipo(){
        return this.Equipo1.getEstadoEquipo() && this.Equipo2.getEstadoEquipo();
    }
    public void EjecutarAccion(PersonaMutante pAtacante,PersonaMutante pObjetivo){

    }
    public void DefinirAccion() {
        for (PersonaMutante pAtacante : this.Equipo1.getIntegrantes()) {
            for (PersonaMutante pObjetivo : this.Equipo2.getIntegrantes()) {
                double distancia = CalDistancia(pAtacante, pObjetivo);
                if (pAtacante.getEstado() == true && pObjetivo.getEstado() == true
                    && pAtacante.isModoInmune() == false && pObjetivo.isModoInmune() == false && distancia<=5) {
                    EjecutarAccion(pAtacante, pObjetivo);
                
                }
            }
        }
    }
}