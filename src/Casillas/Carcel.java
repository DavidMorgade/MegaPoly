package Casillas;

import Interfaz.Componentes.CustomJDialog;
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

    public CustomJDialog mensajeCasillaCarcel() {
        CustomJDialog dialog = new CustomJDialog(null, "Casilla de carcel, vas de visita y saludas al personal");
        return dialog;
    }


    public String getDescripcion() {
        return this.descripcion;
    }
}
