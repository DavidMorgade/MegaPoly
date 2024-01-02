package com.mycompany.megapoly.Partidas;

import com.mycompany.megapoly.Jugadores.Jugador;

public class GuardarPartida implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  public Jugador jugador1;

  public Jugador jugador2;

  public GuardarPartida(Jugador jugador1, Jugador jugador2) {
    this.jugador1 = jugador1;
    this.jugador2 = jugador2;
  }
}
