package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TituloMegapoly extends JLabel {

    private Color startColor;
    private Color endColor;
    private Timer typewriterTimer;
    private int currentIndex;
    private String text;

    public TituloMegapoly(String text, int width, int height) {
        super("");
        this.text = text;
        startTypewriterAnimation();
        setForeground(Color.BLACK);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setFont(new Font("Kristen ITC", Font.BOLD, 124));
        setPreferredSize(new Dimension(width, height));
        startColor = new Color(255, 215, 0); // Color oro
        endColor = new Color(255, 140, 0); // Color naranja oscuro
    }

    private void startTypewriterAnimation() {
        currentIndex = 0;
        typewriterTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex <= text.length()) {
                    setText(text.substring(0, currentIndex));
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }
            }
        });
        typewriterTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Crear gradiente para el fondo
        Paint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);

        // Dibujar el texto con una sombra
        g2d.setColor(new Color(50, 50, 50, 150)); // Color de la sombra
        g2d.setFont(getFont());
        FontMetrics metrics = g2d.getFontMetrics();
        int textWidth = metrics.stringWidth(getText());
        int textHeight = metrics.getHeight();
        int x = (width - textWidth) / 2;
        int y = (height - textHeight) / 2 + metrics.getAscent();
        g2d.drawString(getText(), x + 5, y + 5); // Dibujar sombra
        g2d.setColor(getForeground());
        g2d.drawString(getText(), x, y); // Dibujar texto

        g2d.dispose();
    }
}
