package com.mycompany.megapoly.CartasSuerte;

import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;

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
    super("Volver", "Vuelve a la casilla de salida");
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
    System.out.println(" ");
    ConsoleHelpers.printCentrado(
      "Vuelve a la casilla de salida y recibes 40 MegaMonedas en vez de 20"
    );
    System.out.println(" ");
    ConsoleHelpers.presionaEnterParaContinuar();
    // Se realiza la transferencia de monedas
    jugadorEnPosesion.sumarMegaMonedas(this.recompensa);
    jugadorEnPosesion.getFicha().setPosicion(0);
  }
}
