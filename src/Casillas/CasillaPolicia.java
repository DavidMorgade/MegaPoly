package Casillas;

import Jugadores.Jugador;
import Sonido.SonidoCarcel;

public class CasillaPolicia extends Casilla {

    private SonidoCarcel sonidoCarcel;

    public CasillaPolicia(char tipo, String nombre) {
        super(tipo, nombre);
    }

    public void enviarCarcel(Jugador jugador) {
        jugador.getFicha().setPosicion(10);
    }

    public void sonarSonido() {
        sonidoCarcel = new SonidoCarcel();
        sonidoCarcel.reproducir();
    }

}
