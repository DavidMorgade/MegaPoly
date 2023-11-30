package com.mycompany.megapoly.Casillas;

import com.mycompany.megapoly.CartasSuerte.CartaSuerte;
import com.mycompany.megapoly.Jugadores.Jugador;

public class CasillaSuerte extends Casilla {

  private String nombre;

  private CartaSuerte carta;

  private String descripcion;

  public CasillaSuerte(char tipo) {
    super(tipo);
    this.carta = new CartaSuerte();
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public CartaSuerte getCarta() {
    return this.carta;
  }

  public void donarDinero(Jugador jugador, Jugador enemigo, int cantidad) {
    this.nombre = "Donar Dinero";
    this.descripcion =
      "Donas " +
      cantidad +
      " MegaMonedas a " +
      enemigo.getNombre() +
      " por que te sientes bien";
    jugador.restarMegaMonedas(cantidad);
    enemigo.sumarMegaMonedas(cantidad);
  }
}
