package Control;

import BattleField.BattleField;
import Team.Equipo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import molde.*;


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
    
        int dannoBase = pAtacante.UsarPoder();

        Random pRandom = new Random();
        boolean seDefiende = pRandom.nextBoolean(); 

        int dannoFinal=0;

        if (seDefiende) {
            dannoFinal = dannoBase - pObjetivo.getDefensa();
        } else {
            dannoFinal = dannoBase;
            System.out.println("Mutante " + pObjetivo.getId() + " no se defendió.");
            }
        if (dannoFinal < 0) {
            dannoFinal = 0; // evita que el daño negativo "cure" al objetivo
        }
    
        int vidaRestante = pObjetivo.getVida() - dannoFinal;
        pObjetivo.setVida(vidaRestante);
    
        System.out.println("Mutante " + pAtacante.getId() + " ataca a Mutante "
                + pObjetivo.getId() + " causando " + dannoFinal + " de daño. Vida restante: "
                + Math.max(vidaRestante, 0));
    
        if (vidaRestante <= 0) {
            pObjetivo.setEstado(false);
            System.out.println("Mutante " + pObjetivo.getId() + " ha sido derrotado.");
            if (this.Equipo1.getIntegrantes().contains(pObjetivo)) {
                this.Equipo1.RestarVivos(1);
            } else if (this.Equipo2.getIntegrantes().contains(pObjetivo)) {
                this.Equipo2.RestarVivos(1);
            }
            if (pAtacante.UsarPoder() < 7) {

                pAtacante.setAtaqueAumento(pAtacante.getAtaqueAumento()+1);
                System.out.println("Mutante " + pAtacante.getId() + " sube su daño a "
                        + pAtacante.UsarPoder());
            }
        }
    }
    public void DefinirAccion() {
        for (PersonaMutante pAtacante : this.Equipo1.getIntegrantes()) {
            for (PersonaMutante pObjetivo : this.Equipo2.getIntegrantes()) {
                double distancia = CalDistancia(pAtacante, pObjetivo);
                if (pAtacante.getEstado() == true && pObjetivo.getEstado() == true && distancia<=5) {
                    Random pRandom = new Random();
                    boolean seDefiende = pRandom.nextBoolean(); 
                    if(seDefiende){
                        EjecutarAccion(pAtacante, pObjetivo);
                    }else{
                        EjecutarAccion(pObjetivo, pAtacante);
                    }
                }
            }
        }
    }
    public void Mover(int pAumento) {
        List<PersonaMutante> pTodos = new ArrayList<PersonaMutante>();
        pTodos.addAll(this.Equipo1.getIntegrantes());
        pTodos.addAll(this.Equipo2.getIntegrantes());

        Random pRandom = new Random();

        for (PersonaMutante pMutante : pTodos) {
            if (pMutante.getEstado() == true) {

                // -1, 0 o 1 en cada eje -> cubre horizontal, vertical y diagonal
                int direccionX = pRandom.nextInt(3) - 1;
                int direccionY = pRandom.nextInt(3) - 1;

                int nuevaX = pMutante.getX() + (direccionX * pAumento);
                int nuevaY = pMutante.getY() + (direccionY * pAumento);
                if (this.Tablero != null) {
                    nuevaX = Math.max(0, Math.min(nuevaX, this.Tablero.getX()));
                    nuevaY = Math.max(0, Math.min(nuevaY, this.Tablero.getY()));
                }

                // Revisar aquí mismo si algún otro mutante ya ocupa esa posición
                boolean pOcupada = false;
                for (PersonaMutante pOtro : pTodos) {
                    if (pOtro != pMutante && pOtro.getEstado() == true) {
                        if (pOtro.getX() == nuevaX && pOtro.getY() == nuevaY) {
                            pOcupada = true;
                            break;
                        }
                    }
                }

                if (!pOcupada) {
                    pMutante.setX(nuevaX);
                    pMutante.setY(nuevaY);
                    System.out.println("Mutante " + pMutante.getId() + " se mueve a ("
                            + nuevaX + ", " + nuevaY + ")");
                } else {

                }
            }
        }
    }

    public void PlayGame() {
        IniciarVariables();
        int total=(this.CanIntegrantePorEquipo*2)+1;
        while (CalcularEstadoEquipo()) {
            int pCanAtual = total-(this.Equipo1.getVivos()+this.Equipo2.getVivos());
            final int pAumento = Math.min(pCanAtual, 5);
            Thread pHiloMover = new Thread(() -> Mover(pAumento));
            Thread pHiloDefinir = new Thread(() -> DefinirAccion());
            pHiloMover.start();
            pHiloDefinir.start();

            try {
                pHiloMover.join();
                pHiloDefinir.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("Juego terminado.");
    }


    public void IniciarVariables() {
        int pTamanoTablero = this.CanIntegrantePorEquipo * 5;
        this.Tablero = new BattleField(pTamanoTablero, pTamanoTablero);

        this.Equipo1 = CrearEquipoAleatorio("rojo", 1);
        this.Equipo2 = CrearEquipoAleatorio("azul", this.CanIntegrantePorEquipo + 1);
    }

    private Equipo CrearEquipoAleatorio(String pColor, int pIdInicial) {
        ArrayList<PersonaMutante> pIntegrantes = new ArrayList<>();
        int pTamanoTablero = this.CanIntegrantePorEquipo * 5;
        Random pRandom = new Random();

        for (int i = 0; i < this.CanIntegrantePorEquipo; i++) {
            int pId = pIdInicial + i;
            int pDefensa = pRandom.nextInt(10) + 1; // defensa entre 1 y 10
            int pX = pRandom.nextInt(pTamanoTablero + 1); // 0..pTamanoTablero
            int pY = pRandom.nextInt(pTamanoTablero + 1);

            PersonaMutante pMutante;
            int pTipoPoder = pRandom.nextInt(3);
            if (pTipoPoder == 0) {
                pMutante = new PersonaMutante(pId, true, pDefensa, pX, pY, new PoderMutanteDebil());
            } else if (pTipoPoder == 1) {
                pMutante = new PersonaMutante(pId, true, pDefensa, pX, pY, new PoderMutanteMedio());
            } else {
                pMutante = new PersonaMutante(pId, true, pDefensa, pX, pY, new PoderMutanteFuerte());
            }

            pIntegrantes.add(pMutante);
        }

        return new Equipo(pIntegrantes, this.CanIntegrantePorEquipo, pColor, this.CanIntegrantePorEquipo);
    }
}