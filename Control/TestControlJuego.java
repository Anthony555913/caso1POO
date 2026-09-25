package Control;

import Team.Equipo;
import BattleField.BattleField;
import molde.PersonaMutante;
import molde.PoderMutanteFuerte;
import java.util.ArrayList;

public class TestControlJuego {
    public static void main(String[] args) {

        System.out.println("=== PRUEBA 1: Getters y setters ===");
        ControlJuego pControl = new ControlJuego(4);
        System.out.println("CanIntegrantePorEquipo: " + pControl.getCanIntegrantePorEquipo());

        pControl.setCanIntegrantePorEquipo(10);
        System.out.println("CanIntegrantePorEquipo actualizado: " + pControl.getCanIntegrantePorEquipo());

        BattleField pTablero = new BattleField(15, 15);
        pControl.setTablero(pTablero);
        System.out.println("Tablero asignado: X=" + pControl.getTablero().getX()
                + " Y=" + pControl.getTablero().getY());

        System.out.println("\n=== PRUEBA 2: CalDistancia ===");
        PersonaMutante pM1 = new PersonaMutante(1, true, 0, 0, 0, new PoderMutanteFuerte());
        PersonaMutante pM2 = new PersonaMutante(2, true, 0, 3, 4, new PoderMutanteFuerte());
        double pDistancia = pControl.CalDistancia(pM1, pM2);
        System.out.println("Distancia entre (0,0) y (3,4) (esperado 5.0): " + pDistancia);

        System.out.println("\n=== PRUEBA 3: EjecutarAccion ===");
        ArrayList<PersonaMutante> pLista1 = new ArrayList<>();
        pLista1.add(pM1);
        Equipo pEquipo1 = new Equipo(pLista1, 1, "rojo", 1);

        ArrayList<PersonaMutante> pLista2 = new ArrayList<>();
        PersonaMutante pM3 = new PersonaMutante(3, true, 0, 0, 0, new PoderMutanteFuerte());
        pM3.setVida(3);
        pLista2.add(pM3);
        Equipo pEquipo2 = new Equipo(pLista2, 1, "azul", 1);

        pControl.setEquipo1(pEquipo1);
        pControl.setEquipo2(pEquipo2);

        System.out.println("Vida de pM3 antes: " + pM3.getVida());
        pControl.EjecutarAccion(pM1, pM3);
        System.out.println("Vida de pM3 despues de 1 ataque: " + pM3.getVida());

        System.out.println("\n=== PRUEBA 4: CalcularEstadoEquipo ===");
        System.out.println("Estado combinado (deberia ser true, nadie derrotado aun): "
                + pControl.CalcularEstadoEquipo());

        pControl.EjecutarAccion(pM1, pM3);
        System.out.println("Vida de pM3 despues del 2do ataque: " + pM3.getVida());
        System.out.println("Vivos en Equipo2 (deberia ser 0): " + pEquipo2.getVivos());
        System.out.println("Estado combinado ahora (deberia ser false): "
                + pControl.CalcularEstadoEquipo());

        System.out.println("\n=== PRUEBA 5: IniciarVariables + PlayGame ===");
        ControlJuego pControlCompleto = new ControlJuego(5);

        long pInicio = System.currentTimeMillis();
        pControlCompleto.PlayGame();
        long pFin = System.currentTimeMillis();

        System.out.println("PlayGame termino en " + (pFin - pInicio) + " ms");
        System.out.println("Tablero generado: " + pControlCompleto.getTablero().getX()
                + "x" + pControlCompleto.getTablero().getY() + " (esperado 25x25)");
        System.out.println("EstadoEquipo1=" + pControlCompleto.getEquipo1().getEstadoEquipo()
                + "  EstadoEquipo2=" + pControlCompleto.getEquipo2().getEstadoEquipo());
        System.out.println("Vivos finales: Equipo1=" + pControlCompleto.getEquipo1().getVivos()
                + "  Equipo2=" + pControlCompleto.getEquipo2().getVivos());
    }
}