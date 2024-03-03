package Interfaz;

import CartasSuerte.CartaSuerte;
import Casillas.*;
import Interfaces.CartaSuerteCallBack;
import Interfaz.Componentes.DiceButton;
import Interfaz.Componentes.FancyPlayerLabel;
import Interfaz.Componentes.RoundedButton;
import Jugadores.Jugador;
import Materiales.Dado;
import Materiales.Ficha;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MenuJuego extends JFrame {

    Jugador jugador1;
    Jugador jugador2;
    Jugador jugadorActual;
    Jugador jugadorNoTurno;
    Tablero tablero;
    Map<JLabel, Casilla> arrayTablero;
    Dado dado = new Dado();
    private JComboBox menu;
    private FancyPlayerLabel nombreJugador1;
    private FancyPlayerLabel nombreJugador2;
    private JLabel jugadorTurno;
    private JLabel resultadoDados = new JLabel();
    private JLabel labelFondo;
    private JPanel panelFondo;

    public MenuJuego(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        jugadorActual = this.determinarJugadorTurno();
        jugadorNoTurno = this.determinarJugadorNoTurno();
        this.tablero = new Tablero(jugador1, jugador2);
        initComponents();
        this.comenzarPartida();
    }

    private void initComponents() {
        setTitle("Megapoly - Menu Juego");
        setSize(1600, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        this.createUIComponents();
    }

    private void createUIComponents() {
        add(crearPanelFondo());
    }

    private JPanel crearPanelFondo() {
        JPanel panelFondo = new JPanel();
        panelFondo.setSize(1600, 1200);
        panelFondo.setLayout(null);
        panelFondo.add(crearLabelFondo());
        return panelFondo;
    }

    private JLabel crearLabelFondo() {
        ImageIcon fondoMegaPoly = new ImageIcon(this.getClass().getResource("/Imagenes/Tablero.jpg"));
        this.labelFondo = new JLabel(fondoMegaPoly);
        labelFondo.setSize(1600, 1200);
        labelFondo.setBounds(0, 0, 1600, 1200);
        labelFondo.add(crearMenu());
        labelFondo.add(crearNombreJugador1());
        labelFondo.add(crearNombreJugador2());
        labelFondo.add(botonTirarDados());
        labelFondo.add(nombreJugadorActual());
        labelFondo.add(botonCartasSuerte());
        labelFondo.add(resultadoDados);
        this.ponerTableroEnPantalla(labelFondo);
        return labelFondo;
    }

    private JComboBox crearMenu() {
        String[] opciones = {"Menu", "Guardar Partida", "Cargar Partida", "Salir"};
        menu = new JComboBox(opciones);
        // position the menu at top left os the screen
        menu.setBounds(0, 0, 200, 30);
        menu.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        menu.setBackground(Color.ORANGE);
        this.OpcionesComboBox();
        return menu;
    }

    private void OpcionesComboBox() {
        menu.addActionListener(e -> {
            if (menu.getSelectedItem().equals("Guardar Partida")) {
                // guardar partida
            } else if (menu.getSelectedItem().equals("Cargar Partida")) {
                // cargar partida
            } else if (menu.getSelectedItem().equals("Salir")) {
                System.exit(0);
            }
        });
    }

    private FancyPlayerLabel crearNombreJugador1() {
        String nombreStringJugador1 = jugador1.getNombre();
        String colorFichaJugador1 = jugador1.getFicha().getColorFicha();
        int megaMonedasJugador1 = jugador1.getMegaMonedas();
        nombreJugador1 = new FancyPlayerLabel(nombreStringJugador1 + " (Jugador 1) Ficha: " + colorFichaJugador1 + " MegaMonedas: " + megaMonedasJugador1);
        nombreJugador1.setBounds(0, 50, 800, 50);
        return nombreJugador1;
    }

    private FancyPlayerLabel crearNombreJugador2() {
        String nombreStringJugador2 = jugador2.getNombre();
        String colorFichaJugador2 = jugador2.getFicha().getColorFicha();
        int megaMonedasJugador2 = jugador2.getMegaMonedas();
        nombreJugador2 = new FancyPlayerLabel(nombreStringJugador2 + " (Jugador 2) Ficha: " + colorFichaJugador2 + " MegaMonedas: " + megaMonedasJugador2);
        nombreJugador2.setBounds(800, 50, 800, 50);
        return nombreJugador2;
    }

    private void colorFondoJugadorTurno() {
        this.nombreJugador1.setBackground(jugador1.getTurno() ? Color.GREEN : Color.RED);
        this.nombreJugador2.setBackground(jugador2.getTurno() ? Color.GREEN : Color.RED);
    }

    private void ponerTableroEnPantalla(JLabel labelFondo) {
        arrayTablero = tablero.getTablero();
        int i = 0;
        for (JLabel label : arrayTablero.keySet()) {
            labelFondo.add(label);
            if (i == 0) {
                label.add(jugador1.getFicha());
                label.add(jugador2.getFicha());
            }
            i++;
        }
    }

    private DiceButton botonTirarDados() {
        DiceButton botonTirarDados = new DiceButton("Tirar Dados");
        botonTirarDados.setBounds(700, 700, 200, 50);
        botonTirarDados.addActionListener(e -> {
            this.tirarDados();
        });
        return botonTirarDados;
    }

    private RoundedButton botonCartasSuerte() {
        RoundedButton botonCartasSuerte = new RoundedButton("Cartas Suerte");
        botonCartasSuerte.setBounds(700, 800, 200, 50);
        botonCartasSuerte.addActionListener(e -> {
            //TODO: no se pinta bien la ficha al volver a la posicion 0
            this.jugadorActual.mostrarCartasSuerte(this.jugadorNoTurno, this.repintarTablero());
        });
        return botonCartasSuerte;
    }

    private JLabel nombreJugadorActual() {
        Jugador jugador = this.determinarJugadorTurno();
        jugadorTurno = new JLabel("Turno de: " + jugador.getNombre());
        jugadorTurno.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        jugadorTurno.setForeground(Color.BLACK);
        jugadorTurno.setBounds(600, 450, 400, 50);
        return jugadorTurno;
    }

    private void resultadoDados() {
        resultadoDados.setText("Has sacado un : " + dado.getNumero());
        resultadoDados.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        resultadoDados.setForeground(Color.BLACK);
        resultadoDados.setBounds(600, 500, 400, 50);
    }

    private Jugador determinarJugadorTurno() {
        if (jugador1.getTurno()) {
            return jugador1;
        } else if (jugador2.getTurno()) {
            return jugador2;
        }
        // Si es el primer turno, el jugador 1 comienza
        jugador1.setTurno(true);
        return jugador1;
    }

    private Jugador determinarJugadorNoTurno() {
        if (jugador1.getTurno()) {
            return jugador2;
        } else if (jugador2.getTurno()) {
            return jugador1;
        }
        return null;
    }

    private void cambiarTurno() {
        jugador1.setTurno(!jugador1.getTurno());
        jugador2.setTurno(!jugador2.getTurno());
        jugadorActual = this.determinarJugadorTurno();
        jugadorTurno.setText("Turno de: " + jugadorActual.getNombre());
        this.colorFondoJugadorTurno();
    }

    private void fichaEnTablero() {
        this.repintarTablero();
    }

    private CartaSuerteCallBack repintarTablero() {
        Ficha fichaRoja = jugador1.getFicha();
        Ficha fichaAzul = jugador2.getFicha();
        int posicionFichaRoja = jugador1.getFicha().getPosicion();
        int posicionFichaAzul = jugador2.getFicha().getPosicion();
        int i = 0;
        for (JLabel label : arrayTablero.keySet()) {
            label.remove(fichaRoja);
            label.remove(fichaAzul);
            label.repaint();
            if (i == posicionFichaRoja && i == posicionFichaAzul) {
                label.add(fichaRoja);
                label.add(fichaAzul);
                label.repaint();
            } else if (i == posicionFichaAzul) {
                label.add(fichaAzul);
                label.repaint();
            } else if (i == posicionFichaRoja) {
                label.add(fichaRoja);
                label.repaint();
            }
            i++;
        }
        return new CartaSuerteCallBack() {
            @Override
            public void onMostrarCartasSuerteFinalizado() {
                System.out.println("repinta tablero");
                actualizarMegaMonedas();
                nombreJugador1.repaint();
                nombreJugador2.repaint();
                //TODO: conseguir que el callback se ejecute al finalizar el metodo
            }
        };
    }

    private void tirarDados() {
        dado.setNumeroAleatorio();
        this.resultadoDados();
        // Si el jugador esta en la carcel, no puede moverse a menos que saque un 5
        boolean siguesCarcel = this.evaluarCarcel();
        if (siguesCarcel) {
            return;
        }
        int posicionActual = jugadorActual.getFicha().getPosicion();
        int numeroDado = dado.getNumero();
        // Si da la vuelta al tablero, recibe 20 MegaMonedas por pasar por la casilla de salida
        if (posicionActual + numeroDado > 39) {
            JOptionPane.showMessageDialog(null, "Has pasado por la casilla de salida, recibes 20 MegaMonedas");
            jugadorActual.setMegaMonedas(jugadorActual.getMegaMonedas() + 20);
            jugadorActual.getFicha().setPosicion(posicionActual + numeroDado - 40);
        } else {
            jugadorActual.getFicha().setPosicion(posicionActual + numeroDado);
        }
        this.fichaEnTablero();
        this.evaluarCasilla();
        this.cambiarTurno(); // funcion aparte
        this.actualizarMegaMonedas();
    }

    private boolean evaluarCarcel() {
        if (jugadorActual.getCarcel()) {
            if (dado.getNumero() == 5) {
                jugadorActual.setCarcel(false);
                JOptionPane.showMessageDialog(null, "Has sacado un 5, sales de la carcel");
                return true;
            }
            JOptionPane.showMessageDialog(null, "Has sacado un " + dado.getNumero() + " , sigues en la carcel");
            this.fichaEnTablero();
            this.cambiarTurno();
            return false;
        }
        return false;
    }

    private void evaluarCasilla() {
        int posicionFicha = jugadorActual.getFicha().getPosicion();
        int i = 0;
        for (Casilla casilla : arrayTablero.values()) {
            if (i == posicionFicha) {
                if (casilla instanceof CasillaSalida) {
                    ((CasillaSalida) casilla).sonarSonido();
                    JOptionPane.showMessageDialog(null, "Has pasado por la casilla de salida, recibes 20 MegaMonedas");
                }
                if (casilla instanceof CasillaSuerte) {
                    ((CasillaSuerte) casilla).sonarSonido();
                    ((CasillaSuerte) casilla).setCarta();
                    CartaSuerte carta = ((CasillaSuerte) casilla).getCarta();
                    jugadorActual.setCartas(carta);
                    ((CasillaSuerte) casilla).mensajeCasillaSuerte(this);

                }
                if (casilla instanceof CasillaParking) {
                    ((CasillaParking) casilla).sonarSonido();
                    ((CasillaParking) casilla).mensajeCasillaParking(this);
                }
                if (casilla instanceof Carcel) {
                    ((Carcel) casilla).sonarSonido();
                    ((Carcel) casilla).mensajeCasillaCarcel(this);
                }
                if (casilla instanceof CasillaPolicia) {
                    ((CasillaPolicia) casilla).enviarCarcel(jugadorActual);
                    ((CasillaPolicia) casilla).sonarSonido();
                }

            }
            i++;
        }
    }

    private void actualizarMegaMonedas() {
        String nombreStringJugador1 = jugador1.getNombre();
        String colorFichaJugador1 = jugador1.getFicha().getColorFicha();
        int megaMonedasJugador1 = jugador1.getMegaMonedas();
        String nombreStringJugador2 = jugador2.getNombre();
        String colorFichaJugador2 = jugador2.getFicha().getColorFicha();
        int megaMonedasJugador2 = jugador2.getMegaMonedas();
        nombreJugador1.setText(nombreStringJugador1 + " (Jugador 1) Ficha: " + colorFichaJugador1 + " MegaMonedas: " + megaMonedasJugador1);
        nombreJugador2.setText(nombreStringJugador2 + " (Jugador 2) Ficha: " + colorFichaJugador2 + " MegaMonedas: " + megaMonedasJugador2);

    }

    // toda la logica del juego al comenzar partida
    private void comenzarPartida() {
        this.colorFondoJugadorTurno();
    }
}
