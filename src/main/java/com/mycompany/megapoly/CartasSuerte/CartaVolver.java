package com.mycompany.megapoly.CartasSuerte;

import com.mycompany.megapoly.Jugadores.Jugador;

public class CartaVolver extends CartaSuerte {

  private int recompensa;

  public CartaVolver() {
    super("Volver", "Vuelve a la casilla de salida");
    this.recompensa = 40;
  }

  public void volver(Jugador jugadorEnPosesion) {
    System.out.println(
      "Vuelve a la casilla de salida y recibes 40 MegaMonedas en vez de 20"
    );
    jugadorEnPosesion.sumarMegaMonedas(this.recompensa);
    jugadorEnPosesion.getFicha().setPosicion(0);
  }
}
