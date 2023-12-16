package com.mycompany.megapoly.CartasSuerte;

import com.mycompany.megapoly.Jugadores.Jugador;

public class CartaOponenteCarcel extends CartaSuerte {

  public CartaOponenteCarcel() {
    super(
      "Oponente a la carcel",
      "Si tu oponente no esta en la carcel, lo mandas a la carcel"
    );
  }

  public void efecto(Jugador jugador, Jugador jugadorEnemigo) {
    jugadorEnemigo.setCarcel(true);
    jugadorEnemigo.getFicha().setPosicion(4);
  }
}
