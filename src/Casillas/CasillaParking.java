package Casillas;

import Sonido.SonidoParking;

public class CasillaParking extends Casilla {

    private String descripcion;

    SonidoParking sonidoParking;

    public CasillaParking(char tipo, String nombre, String descripcion) {
        super(tipo, nombre);
        this.descripcion = descripcion;
    }

    public void sonarSonido() {
        sonidoParking = new SonidoParking();
        sonidoParking.reproducir();
    }

}
