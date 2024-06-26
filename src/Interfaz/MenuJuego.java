package Interfaz;

import CartasSuerte.CartaSuerte;
import Casillas.*;
import Interfaces.ActualizarPosicionCallBack;
import Interfaces.CerrarVentanaCallback;
import Interfaz.Componentes.*;
import Jugadores.Jugador;
import Materiales.Dado;
import Materiales.Ficha;
import Partidas.Partidas;
import Sonido.SonidoClick;
import Sonido.SonidoInicio;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MenuJuego extends JFrame {

    private SonidoInicio sonidoInicio;
    boolean partidaCargada = false;
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
    private PlayerLabel jugadorTurno;
    private JLabel resultadoDados = new JLabel();
    private JLabel labelFondo;
    private JPanel panelFondo;

    public MenuJuego(Jugador jugador1, Jugador jugador2, SonidoInicio sonidoInicio) {
        this.sonidoInicio = sonidoInicio;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        sonidoInicio.parar();
        jugadorActual = this.determinarJugadorTurno();
        jugadorNoTurno = this.determinarJugadorNoTurno();
        this.tablero = new Tablero(jugador1, jugador2);
        initComponents();
        this.comenzarPartida();
    }

    public MenuJuego(Jugador jugadorActual, Jugador jugadorNoTurno, Tablero tablero) {
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
        this.jugadorNoTurno = jugadorNoTurno;
        this.partidaCargada = true;
        initComponents();
        this.comenzarPartida();
    }

    private void initComponents() {
        setTitle("Megapoly - Menu Juego");
        setSize(1200, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        crearIconoDeVentana();
        this.createUIComponents();
    }

    private void crearIconoDeVentana() {
        ImageIcon icono = new ImageIcon(this.getClass().getResource("/Imagenes/Megapoly-icon.png"));
        setIconImage(icono.getImage());
    }

    private void createUIComponents() {
        add(crearPanelFondo());
    }

    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Jugador 1", new Ficha("Rojo"));
        Jugador jugador2 = new Jugador("Jugador 2", new Ficha("Azul"));
        SonidoInicio sonidoInicio = new SonidoInicio();
        MenuJuego menuJuego = new MenuJuego(jugador1, jugador2, sonidoInicio);
        menuJuego.setVisible(true);
    }

    private JPanel crearPanelFondo() {
        JPanel panelFondo = new JPanel();
        panelFondo.setSize(1200, 1080);
        panelFondo.setLayout(null);
        panelFondo.add(crearLabelFondo());
        return panelFondo;
    }

    private JLabel crearLabelFondo() {
        ImageIcon fondoMegaPoly = new ImageIcon(this.getClass().getResource("/Imagenes/Tablero3.jpg"));
        this.labelFondo = new JLabel(fondoMegaPoly);
        labelFondo.setBounds(0, 0, 1200, 1140);
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
        menu.setFont(new Font("Arial", Font.BOLD, 18));
        menu.setBackground(Color.ORANGE);
        this.OpcionesComboBox();
        return menu;
    }

    private void OpcionesComboBox() {
        menu.addActionListener(e -> {
            if (menu.getSelectedItem().equals("Guardar Partida")) {
                // guardar partida con fecha y hora
                new CustomDialogGuardarPartida(this, "Guardar Partida", jugadorActual, jugadorNoTurno, tablero);
            } else if (menu.getSelectedItem().equals("Cargar Partida")) {
                // cargar partida
                new ListaPartidasFrame(Partidas.listarPartidas(), this.cerrarVentana(), this.sonidoInicio);

            } else if (menu.getSelectedItem().equals("Salir")) {
                System.exit(0);
            }
        });
    }

    private CerrarVentanaCallback cerrarVentana() {
        return this::dispose;
    }

    private FancyPlayerLabel crearNombreJugador1() {
        if (partidaCargada) {
            this.jugador1 = jugadorActual.getFicha().getColorFicha().equals("Rojo") ? jugadorActual : jugadorNoTurno;
        }
        String nombreStringJugador1 = jugador1.getNombre();
        String colorFichaJugador1 = jugador1.getFicha().getColorFicha();
        int megaMonedasJugador1 = jugador1.getMegaMonedas();
        nombreJugador1 = new FancyPlayerLabel(nombreStringJugador1 + " (Jugador 1) Ficha: " + colorFichaJugador1 + " MegaMonedas: " + megaMonedasJugador1);
        nombreJugador1.setBounds(0, 50, 600, 50);
        return nombreJugador1;
    }

    private FancyPlayerLabel crearNombreJugador2() {
        // Si la partida esta cargada, buscamos que le tiene la ficha azul
        if (partidaCargada) {
            this.jugador2 = jugadorActual.getFicha().getColorFicha().equals("Azul") ? jugadorActual : jugadorNoTurno;

        }
        String nombreStringJugador2 = jugador2.getNombre();
        String colorFichaJugador2 = jugador2.getFicha().getColorFicha();
        int megaMonedasJugador2 = jugador2.getMegaMonedas();
        nombreJugador2 = new FancyPlayerLabel(nombreStringJugador2 + " (Jugador 2) Ficha: " + colorFichaJugador2 + " MegaMonedas: " + megaMonedasJugador2);
        nombreJugador2.setBounds(600, 50, 600, 50);
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

    private RoundedButton botonTirarDados() {
        RoundedButton botonTirarDados = new RoundedButton("Tirar Dados");
        botonTirarDados.setBounds(500, 500, 200, 50);
        botonTirarDados.addActionListener(e -> {
            this.tirarDados();
            SwingUtilities.invokeLater(() -> {
                this.evaluarPartidaTerminada();
            });
        });
        return botonTirarDados;
    }

    private RoundedButton botonCartasSuerte() {
        RoundedButton botonCartasSuerte = new RoundedButton("Cartas Suerte");
        botonCartasSuerte.setBounds(500, 600, 200, 50);
        botonCartasSuerte.addActionListener(e -> {
            this.jugadorActual.mostrarCartasSuerte(this.jugadorNoTurno, this.repintarTablero());
        });
        return botonCartasSuerte;
    }

    private PlayerLabel nombreJugadorActual() {
        Jugador jugador = this.determinarJugadorTurno();
        jugadorTurno = new PlayerLabel("Turno de: " + jugador.getNombre());
        jugadorTurno.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jugadorTurno.setForeground(Color.BLACK);
        jugadorTurno.setBounds(400, 400, 400, 50);
        jugadorTurno.setFont(new Font("Arial", Font.BOLD, 20));
        return jugadorTurno;
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
        this.jugadorNoTurno = this.determinarJugadorNoTurno();
        jugadorTurno.setText("Turno de: " + jugadorActual.getNombre());
        this.colorFondoJugadorTurno();
    }

    private void fichaEnTablero() {
        this.actualizarPosicion();
    }

    private ActualizarPosicionCallBack repintarTablero() {
        return this::actualizarPosicion;
    }


    private void actualizarPosicion() {
        Ficha fichaRoja = jugador1.getFicha();
        Ficha fichaAzul = jugador2.getFicha();
        int posicionFichaRojaActual = jugador1.getFicha().getPosicion();
        int posicionFichaAzulActual = jugador2.getFicha().getPosicion();
        actualizarMegaMonedas();
        nombreJugador1.repaint();
        nombreJugador2.repaint();
        int j = 0;
        for (JLabel label : arrayTablero.keySet()) {
            label.remove(fichaRoja);
            label.remove(fichaAzul);
            label.repaint();
            if (j == posicionFichaRojaActual && j == posicionFichaAzulActual) {
                label.add(fichaRoja);
                label.add(fichaAzul);
                label.repaint();
            } else if (j == posicionFichaAzulActual) {
                label.add(fichaAzul);
                label.repaint();
            } else if (j == posicionFichaRojaActual) {
                label.add(fichaRoja);
                label.repaint();
            }
            j++;
        }
        for (JLabel label : arrayTablero.keySet()) {
            Casilla casilla = arrayTablero.get(label);
            if (casilla instanceof CasillaPropiedad) {
                Jugador propietario = ((CasillaPropiedad) casilla).getPropietario();
                if (propietario.equals(jugador1)) {
                    label.setBackground(new Color(94, 2, 2, 255));
                    label.setOpaque(true);
                    label.repaint();
                } else if (propietario.equals(jugador2)) {
                    label.setBackground(new Color(0, 0, 151, 255));
                    label.setOpaque(true);
                    label.repaint();
                } else {
                    label.setOpaque(false);
                }
            }
        }
    }

    ;


    private void tirarDados() {
        dado.setNumeroAleatorio();

        new AnimacionDado(dado.getNumero());
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
                return false;
            }
            JOptionPane.showMessageDialog(null, "Has sacado un " + dado.getNumero() + " , sigues en la carcel");
            this.fichaEnTablero();
            this.cambiarTurno();
            return true;
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
                    ((CasillaPolicia) casilla).sonarSonido();
                    ((CasillaPolicia) casilla).enviarCarcel(jugadorActual, this.repintarTablero());
                }
                if (casilla instanceof CasillaImpuesto) {
                    ((CasillaImpuesto) casilla).sonarSonido();
                    ((CasillaImpuesto) casilla).aplicarImpuesto(this.jugadorActual, this.repintarTablero());
                }
                if (casilla instanceof CasillaPropiedad) {
                    ((CasillaPropiedad) casilla).evaluarPropiedad(jugadorActual, this.repintarTablero());
                }
                if (casilla instanceof CasillaAleatoria) {
                    ((CasillaAleatoria) casilla).efectoAleatorio(jugadorActual, jugadorNoTurno, this.repintarTablero());
                }
            }
            i++;
        }
    }

    private void evaluarPartidaTerminada() {
        if (jugador1.getMegaMonedas() <= 0) {
            new JDialogFinPartida(this, "El jugador " + jugadorActual.getNombre() + " ha ganado la partida", "Fin de la partida", this.cerrarVentana());

        }
        if (jugador2.getMegaMonedas() <= 0) {
            new JDialogFinPartida(this, "El jugador " + jugadorNoTurno.getNombre() + " ha ganado la partida", "Fin de la partida", this.cerrarVentana());
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
        this.actualizarPosicion();
    }
}
