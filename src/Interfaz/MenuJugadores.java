package Interfaz;

import Jugadores.Jugador;
import Materiales.Ficha;
import Sonido.SonidoClick;

import javax.swing.*;
import java.awt.*;

public class MenuJugadores extends JFrame {

    private SonidoClick sonidoClick = new SonidoClick();
    private Ficha fichaRoja = new Ficha("Rojo");
    private Ficha fichaAzul = new Ficha("Azul");
    private Jugador jugador1;
    private Jugador jugador2;
    private final int[] sizes = {1600, 1200};
    private JPanel panelFondo;
    private JLabel labelFondo;
    private JLabel labelTitulo;
    private ImageIcon fondoMegaPoly;
    private JTextField nombreJugador1;
    private JTextField nombreJugador2;
    private JLabel labelNombreJugador1;
    private JButton botonJugar;
private JLabel labelNombreJugador2;

    public static void main(String[] args) {
        MenuJugadores menu = new MenuJugadores();
        menu.setVisible(true);
    }

    public MenuJugadores() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Megapoly - Menu Jugadores");
        setSize(sizes[0], sizes[1]);
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
        panelFondo = new JPanel();
        panelFondo.setSize(sizes[0], sizes[1]);
        panelFondo.setLayout(null);
        panelFondo.add(crearLabelFondo());
        return panelFondo;
    }

    private JLabel crearLabelFondo() {
        fondoMegaPoly = new ImageIcon(this.getClass().getResource("/Imagenes/ImagenMenuInicio.jpg"));
        labelFondo = new JLabel(fondoMegaPoly);
        labelFondo.setSize(sizes[0], sizes[1]);
        labelFondo.setBounds(0, 0, sizes[0], sizes[1]);
        labelFondo.add(crearLabelTitulo());
        labelFondo.add(crearLabelNombreJugador1());
        labelFondo.add(crearLabelNombreJugador2());
        labelFondo.add(crearNombreJugador1());
        labelFondo.add(crearNombreJugador2());
        labelFondo.add(crearBotonJugar());
        return labelFondo;
    }

    private JLabel crearLabelTitulo() {
        int labelWidth = sizes[0] / 2;
        labelTitulo = new JLabel("Megapoly");
        labelTitulo.setFont(new java.awt.Font("Kristen ITC", Font.ITALIC, 124));
        labelTitulo.setForeground(Color.BLACK);
        labelTitulo.setBounds(500, 100, labelWidth, 200);
        return labelTitulo;
    }


    private JTextField crearNombreJugador1() {
        nombreJugador1 = new JTextField();
        nombreJugador1.setBounds(700, 700, 200, 50);
        nombreJugador1.setFont(new java.awt.Font("Kristen ITC", Font.BOLD, 18));
        return nombreJugador1;
    }

    private JTextField crearNombreJugador2() {
        nombreJugador2 = new JTextField();
        nombreJugador2.setBounds(700, 800, 200, 50);
        nombreJugador2.setFont(new java.awt.Font("Kristen ITC", Font.BOLD, 18));
        return nombreJugador2;
    }

    private JLabel crearLabelNombreJugador1() {
        labelNombreJugador1 = new JLabel("Nombre Jugador 1");
        labelNombreJugador1.setFont(new java.awt.Font("Kristen ITC", Font.BOLD, 18));
        labelNombreJugador1.setForeground(Color.BLACK);
        labelNombreJugador1.setBounds(700, 650, 200, 50);
        return labelNombreJugador1;
    }

    private JLabel crearLabelNombreJugador2() {
        labelNombreJugador2 = new JLabel("Nombre Jugador 2");
        labelNombreJugador2.setFont(new java.awt.Font("Kristen ITC", Font.BOLD, 18));
        labelNombreJugador2.setForeground(Color.BLACK);
        labelNombreJugador2.setBounds(700, 750, 200, 50);
        return labelNombreJugador2;
    }

    private JButton crearBotonJugar() {
        botonJugar = new JButton("Jugar");
        botonJugar.setBounds(700, 900, 200, 50);
        botonJugar.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        botonJugar.addActionListener(e -> {
            sonidoClick.reproducir();
            if(nombreJugador1.getText().isEmpty() || nombreJugador2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de ambos jugadores");
                return;
            }
            jugador1 = new Jugador(nombreJugador1.getText(), fichaRoja);
            jugador2 = new Jugador(nombreJugador2.getText(), fichaAzul);
            MenuJuego menuJuego = new MenuJuego(jugador1, jugador2);
            menuJuego.setVisible(true);
            dispose();
        });
        return botonJugar;
    }

}
