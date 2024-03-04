package Casillas;

import Interfaces.ActualizarPosicionCallBack;
import Jugadores.Jugador;
import Sonido.SonidoCarcel;

public class CasillaPolicia extends Casilla {

    private SonidoCarcel sonidoCarcel;

    public CasillaPolicia(char tipo, String nombre) {
        super(tipo, nombre);
    }

    public void enviarCarcel(Jugador jugador, ActualizarPosicionCallBack callback) {
        jugador.getFicha().setPosicion(10);
        jugador.setCarcel(true);
        callback.onMostrarFinalizado();
    }

    public void sonarSonido() {
        sonidoCarcel = new SonidoCarcel();
        sonidoCarcel.reproducir();
    }

}
