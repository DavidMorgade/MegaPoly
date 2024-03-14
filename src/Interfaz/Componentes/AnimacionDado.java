package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimacionDado extends JFrame {

    private JLabel dadoLabel;
    private Timer timer;
    private int contador;
    private JButton okButton;
    private int resultadoReal;

    public AnimacionDado(int resultadoReal) {
        super("El resultado del dado es....");
        this.resultadoReal = resultadoReal;
        contador = 0;
        setSize(400, 200);
        setLocationRelativeTo(null);

        dadoLabel = new JLabel(" ");
        dadoLabel.setFont(new Font("Arial", Font.BOLD, 48));
        dadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(dadoLabel, BorderLayout.CENTER);

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contador++;
                int numeroAleatorio = (int) (Math.random() * 6) + 1;
                dadoLabel.setText(Integer.toString(numeroAleatorio));
                if (contador == 20) { // Cambiar este valor para ajustar la velocidad de la animación
                    dadoLabel.setText(Integer.toString(resultadoReal));
                    timer.stop();
                }


            }
        });

        timer.start();
        setVisible(true);
    }

}