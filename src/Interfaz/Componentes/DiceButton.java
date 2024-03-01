package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;

public class DiceButton extends JButton {

    public DiceButton(String text) {
        super(text);
        setOpaque(true);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Borde delgado negro
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(new Font("Arial", Font.BOLD, 24)); // Texto grande
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
        g.fillRect(0, 0, getWidth(), getHeight()); // Dibuja el fondo cuadrado

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Dibujar un borde delgado negro
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(80, 80); // Tamaño preferido del botón
    }
}