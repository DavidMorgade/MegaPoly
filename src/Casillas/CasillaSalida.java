package Casillas;

import javax.swing.*;

/*
 * Clase que se encarga de crear la casilla de salida
 * @see Casilla
 */
public class CasillaSalida extends Casilla {

    private int recompensa;

    /*
     * Constructor de la clase
     * @param tipo Tipo de casilla
     * @param nombre Nombre de la casilla
     * @param recompensa Recompensa que se va a dar al jugador
     */
    public CasillaSalida(char tipo, String nombre) {
        super(tipo, nombre);
        this.recompensa = 20;
    }

    public JDialog mensajeCasillaSalida() {
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(null);
        dialog.setResizable(false);
        dialog.setTitle("Casilla de salida");
        JLabel label = new JLabel("Estas en la casilla de salida, no ocurre nada");
        label.setBounds(0, 0, 300, 200);
        dialog.add(label);
        dialog.setVisible(true);
        return dialog;
    }
}
