package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomJDialog extends JDialog {

    public CustomJDialog(JFrame parent, String message, String title) {
        super(parent, true);
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

        // Crear botón de aceptar con estilo
        RoundedButton okButton = new RoundedButton("Aceptar");
        okButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(46, 72, 150), 2), // Borde del botón
                BorderFactory.createEmptyBorder(10, 25, 10, 25))); // Margen interno del botón

        // Agregar acción al botón de aceptar
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar el diálogo al hacer clic en Aceptar
            }
        });

        // Crear panel para el botón de aceptar
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false); // Hacer el panel transparente
        buttonPanel.add(okButton);

        // Añadir panel del botón al panel principal
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Añadir panel principal al diálogo
        add(mainPanel);

        // Crear icono de la ventana
        crearIconoDeVentana();

        // Hacer visible el diálogo después de agregar todos los componentes
        setVisible(true);
    }

    private void crearIconoDeVentana() {
        ImageIcon icono = new ImageIcon(this.getClass().getResource("/Imagenes/Megapoly-icon.png"));
        setIconImage(icono.getImage());
    }
}