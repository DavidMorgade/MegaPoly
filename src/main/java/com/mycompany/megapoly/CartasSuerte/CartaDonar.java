package com.mycompany.megapoly.CartasSuerte;

import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import org.apache.commons.lang3.StringUtils;

public class CartaDonar extends CartaSuerte {

  private int cantidad;

  public CartaDonar() {
    super("Donar", "El enemigo te dona 10 MegaMonedas");
    this.cantidad = 10;
  }

  public int getCantidad() {
    return this.cantidad;
  }

  public void efecto(Jugador jugadorEnPosesion, Jugador jugadorEnemigo) {
    System.out.println(
      StringUtils.center(
        jugadorEnemigo.getNombre() +
        " Se acuerda de ti y que no te dio un regalo en tu boda y te dona " +
        this.getCantidad() +
        " de MegaMonedas por que se siente culpable",
        100
      )
    );
    jugadorEnemigo.restarMegaMonedas(this.getCantidad());
    jugadorEnPosesion.sumarMegaMonedas(this.getCantidad());
    ConsoleHelpers.presionaEnterParaContinuar();
  }
}
