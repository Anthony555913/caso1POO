package BattleField;

public class TestBattleField {
    public static void main(String[] args) {

        BattleField pTablero = new BattleField(30, 30);

        System.out.println("--- Datos iniciales ---");
        System.out.println("X: " + pTablero.getX());
        System.out.println("Y: " + pTablero.getY());

        System.out.println("\n--- Probando setters ---");
        pTablero.setX(50);
        pTablero.setY(20);
        System.out.println("X actualizado: " + pTablero.getX());
        System.out.println("Y actualizado: " + pTablero.getY());

        System.out.println("\n--- Probando constructor vacio ---");
        BattleField pTableroVacio = new BattleField();
        System.out.println("X (deberia ser 0): " + pTableroVacio.getX());
        System.out.println("Y (deberia ser 0): " + pTableroVacio.getY());

        System.out.println("\n--- Simulando IniciarVariables (CanIntegrantePorEquipo=6) ---");
        int pCanIntegrantePorEquipo = 6;
        int pTamano = pCanIntegrantePorEquipo * 5;
        BattleField pTableroCalculado = new BattleField(pTamano, pTamano);
        System.out.println("Tamano esperado: " + pTamano);
        System.out.println("X: " + pTableroCalculado.getX() + "  Y: " + pTableroCalculado.getY());
    }
}