package Interfaz;

import Interfaz.Componentes.Boton;
import Sonido.SonidoClick;
import Sonido.SonidoInicio;

import javax.swing.*;
import java.awt.*;

public class MenuInicio extends JFrame {

    private final SonidoInicio sonidoInicio = new SonidoInicio();

    private SonidoClick sonidoClick = new SonidoClick();
    private ImageIcon fondoMegaPoly;
    private  Boton botonNuevaPartida;
    private Boton botonCargarPartida;
    private Boton botonSalir;
    private JPanel panelFondo;
    private JLabel labelFondo;
    private JLabel labelTitulo;
    private final int[] sizes = {1600, 1200};


    public static void main(String[] args) {
        MenuInicio menu = new MenuInicio();
        menu.setVisible(true);
    }

    public MenuInicio() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Megapoly - Menu Inicio");
        setSize(sizes[0], sizes[1]);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        sonidoInicio.reproducir();
        this.createUIComponents();
    }
    private void createUIComponents() {
        add(crearPanelFondo());
    }
    private JLabel crearLabelFondo() {
        fondoMegaPoly = new ImageIcon(this.getClass().getResource("/Imagenes/ImagenMenuInicio.jpg"));
        labelFondo = new JLabel(fondoMegaPoly);
        labelFondo.setSize(sizes[0], sizes[1]);
        labelFondo.setBounds(0, 0, sizes[0], sizes[1]);
        labelFondo.add(crearLabelTitulo());
        labelFondo.add(crearBotonNuevaPartida());
        labelFondo.add(crearBotonCargarPartida());
        labelFondo.add(crearBotonSalir());
        return labelFondo;
    }
    private JLabel crearLabelTitulo() {
        int labelWidth = sizes[0] /2;
        int frameWidth = sizes[0];
        labelTitulo = new JLabel("MegaPoly");
        labelTitulo.setFont(new java.awt.Font("Kristen ITC", Font.ITALIC, 124));
        labelTitulo.setForeground(Color.BLACK);
        labelTitulo.setBounds(500, 100, labelWidth, 200);
        return labelTitulo;
    }
    private JPanel crearPanelFondo() {
        panelFondo = new JPanel();
        panelFondo.setSize(sizes[0], sizes[1]);
        panelFondo.setLayout(null);
        panelFondo.add(crearLabelFondo());
        return panelFondo;
    }
    private Boton crearBotonNuevaPartida() {
        botonNuevaPartida = new Boton("Nueva Partida");
        botonNuevaPartida.setBounds(700, 700, 200, 50);
        botonNuevaPartida.addActionListener(e -> {
            sonidoClick.reproducir();
            sonidoInicio.parar();
            MenuJugadores menuJugadores = new MenuJugadores();
            menuJugadores.setVisible(true);
            dispose();
        });
        return botonNuevaPartida;
    }
    private Boton crearBotonCargarPartida() {
        botonCargarPartida = new Boton("Cargar Partida");
        botonCargarPartida.setBounds(700, 800, 200, 50);
        botonCargarPartida.addActionListener(e -> {
            sonidoClick.reproducir();
            sonidoInicio.parar();
        });
        return botonCargarPartida;
    }
    private Boton crearBotonSalir() {
        botonSalir = new Boton("Salir");
        botonSalir.setBounds(700, 900, 200, 50);
        botonSalir.addActionListener(e -> {
            sonidoClick.reproducir();
            sonidoInicio.parar();
            System.exit(0);
        });
        return botonSalir;
    }

}
