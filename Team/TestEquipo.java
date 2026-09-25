package Team;

import molde.PersonaMutante;
import molde.PoderMutanteDebil;
import java.util.ArrayList;

public class TestEquipo {
    public static void main(String[] args) {

        ArrayList<PersonaMutante> pIntegrantes = new ArrayList<>();
        pIntegrantes.add(new PersonaMutante(1, true, 5, 0, 0, new PoderMutanteDebil()));
        pIntegrantes.add(new PersonaMutante(2, true, 5, 1, 1, new PoderMutanteDebil()));
        pIntegrantes.add(new PersonaMutante(3, true, 5, 2, 2, new PoderMutanteDebil()));

        Equipo pEquipo = new Equipo(pIntegrantes, 3, "rojo", 3);

        System.out.println("--- Datos iniciales ---");
        System.out.println("Color: " + pEquipo.getColor());
        System.out.println("CanIntegrantes: " + pEquipo.getCanIntegrantes());
        System.out.println("Vivos: " + pEquipo.getVivos());
        System.out.println("EstadoEquipo: " + pEquipo.getEstadoEquipo());
        System.out.println("Cantidad de integrantes en la lista: " + pEquipo.getIntegrantes().size());

        System.out.println("\n--- Probando setters ---");
        pEquipo.setColor("azul");
        pEquipo.setCanIntegrantes(5);
        System.out.println("Color actualizado: " + pEquipo.getColor());
        System.out.println("CanIntegrantes actualizado: " + pEquipo.getCanIntegrantes());

        System.out.println("\n--- Restando 1 vivo (quedan 2) ---");
        pEquipo.RestarVivos(1);
        System.out.println("Vivos: " + pEquipo.getVivos());
        System.out.println("EstadoEquipo (deberia seguir true): " + pEquipo.getEstadoEquipo());

        System.out.println("\n--- Restando 2 vivos mas (llega a 0) ---");
        pEquipo.RestarVivos(2);
        System.out.println("Vivos: " + pEquipo.getVivos());
        System.out.println("EstadoEquipo (deberia ser false): " + pEquipo.getEstadoEquipo());

        System.out.println("\n--- Probando constructor vacio ---");
        Equipo pEquipoVacio = new Equipo();
        System.out.println("Color (deberia ser null): " + pEquipoVacio.getColor());
        System.out.println("Vivos (deberia ser 0): " + pEquipoVacio.getVivos());
        System.out.println("EstadoEquipo (deberia ser true, valor por defecto): " + pEquipoVacio.getEstadoEquipo());
    }
}