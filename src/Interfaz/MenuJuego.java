package Interfaz;

import Jugadores.Jugador;
import Materiales.Ficha;

import javax.swing.*;
import java.awt.*;

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
        boolean esTurno = jugador1.getTurno();
        nombreJugador1 = new JLabel(jugador1.getNombre() + " (Jugador 1) con la ficha de color" + jugador1.getFicha().getColorFicha());
        nombreJugador1.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        nombreJugador1.setForeground(Color.BLACK);
        nombreJugador1.setBackground(esTurno ? Color.GREEN : Color.RED);
        nombreJugador1.setOpaque(true);

        nombreJugador1.setBounds(0, 50, 800, 50);
        return nombreJugador1;
    }
    private JLabel crearNombreJugador2() {
        boolean esTurno = jugador2.getTurno();
        nombreJugador2 = new JLabel(jugador2.getNombre() + " (Jugador 2) con la ficha de color" + jugador2.getFicha().getColorFicha());
        nombreJugador2.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        nombreJugador2.setForeground(Color.BLACK);
        nombreJugador2.setBackground(esTurno ? Color.GREEN : Color.RED);
        nombreJugador2.setOpaque(true);
        nombreJugador2.setBounds(800, 50, 800, 50);
        return nombreJugador2;
    }
}
