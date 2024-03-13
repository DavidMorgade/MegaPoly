package Interfaz.Componentes;

import Interfaces.CerrarVentanaCallback;
import Interfaz.MenuInicio;
import Interfaz.MenuJuego;
import Interfaz.Tablero;
import Jugadores.Jugador;
import Partidas.Partidas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaPartidasFrame extends JFrame {
    private JComboBox<String> comboBox;
    private CerrarVentanaCallback callback;

    public ListaPartidasFrame(String[] partidas, CerrarVentanaCallback callback) {
        super("Lista de Partidas");
        this.callback = callback;
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
        System.out.println("Cargando partida: " + nombrePartida);
        Object[] datosPartida = Partidas.cargarPartida(nombrePartida);
        if (datosPartida != null) {
            Jugador jugador1 = (Jugador) datosPartida[0];
            Jugador jugador2 = (Jugador) datosPartida[1];
            Tablero tablero = (Tablero) datosPartida[2];
            MenuJuego menuJuego = new MenuJuego(jugador1, jugador2, tablero);
            menuJuego.setVisible(true);
            callback.onCargarPartida();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar la partida.");
        }
    }

}