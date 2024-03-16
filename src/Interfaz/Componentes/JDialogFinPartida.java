package Interfaz.Componentes;

import Interfaces.CerrarVentanaCallback;
import Interfaz.MenuInicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JDialogFinPartida extends JDialog {

    private CerrarVentanaCallback callback;

    public JDialogFinPartida(JFrame parent, String message, String title, CerrarVentanaCallback callback) {
        super(parent, true);
        this.callback = callback;
        setTitle(title);
        setSize(400, 200);
        setLocationRelativeTo(parent);
        setResizable(false);

        // Crear panel principal con borde redondeado y fondo degradado
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                int width = getWidth();
                int height = getHeight();
                Color startColor = new Color(220, 220, 220); // Color del fondo
                Color endColor = new Color(180, 180, 180);   // Color del fondo
                GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
                g2d.setColor(Color.GRAY); // Color del borde
                g2d.drawRoundRect(0, 0, width - 1, height - 1, 20, 20); // Bordes redondeados
                g2d.dispose();
            }
        };

        // Crear panel para el mensaje
        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.setOpaque(false); // Hacer el panel transparente
        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        messagePanel.add(label, BorderLayout.CENTER);

        // Añadir panel del mensaje al panel principal
        mainPanel.add(messagePanel, BorderLayout.CENTER);

        // Crear botones de "Sí" y "No"
        RoundedButton yesButton = new RoundedButton("Volver a jugar");
        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                callback.onCargarPartida();
                new MenuInicio();
            }
        });

        RoundedButton noButton = new RoundedButton("Salir");
        noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Crear panel para los botones de "Sí" y "No"
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false); // Hacer el panel transparente
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        // Añadir panel de botones al panel principal
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Añadir panel principal al diálogo
        add(mainPanel);
    }
}