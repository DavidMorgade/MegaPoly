package Interfaz;

import Sonido.SonidoInicio;

import javax.swing.*;

public class MenuInicio extends JFrame {

    private SonidoInicio sonidoInicio = new SonidoInicio();
    private ImageIcon fondoMegaPoly;
    private JLabel labelFondo;
    private int[] sizes = {800, 600};

    public static void main(String[] args) {
        MenuInicio menu = new MenuInicio();
        menu.setVisible(true);
    }

    public MenuInicio() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Megapoly - Menu Inicio");
        add(crearLabelFondo());
        setSize(sizes[0], sizes[1]);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        sonidoInicio.reproducir();
    }
    private JLabel crearLabelFondo() {
        fondoMegaPoly = new ImageIcon(this.getClass().getResource("/Imagenes/ImagenMenuInicio.jpg"));
        labelFondo = new JLabel(fondoMegaPoly);
        labelFondo.setSize(sizes[0], sizes[1]);
        return labelFondo;
    }
}
