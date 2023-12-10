package com.mycompany.megapoly.CartasSuerte;

import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import org.apache.commons.lang3.StringUtils;

public class CartaVolver extends CartaSuerte {

  private int recompensa;

  public CartaVolver() {
    super("Volver", "Vuelve a la casilla de salida");
    this.recompensa = 40;
  }

  public void efecto(Jugador jugadorEnPosesion, Jugador jugadorEnemigo) {
    int w = 100;
    System.out.println(" ");
    System.out.println(
      StringUtils.center(
        "Vuelve a la casilla de salida y recibes 40 MegaMonedas en vez de 20",
        w
      )
    );
    System.out.println(" ");
    ConsoleHelpers.presionaEnterParaContinuar();
    jugadorEnPosesion.sumarMegaMonedas(this.recompensa);
    jugadorEnPosesion.getFicha().setPosicion(0);
  }
}
