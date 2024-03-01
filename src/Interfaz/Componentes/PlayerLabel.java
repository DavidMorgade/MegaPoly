package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;

public class PlayerLabel extends JLabel {

    public PlayerLabel(String playerName) {
        super(playerName);
        setOpaque(false);
        setForeground(new Color(255, 255, 224)); // Color crema para el texto
        setFont(new Font("Arial", Font.BOLD, 16)); // Fuente y tamaño del texto
        setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto horizontalmente
        setVerticalAlignment(SwingConstants.CENTER); // Centra el texto verticalmente
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Añade un poco de espacio alrededor del texto
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Puedes personalizar el aspecto del JLabel aquí si lo necesitas
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 40); // Tamaño preferido del JLabel
    }
}