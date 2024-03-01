package Casillas;

import Interfaz.Componentes.CustomJDialog;
import Sonido.SonidoParking;

import javax.swing.*;

public class CasillaParking extends Casilla {

    private String descripcion;

    SonidoParking sonidoParking;

    public CasillaParking(char tipo, String nombre, String descripcion) {
        super(tipo, nombre);
        this.descripcion = descripcion;
    }

    public CustomJDialog mensajeCasillaParking(JFrame parent) {
        return new CustomJDialog(parent, "Casilla de parking, no hay multa por aparcar", "Parking");
    }

    public void sonarSonido() {
        sonidoParking = new SonidoParking();
        sonidoParking.reproducir();
    }

}
