package Casillas;

import Sonido.SonidoCarcel;

import javax.swing.*;

/*
 * Clase que se encarga de crear la casilla de la carcel
 * @see Casilla
 */
public class Carcel extends Casilla {

    private SonidoCarcel sonidoCarcel;
    private String nombre;

    private String descripcion;

    /*
     * Constructor de la clase
     * @param tipo Tipo de casilla
     * @param nombre Nombre de la casilla
     * @param descripcion Descripcion de la casilla
     */
    public Carcel(char tipo, String nombre) {
        super(tipo, nombre);
        this.nombre = "Carcel";
        this.descripcion = "Necesitas sacar un 5 para salir de la carcel.";
    }

    public String getNombre() {
        return this.nombre;
    }

    public void sonarSonido() {
        sonidoCarcel = new SonidoCarcel();
        sonidoCarcel.reproducir();
    }

    public JDialog mensajeCasillaCarcel() {
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(null);
        dialog.setResizable(false);
        dialog.setTitle("Casilla de carcel");
        JLabel label = new JLabel("Estas en la casilla de carcel, vas de visita y saludas al personal.");
        label.setBounds(0, 0, 300, 200);
        dialog.add(label);
        dialog.setVisible(true);
        return dialog;
    }


    public String getDescripcion() {
        return this.descripcion;
    }
}
