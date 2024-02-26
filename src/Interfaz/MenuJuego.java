package Interfaz;

import Casillas.Casilla;
import Interfaz.Componentes.Boton;
import Jugadores.Jugador;
import Materiales.Ficha;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MenuJuego extends JFrame {

    Jugador jugador1;
    Jugador jugador2;
    private JComboBox menu;
    private JLabel nombreJugador1;
    private JLabel nombreJugador2;

    private JPanel panelFondo;

    public MenuJuego(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
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
        JLabel labelFondo = new JLabel(fondoMegaPoly);
        labelFondo.setSize(1600, 1200);
        labelFondo.setBounds(0, 0, 1600, 1200);
        labelFondo.add(crearMenu());
        labelFondo.add(crearNombreJugador1());
        labelFondo.add(crearNombreJugador2());
        labelFondo.add(botonTirarDados());
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

    private JLabel crearNombreJugador1() {
        String nombreStringJugador1 = jugador1.getNombre();
        String colorFichaJugador1 = jugador1.getFicha().getColorFicha();
        int megaMonedasJugador1 = jugador1.getMegaMonedas();
        nombreJugador1 = new JLabel(nombreStringJugador1 + " (Jugador 1) Ficha: " + colorFichaJugador1 + " MegaMonedas: " + megaMonedasJugador1);
        nombreJugador1.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        nombreJugador1.setForeground(Color.BLACK);
        nombreJugador1.setOpaque(true);
        nombreJugador1.setBounds(0, 50, 800, 50);
        return nombreJugador1;
    }

    private JLabel crearNombreJugador2() {
        String nombreStringJugador2 = jugador2.getNombre();
        String colorFichaJugador2 = jugador2.getFicha().getColorFicha();
        int megaMonedasJugador2 = jugador2.getMegaMonedas();
        nombreJugador2 = new JLabel(nombreStringJugador2 + " (Jugador 2) Ficha: " + colorFichaJugador2 + " MegaMonedas: " + megaMonedasJugador2);
        nombreJugador2.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        nombreJugador2.setForeground(Color.BLACK);
        nombreJugador2.setOpaque(true);
        nombreJugador2.setBounds(800, 50, 800, 50);
        return nombreJugador2;
    }

    private void colorFondoJugadorTurno() {
        this.nombreJugador1.setBackground(jugador1.getTurno() ? Color.GREEN : Color.RED);
        this.nombreJugador2.setBackground(jugador2.getTurno() ? Color.GREEN : Color.RED);
    }

    private void ponerTableroEnPantalla(JLabel labelFondo) {
        Tablero tablero = new Tablero(jugador1, jugador2);
        Map<JLabel, Casilla> valoresTablero = tablero.getTablero();
        for (JLabel label : valoresTablero.keySet()) {
            labelFondo.add(label);
        }
    }

    private Boton botonTirarDados() {
        Boton botonTirarDados = new Boton("Tirar Dados");
        botonTirarDados.setBounds(700, 700, 200, 50);
        botonTirarDados.addActionListener(e -> {
        });
        return botonTirarDados;
    }


    // toda la logica del juego al comenzar partida
    private void comenzarPartida() {
        jugador1.setTurno(true);
        this.colorFondoJugadorTurno();

    }
}
