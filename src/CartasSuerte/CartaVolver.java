package CartasSuerte;


import Jugadores.Jugador;

import javax.swing.*;

/*
 * Clase que se encarga de volver a la casilla de salida y recibir X MegaMonedas
 * @see CartaSuerte
 */
public class CartaVolver extends CartaSuerte {

    private int recompensa;

    /*
     * Constructor de la clase
     * @param nombre Nombre de la carta
     * @param descripcion Descripcion de la carta
     * @param recompensa Cantidad de MegaMonedas que se recibiran
     */
    public CartaVolver() {
        super("Volver", "Vuelve a la casilla de salida y ganas el doble de MM");
        this.recompensa = 40;
    }

    /*
     * Efecto de la carta
     * @param jugadorEnPosesion Jugador que tiene la carta
     * @param jugadorEnemigo Jugador contrario
     * @return void
     * @see Jugador para ver los metodos de sumar y restar MegaMonedas
     * @see ConsoleHelpers para ver el metodo presionaEnterParaContinuar
     */
    public void efecto(Jugador jugadorEnPosesion, Jugador jugadorEnemigo) {
        jugadorEnPosesion.sumarMegaMonedas(this.recompensa);
        jugadorEnPosesion.getFicha().setPosicion(0);
        JOptionPane.showMessageDialog(null, "Vuelves a la casilla de salida y ganas " + this.recompensa + " MegaMonedas");
    }
}
