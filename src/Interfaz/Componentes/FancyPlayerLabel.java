package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;

public class FancyPlayerLabel extends JLabel {
    private Color color;

    public FancyPlayerLabel(String text) {
        super(text);
        this.color = Color.BLACK;
        setOpaque(true);
        setForeground(Color.BLACK);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Arial", Font.BOLD, 18));
        setBackground(color);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Añade un poco de espacio alrededor del texto
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Aplicar gradiente de color al fondo
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setPaint(new GradientPaint(0, 0, color.brighter(), 0, getHeight(), color));
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();

        super.paintComponent(g);
    }
}