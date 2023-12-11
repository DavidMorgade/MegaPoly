package com.mycompany.megapoly.Acciones;

import com.mycompany.megapoly.Jugadores.Jugador;

/*
 * Clase que se encarga de realizar la entrada y salida de la carcel
 * @see Jugador
 *
 */
public class EntradaSalidaCarcel {

  /*
   * Metodo que se encarga de sacar al jugador de la carcel
   * @param jugador Jugador que sale de la carcel
   * @return void
   * @see Jugador para ver el metodo setCarcel
   */
  public static void salirCarcel(Jugador jugador) {
    jugador.setCarcel(false);
  }

  /*
   * Metodo que se encarga de meter al jugador en la carcel
   * @param jugador Jugador que entra en la carcel
   * @return void
   * @see Jugador para ver el metodo setCarcel
   */
  public static void entrarCarcel(Jugador jugador) {
    jugador.setCarcel(true);
  }
}
