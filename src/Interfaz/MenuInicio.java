package Interfaz;

import Interfaces.CerrarVentanaCallback;
import Interfaz.Componentes.*;
import Partidas.Partidas;
import Sonido.SonidoClick;
import Sonido.SonidoInicio;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MenuInicio extends JFrame {

    private final SonidoInicio sonidoInicio = new SonidoInicio();

    private SonidoClick sonidoClick = new SonidoClick();
    private ImageIcon fondoMegaPoly;
    private RoundedButton botonNuevaPartida;
    private RoundedButton botonCargarPartida;
    private RoundedButton botonSalir;
    private JPanel panelFondo;
    private JLabel labelFondo;
    private TituloMegapoly labelTitulo;
    private final int[] sizes = {1200, 1080};


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
        crearIconoDeVentana();
        sonidoInicio.reproducir();
        this.createUIComponents();
        crearCarpetaPartidas();
    }

    private void crearIconoDeVentana() {
        ImageIcon icono = new ImageIcon(this.getClass().getResource("/Imagenes/Megapoly-icon.png"));
        setIconImage(icono.getImage());
    }

    private void createUIComponents() {
        add(crearPanelFondo());
    }

    private void crearCarpetaPartidas() {
        // Crear la carpeta 'partidas' si no existe
        File partidasFolder = new File("partidas");
        if (!partidasFolder.exists()) {
            boolean created = partidasFolder.mkdirs();
            if (created) {
                System.out.println("Carpeta 'partidas' creada con éxito.");
            } else {
                System.err.println("Error al crear la carpeta 'partidas'.");
            }
        }
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
        labelFondo.add(nombreCreador());
        labelFondo.add(versionEnlace());
        return labelFondo;
    }

    private TituloMegapoly crearLabelTitulo() {
        int labelWidth = sizes[0] / 2 + 100;
        int frameWidth = sizes[0];
        labelTitulo = new TituloMegapoly("Megapoly", labelWidth, 200);
        labelTitulo.setBounds((frameWidth - labelWidth) / 2, 100, labelWidth, 200);
        return labelTitulo;
    }

    private PlayerLabel nombreCreador() {
        PlayerLabel nombreCreado = new PlayerLabel("Desarrolado por: David Morgade - Programación MEDAC");
        nombreCreado.setBounds(10, 50, 500, 50);
        return nombreCreado;
    }

    private PlayerLabel versionEnlace() {
        PlayerLabel versionEnlace = new PlayerLabel("Versión 0.1 - MegaPoly");
        versionEnlace.setBounds(10, 10, 500, 50);
        return versionEnlace;
    }

    private JPanel crearPanelFondo() {
        panelFondo = new JPanel();
        panelFondo.setSize(sizes[0], sizes[1]);
        panelFondo.setLayout(null);
        panelFondo.add(crearLabelFondo());
        return panelFondo;
    }

    private RoundedButton crearBotonNuevaPartida() {
        botonNuevaPartida = new RoundedButton("Nueva Partida");
        botonNuevaPartida.setBounds(500, 700, 200, 50);
        botonNuevaPartida.addActionListener(e -> {
            sonidoClick.reproducir();
            MenuJugadores menuJugadores = new MenuJugadores(sonidoInicio);
            menuJugadores.setVisible(true);
            dispose();
        });
        return botonNuevaPartida;
    }

    private RoundedButton crearBotonCargarPartida() {
        botonCargarPartida = new RoundedButton("Cargar Partida");
        botonCargarPartida.setBounds(500, 800, 200, 50);
        botonCargarPartida.addActionListener(e -> {
            sonidoClick.reproducir();
            String partidas[] = Partidas.listarPartidas(); // Reemplaza con el resultado de listarPartidas()
            new ListaPartidasFrame(partidas, this.cerrarVentana(), sonidoInicio);
        });
        return botonCargarPartida;
    }

    private RoundedButton crearBotonSalir() {
        botonSalir = new RoundedButton("Salir");
        botonSalir.setBounds(500, 900, 200, 50);
        botonSalir.addActionListener(e -> {
            sonidoClick.reproducir();
            System.exit(0);
        });
        return botonSalir;
    }

    private CerrarVentanaCallback cerrarVentana() {
        return this::dispose;
    }

}
