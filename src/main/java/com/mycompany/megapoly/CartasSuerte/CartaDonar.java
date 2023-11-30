package com.mycompany.megapoly.CartasSuerte;

import com.mycompany.megapoly.Jugadores.Jugador;

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
      jugadorEnemigo.getNombre() +
      " Se acuerda de ti y que no te dio un regalo en tu boda y te dona " +
      this.getCantidad() +
      " de MegaMonedas por que se siente culpable"
    );
    jugadorEnemigo.restarMegaMonedas(this.getCantidad());
    jugadorEnPosesion.sumarMegaMonedas(this.getCantidad());
  }
}
