package molde;

public class MainTest {
    public static void main(String[] args) {

        // Creamos un poder para asignarle a la persona mutante
        Poder pPoderDebil = new PoderMutanteDebil();

        // Creamos una PersonaMutante usando el constructor
        PersonaMutante pMutante1 = new PersonaMutante(1, true, 5, 0, 0, pPoderDebil);

        // Probamos los getters
        System.out.println("--- Datos iniciales ---");
        System.out.println("Id: " + pMutante1.getId());
        System.out.println("Estado (vivo): " + pMutante1.getEstado());
        System.out.println("Vida: " + pMutante1.getVida());
        System.out.println("Defensa: " + pMutante1.getDefensa());
        System.out.println("Posicion: (" + pMutante1.getX() + ", " + pMutante1.getY() + ")");

        // Probamos UsarPoder() de PersonaMutante (delega en PoderMutante.UsarPoder())
        int danno = pMutante1.UsarPoder();
        System.out.println("\n--- Uso de poder ---");
        System.out.println("Danno causado por el poder de pMutante1: " + danno);

        // Probamos los setters
        System.out.println("\n--- Probando setters ---");
        pMutante1.setVida(80);
        pMutante1.setX(3);
        pMutante1.setY(4);
        pMutante1.setDefensa(10);

        System.out.println("Vida actualizada: " + pMutante1.getVida());
        System.out.println("Posicion actualizada: (" + pMutante1.getX() + ", " + pMutante1.getY() + ")");
        System.out.println("Defensa actualizada: " + pMutante1.getDefensa());

        // Segunda PersonaMutante para probar interacción
        Poder pPoderFuerte = new PoderMutanteFuerte();
        PersonaMutante pMutante2 = new PersonaMutante(2, true, 8, 0, 0, pPoderFuerte);

        System.out.println("\n--- Segunda PersonaMutante ---");
        System.out.println("Id: " + pMutante2.getId());
        System.out.println("Danno causado por el poder de pMutante2: " + pMutante2.UsarPoder());

        // Simular derrota
        pMutante2.setEstado(false);
        System.out.println("\n--- Simulando derrota de pMutante2 ---");
        System.out.println("Estado de pMutante2 (deberia ser false): " + pMutante2.getEstado());
    }
}