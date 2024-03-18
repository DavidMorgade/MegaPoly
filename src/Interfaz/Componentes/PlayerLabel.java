package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;

public class PlayerLabel extends JLabel {

    private Color startColor; // Color inicial del degradado
    private Color endColor; // Color final del degradado

    public PlayerLabel(String playerName) {
        super(playerName);
        setOpaque(false);
        setForeground(new Color(5, 5, 5)); // Color crema para el texto
        setFont(new Font("Arial", Font.BOLD, 16)); // Fuente y tamaño del texto
        setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto horizontalmente
        setVerticalAlignment(SwingConstants.CENTER); // Centra el texto verticalmente
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Añade un poco de espacio alrededor del texto
        startColor = Color.CYAN; // Color inicial del degradado
        endColor = Color.PINK; // Color final del degradado
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        int w = getWidth();
        int h = getHeight();

        // Crear el gradiente
        GradientPaint gradient = new GradientPaint(0, 0, startColor, w, h, endColor);

        // Dibujar el fondo con el gradiente
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, w, h);

        // Dibujar el texto
        super.paintComponent(g);

        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 40); // Tamaño preferido del JLabel
    }
}