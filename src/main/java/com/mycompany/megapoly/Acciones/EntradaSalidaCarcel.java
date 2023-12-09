package com.mycompany.megapoly.Acciones;

import com.mycompany.megapoly.Jugadores.Jugador;

public class EntradaSalidaCarcel {

  public static void salirCarcel(Jugador jugador) {
    jugador.setCarcel(false);
  }

  public static void entrarCarcel(Jugador jugador) {
    jugador.setCarcel(true);
  }
}
