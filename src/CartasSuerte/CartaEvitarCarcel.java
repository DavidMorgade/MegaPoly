package CartasSuerte;

import Acciones.EntradaSalidaCarcel;
import Jugadores.Jugador;

/*
 * Clase que se encarga de evitar la carcel al jugador
 * @see CartaSuerte
 */
public class CartaEvitarCarcel extends CartaSuerte {

  /*
   * Constructor de la clase
   * @param nombre Nombre de la carta
   * @param descripcion Descripcion de la carta
   */
  public CartaEvitarCarcel() {
    super("Evitar Carcel", "Si estas en la carcel, sales de ella");
  }

  /*
   * Efecto de la carta
   * @param jugadorEnPosesion Jugador que tiene la carta
   * @param jugadorEnemigo Jugador contrario
   * @return void
   * @see EntradaSalidaCarcel para ver los metodos de entrar y salir de la carcel
   * @see ConsoleHelpers para ver el metodo presionaEnterParaContinuar
   */
  public void efecto(Jugador jugadorEnPosesion, Jugador jugadorEnemigo) {
    EntradaSalidaCarcel.salirCarcel(jugadorEnPosesion);
  }
}
