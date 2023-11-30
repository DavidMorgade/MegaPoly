package com.mycompany.megapoly.CartasSuerte;

import com.mycompany.megapoly.Jugadores.Jugador;

public class CartaVolver extends CartaSuerte {

  public CartaVolver() {
    super("Volver", "Vuelve a la casilla de salida");
  }

  public void volver(Jugador jugadorEnPosesion) {
    System.out.println(
      "Vuelve a la casilla de salida y recibes 40 MegaMonedas en vez de 20"
    );
    jugadorEnPosesion.getFicha().setPosicion(0);
  }
}
