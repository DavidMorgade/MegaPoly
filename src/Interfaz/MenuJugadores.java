package Interfaz;

import javax.swing.*;
import java.awt.*;

public class MenuJugadores extends JFrame {

    private final int[] sizes = {1600, 1200};
    private JPanel panelFondo;
    private JLabel labelFondo;
    private JLabel labelTitulo;
    private ImageIcon fondoMegaPoly;

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

}
