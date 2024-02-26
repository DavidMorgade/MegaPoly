package Casillas;

import Jugadores.Jugador;

public class CasillaImpuesto extends Casilla {
    private int cantidad;

    public CasillaImpuesto(char tipo, String nombre, int cantidad) {
        super(tipo, nombre);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void aplicarImpuesto(Jugador jugador) {
        jugador.restarMegaMonedas(this.cantidad);
    }

    @Override
    public String toString() {
        return "CasillaImpuesto{" +
                "cantidad=" + cantidad +
                '}';
    }
}
