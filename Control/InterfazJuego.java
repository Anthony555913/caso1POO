package Control;

import Team.Equipo;
import molde.PersonaMutante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.OutputStream;
import java.io.PrintStream;

public class InterfazJuego extends JFrame {

    private ControlJuego pControl;
    private TableroPanel pPanelTablero;
    private JTextArea pAreaLog;
    private JLabel pEtiquetaEstado;
    private JTextField pCampoCantidad;
    private JButton pBotonIniciar;
    private Timer pTimer;
    private int pTotalInicial;

    public InterfazJuego() {
        super("Batalla de Mutantes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel pPanelControles = new JPanel();
        pPanelControles.add(new JLabel("Mutantes por equipo:"));
        pCampoCantidad = new JTextField("5", 4);
        pPanelControles.add(pCampoCantidad);
        pBotonIniciar = new JButton("Iniciar Juego");
        pPanelControles.add(pBotonIniciar);
        add(pPanelControles, BorderLayout.NORTH);

        pPanelTablero = new TableroPanel();
        pPanelTablero.setPreferredSize(new Dimension(500, 500));
        add(pPanelTablero, BorderLayout.CENTER);

        pAreaLog = new JTextArea();
        pAreaLog.setEditable(false);
        JScrollPane pScroll = new JScrollPane(pAreaLog);
        pScroll.setPreferredSize(new Dimension(320, 500));
        add(pScroll, BorderLayout.EAST);

        pEtiquetaEstado = new JLabel("Presiona 'Iniciar Juego' para comenzar.");
        add(pEtiquetaEstado, BorderLayout.SOUTH);

        pBotonIniciar.addActionListener(this::alPresionarIniciar);

        redirigirSystemOutAlLog();

        pack();
        setLocationRelativeTo(null);
    }

    private void redirigirSystemOutAlLog() {
        OutputStream pFlujoLog = new OutputStream() {
            private StringBuilder pLinea = new StringBuilder();

            @Override
            public void write(int b) {
                char c = (char) b;
                if (c == '\n') {
                    String pTexto = pLinea.toString();
                    pLinea.setLength(0);
                    SwingUtilities.invokeLater(() -> {
                        pAreaLog.append(pTexto + "\n");
                        pAreaLog.setCaretPosition(pAreaLog.getDocument().getLength());
                    });
                } else {
                    pLinea.append(c);
                }
            }
        };
        System.setOut(new PrintStream(pFlujoLog, true));
    }

    private void alPresionarIniciar(ActionEvent pEvento) {
        int pCantidad;
        try {
            pCantidad = Integer.parseInt(pCampoCantidad.getText().trim());
            if (pCantidad <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un numero entero positivo.",
                    "Dato invalido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        pAreaLog.setText("");
        pBotonIniciar.setEnabled(false);
        pCampoCantidad.setEnabled(false);

        pControl = new ControlJuego(pCantidad);
        pControl.IniciarVariables();
        pTotalInicial = (pControl.getCanIntegrantePorEquipo() * 2) + 1;

        pPanelTablero.setControl(pControl);
        pPanelTablero.repaint();
        actualizarEtiquetaEstado();

        pTimer = new Timer(400, this::ejecutarUnTurno);
        pTimer.start();
    }

    private void ejecutarUnTurno(ActionEvent pEvento) {
        if (!pControl.CalcularEstadoEquipo()) {
            pTimer.stop();
            declararGanador();
            return;
        }

        int pCanAtual = pTotalInicial - (pControl.getEquipo1().getVivos() + pControl.getEquipo2().getVivos());
        int pAumento = Math.min(pCanAtual, 5);

        pControl.Mover(pAumento);
        pControl.DefinirAccion();

        pPanelTablero.repaint();
        actualizarEtiquetaEstado();

        if (!pControl.CalcularEstadoEquipo()) {
            pTimer.stop();
            declararGanador();
        }
    }

    private void declararGanador() {
        String pGanador;
        if (pControl.getEquipo1().getEstadoEquipo() && !pControl.getEquipo2().getEstadoEquipo()) {
            pGanador = "Equipo Rojo (Equipo1) gana!";
        } else if (!pControl.getEquipo1().getEstadoEquipo() && pControl.getEquipo2().getEstadoEquipo()) {
            pGanador = "Equipo Azul (Equipo2) gana!";
        } else {
            pGanador = "Empate / juego terminado.";
        }
        pEtiquetaEstado.setText(pGanador);
        System.out.println(">>> " + pGanador);
        pBotonIniciar.setEnabled(true);
        pCampoCantidad.setEnabled(true);
    }

    private void actualizarEtiquetaEstado() {
        pEtiquetaEstado.setText("Equipo1 vivos: " + pControl.getEquipo1().getVivos()
                + "   |   Equipo2 vivos: " + pControl.getEquipo2().getVivos());
    }

    private static class TableroPanel extends JPanel {
        private ControlJuego pControlRef;

        public void setControl(ControlJuego pControl) {
            this.pControlRef = pControl;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (pControlRef == null || pControlRef.getTablero() == null) {
                g.drawString("Sin partida activa.", 20, 20);
                return;
            }

            int pTamanoTablero = Math.max(pControlRef.getTablero().getX(), pControlRef.getTablero().getY()) + 1;
            int pAncho = getWidth();
            int pAlto = getHeight();
            double pEscala = Math.min(pAncho, pAlto) / (double) pTamanoTablero;

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, pAncho, pAlto);

            g.setColor(new Color(230, 230, 230));
            for (int i = 0; i <= pTamanoTablero; i++) {
                int pPos = (int) (i * pEscala);
                g.drawLine(pPos, 0, pPos, pAlto);
                g.drawLine(0, pPos, pAncho, pPos);
            }

            dibujarEquipo(g, pControlRef.getEquipo1(), Color.RED, pEscala);
            dibujarEquipo(g, pControlRef.getEquipo2(), Color.BLUE, pEscala);
        }

        private void dibujarEquipo(Graphics g, Equipo pEquipo, Color pColor, double pEscala) {
            if (pEquipo == null || pEquipo.getIntegrantes() == null) {
                return;
            }
            int pRadio = (int) Math.max(pEscala * 0.6, 8);
            for (PersonaMutante pMutante : pEquipo.getIntegrantes()) {
                int px = (int) (pMutante.getX() * pEscala);
                int py = (int) (pMutante.getY() * pEscala);

                if (pMutante.getEstado()) {
                    g.setColor(pColor);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                g.fillOval(px - pRadio / 2, py - pRadio / 2, pRadio, pRadio);

                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(pMutante.getId()), px - pRadio / 4, py + pRadio / 4);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazJuego().setVisible(true));
    }
}