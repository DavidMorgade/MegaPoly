package com.mycompany.megapoly.Partidas;

import com.mycompany.megapoly.Comprables.Comprable;
import com.mycompany.megapoly.Jugadores.Jugador;
import java.util.List;

public class GuardarPartida implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  public Jugador jugador1;

  public Jugador jugador2;

  public List<Comprable> comprablesJugador1;

  public List<Comprable> comprablesJugador2;

  public GuardarPartida(
    Jugador jugador1,
    Jugador jugador2,
    List<Comprable> comprablesJugador1,
    List<Comprable> comprablesJugador2
  ) {
    this.jugador1 = jugador1;
    this.jugador2 = jugador2;
    this.comprablesJugador1 = comprablesJugador1;
    this.comprablesJugador2 = comprablesJugador2;
  }
}
