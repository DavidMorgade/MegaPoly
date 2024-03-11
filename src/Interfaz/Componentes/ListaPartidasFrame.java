package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaPartidasFrame extends JFrame {
    private JComboBox<String> comboBox;

    public ListaPartidasFrame(String[] partidas) {
        super("Lista de Partidas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);

        panel.setLayout(new BorderLayout());

        comboBox = new JComboBox<>(partidas);
        panel.add(comboBox, BorderLayout.CENTER);

        JButton cargarButton = new JButton("Cargar");
        cargarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String partidaSeleccionada = (String) comboBox.getSelectedItem();
                if (partidaSeleccionada != null) {
                    cargarPartida(partidaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(ListaPartidasFrame.this, "No se ha seleccionado ninguna partida.");
                }
            }
        });

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // cerrar esta ventana
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cargarButton);
        buttonPanel.add(salirButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void cargarPartida(String nombrePartida) {
        // Aquí puedes agregar la lógica para cargar la partida seleccionada
        System.out.println("Cargando partida: " + nombrePartida);
    }

    public static void main(String[] args) {
        String[] partidas = {"Partida1", "Partida2", "Partida3"}; // Reemplaza con el resultado de listarPartidas()
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListaPartidasFrame(partidas);
            }
        });
    }
}