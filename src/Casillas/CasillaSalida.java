package Casillas;

import Sonido.SonidoParking;
import Sonido.Sonidos;

import javax.swing.*;

/*
 * Clase que se encarga de crear la casilla de salida
 * @see Casilla
 */
public class CasillaSalida extends Casilla {

    private int recompensa;
    private transient SonidoParking sonido;

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

    public void sonarSonido() {
        sonido = new SonidoParking();
        sonido.reproducir();
    }

}
