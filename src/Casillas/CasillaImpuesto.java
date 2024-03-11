package Casillas;

import Interfaces.ActualizarPosicionCallBack;
import Interfaz.Componentes.CustomJDialog;
import Jugadores.Jugador;
import Sonido.SonidoPagar;

public class CasillaImpuesto extends Casilla {
    private int cantidad;

    private transient SonidoPagar sonidoPagar;

    public CasillaImpuesto(char tipo, String nombre, int cantidad) {
        super(tipo, nombre);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void aplicarImpuesto(Jugador jugador, ActualizarPosicionCallBack callback) {
        jugador.restarMegaMonedas(this.cantidad);
        new CustomJDialog(null, "Casilla de impuesto, pagas el impuesto de " + this.cantidad + "MM", "Impuesto");
        callback.onMostrarFinalizado();

    }

    public void sonarSonido() {
        sonidoPagar = new SonidoPagar();
        sonidoPagar.reproducir();
    }

    @Override
    public String toString() {
        return "CasillaImpuesto{" +
                "cantidad=" + cantidad +
                '}';
    }
}
