package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;


public class RoundedButton extends JButton {

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setFont(new Font("Arial", Font.BOLD, 14));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(new Color(200, 200, 200)); // Cambia el color al ser presionado
        } else if (getModel().isRollover()) {
            g.setColor(new Color(220, 220, 220)); // Cambia el color al pasar el ratón
        } else {
            g.setColor(Color.WHITE); // Fondo blanco por defecto
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Dibuja el fondo redondeado

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No pintar el borde
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 40); // Tamaño preferido del botón
    }
}