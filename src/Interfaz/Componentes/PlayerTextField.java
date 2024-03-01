package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;

public class PlayerTextField extends JTextField {

    public PlayerTextField() {
        setOpaque(true);
        setBackground(new Color(255, 255, 224)); // Color crema para el fondo
        setForeground(Color.BLACK); // Color del texto
        setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y tamaño del texto
        setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto horizontalmente
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde negro
        setPreferredSize(new Dimension(200, 30)); // Tamaño preferido de la caja de texto
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Puedes personalizar el aspecto del JTextField aquí si lo necesitas
        super.paintComponent(g);
    }
}