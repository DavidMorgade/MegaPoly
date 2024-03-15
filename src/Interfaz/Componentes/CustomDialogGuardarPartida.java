package Interfaz.Componentes;

import Interfaz.Tablero;
import Jugadores.Jugador;
import Partidas.Partidas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDialogGuardarPartida extends JDialog {

    private JTextField nombrePartidaTextField;
    private Jugador jugadorActual;
    private Jugador jugadorNoTurno;
    private Tablero tablero;
    private JButton guardarButton;
    private JButton cancelarButton;

    public CustomDialogGuardarPartida(JFrame parent, String title, Jugador jugadorActual, Jugador jugadorNoTurno, Tablero tablero) {
        super(parent, title, true);
        this.jugadorActual = jugadorActual;
        this.jugadorNoTurno = jugadorNoTurno;
        this.tablero = tablero;
        setSize(400, 200);
        setLocationRelativeTo(parent);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel para el mensaje y el campo de texto
        JPanel messagePanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Nombre de la partida:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        messagePanel.add(label, BorderLayout.NORTH);

        nombrePartidaTextField = new JTextField(5);
        messagePanel.add(nombrePartidaTextField, BorderLayout.CENTER);

        mainPanel.add(messagePanel, BorderLayout.CENTER);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        guardarButton = new RoundedButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes manejar la lógica para guardar la partida con el nombre ingresado
                String nombrePartida = nombrePartidaTextField.getText();
                LocalDateTime fechaHoraActual = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
                String fechaHoraFormateada = fechaHoraActual.format(formatter);
                Partidas.guardarPartida(jugadorActual, jugadorNoTurno, tablero, nombrePartida + "-" + fechaHoraFormateada);
                dispose(); // Cerrar el diálogo después de guardar
            }
        });
        buttonPanel.add(guardarButton);

        cancelarButton = new RoundedButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(cancelarButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }
}