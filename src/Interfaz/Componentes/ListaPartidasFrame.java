package Interfaz.Componentes;

import Interfaces.CerrarVentanaCallback;
import Interfaz.MenuInicio;
import Interfaz.MenuJuego;
import Interfaz.Tablero;
import Jugadores.Jugador;
import Partidas.Partidas;
import Sonido.SonidoInicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaPartidasFrame extends JFrame {
    private JComboBox<String> comboBox;
    private SonidoInicio sonidoInicio;
    private CerrarVentanaCallback callback;

    public ListaPartidasFrame(String[] partidas, CerrarVentanaCallback callback, SonidoInicio sonidoInicio) {
        super("Lista de Partidas");
        this.sonidoInicio = sonidoInicio;
        this.callback = callback;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel);

        // Panel para el combobox
        JPanel comboPanel = new JPanel();
        comboPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        comboBox = new JComboBox<>(partidas);
        comboPanel.add(comboBox);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        JButton cargarButton = new JButton("Cargar");
        JButton salirButton = new JButton("Salir");

        cargarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String partidaSeleccionada = (String) comboBox.getSelectedItem();
                if (partidaSeleccionada != null) {
                    sonidoInicio.parar();
                    cargarPartida(partidaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(ListaPartidasFrame.this, "No se ha seleccionado ninguna partida.");
                }
            }
        });

        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // cerrar esta ventana
                dispose();
            }
        });

        buttonPanel.add(cargarButton);
        buttonPanel.add(salirButton);

        panel.add(comboPanel, BorderLayout.CENTER);
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