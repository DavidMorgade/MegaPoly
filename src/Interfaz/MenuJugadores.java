package Interfaz;

import Interfaz.Componentes.*;
import Jugadores.Jugador;
import Materiales.Ficha;
import Sonido.SonidoClick;
import Sonido.SonidoInicio;

import javax.swing.*;
import java.awt.*;

public class MenuJugadores extends JFrame {

    private SonidoClick sonidoClick = new SonidoClick();
    private SonidoInicio sonidoInicio;
    private Ficha fichaRoja = new Ficha("Rojo");
    private Ficha fichaAzul = new Ficha("Azul");
    private Jugador jugador1;
    private Jugador jugador2;
    private final int[] sizes = {1200, 1080};
    private JPanel panelFondo;
    private JLabel labelFondo;
    private TituloMegapoly labelTitulo;
    private ImageIcon fondoMegaPoly;
    private PlayerTextField nombreJugador1;
    private PlayerTextField nombreJugador2;
    private PlayerLabel labelNombreJugador1;
    private RoundedButton botonJugar;
    private PlayerLabel labelNombreJugador2;

    public MenuJugadores(SonidoInicio sonidoInicio) {
        this.sonidoInicio = sonidoInicio;
        initComponents();
    }

    private void initComponents() {
        setTitle("Megapoly - Menu Jugadores");
        setSize(sizes[0], sizes[1]);
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

    private TituloMegapoly crearLabelTitulo() {
        int labelWidth = sizes[0] / 2 + 100;
        int frameWidth = sizes[0];
        labelTitulo = new TituloMegapoly("Megapoly", labelWidth, 200);
        labelTitulo.setBounds((frameWidth - labelWidth) / 2, 100, labelWidth, 200);
        return labelTitulo;
    }


    private PlayerTextField crearNombreJugador1() {
        nombreJugador1 = new PlayerTextField();
        nombreJugador1.setBounds(500, 700, 200, 50);
        return nombreJugador1;
    }

    private PlayerTextField crearNombreJugador2() {
        nombreJugador2 = new PlayerTextField();
        nombreJugador2.setBounds(500, 800, 200, 50);
        return nombreJugador2;
    }

    private PlayerLabel crearLabelNombreJugador1() {
        labelNombreJugador1 = new PlayerLabel("Nombre Jugador 1");
        labelNombreJugador1.setBounds(500, 650, 200, 50);
        return labelNombreJugador1;
    }

    private PlayerLabel crearLabelNombreJugador2() {
        labelNombreJugador2 = new PlayerLabel("Nombre Jugador 2");
        labelNombreJugador2.setBounds(500, 750, 200, 50);
        return labelNombreJugador2;
    }

    private RoundedButton crearBotonJugar() {
        botonJugar = new RoundedButton("Jugar");
        botonJugar.setBounds(500, 900, 200, 50);
        botonJugar.addActionListener(e -> {
            sonidoClick.reproducir();
            if (nombreJugador1.getText().isEmpty() || nombreJugador2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de ambos jugadores");
                return;
            }
            jugador1 = new Jugador(nombreJugador1.getText(), fichaRoja);
            jugador2 = new Jugador(nombreJugador2.getText(), fichaAzul);
            MenuJuego menuJuego = new MenuJuego(jugador1, jugador2, sonidoInicio);
            menuJuego.setVisible(true);
            dispose();
        });
        return botonJugar;
    }

}
