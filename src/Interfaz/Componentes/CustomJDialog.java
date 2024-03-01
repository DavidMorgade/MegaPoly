package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomJDialog extends JDialog {

    public CustomJDialog(JFrame parent, String message) {
        super(parent, true);
        setTitle("Casilla de cárcel");
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setResizable(false);
        setVisible(true);
        // Crear panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Crear panel para el mensaje
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(Color.WHITE);
        JLabel label = new JLabel(message);
        messagePanel.add(label);

        // Añadir panel del mensaje al panel principal
        mainPanel.add(messagePanel, BorderLayout.CENTER);

        // Crear botón de aceptar
        JButton okButton = new JButton("Aceptar");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar el diálogo al hacer clic en Aceptar
            }
        });

        // Crear panel para el botón de aceptar
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(okButton);

        // Añadir panel del botón al panel principal
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Añadir panel principal al diálogo
        add(mainPanel);
    }
}