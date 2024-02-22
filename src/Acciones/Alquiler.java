package Acciones;

import Comprables.Propiedad;
import Jugadores.Jugador;

/*
 * Clase que se encarga de realizar el alquiler de una propiedad
 * @see CompraVenta
 *
 */
public class Alquiler extends CompraVenta {

  /*
   * Constructor de la clase Alquiler
   * @param jugador Jugador que cae en la propiedad
   * @param propiedad Propiedad en la que cae el jugador
   * @return void
   */
  public Alquiler(Jugador jugador, Propiedad propiedad) {
    this.jugador = jugador;
    this.propiedad = propiedad;
  }

  /*
   * Metodo que se encarga de realizar el alquiler de la propiedad
   * @return void
   * @see Jugador para ver el metodo getNombre
   * @see Propiedad para ver el metodo getPropietario
   * @see StringUtils para ver el metodo center
   */
  public void alquilerPropiedad() {
    Jugador propietario = this.propiedad.getPropietario();
    String nombreJugadorActual = this.jugador.getNombre();
    String nombrePropietario = propietario.getNombre();
    // Si el jugador actual es el propietario de la propiedad
    if (nombreJugadorActual.equals(nombrePropietario)) {

      // Si el jugador actual no es el propietario de la propiedad
    } else {
      int precioAlquiler = this.propiedad.getAlquiler();
      // Se realiza la transferencia de monedas
      this.transferenciaAlPropietario(
          this.jugador,
          propietario,
          precioAlquiler
        );
    }
  }

  /*
   * Metodo que se encarga de realizar la transferencia de monedas
   * @param jugadorActual Jugador que cae en la propiedad
   * @param propietario Propietario de la propiedad
   * @param precioAlquiler Precio del alquiler de la propiedad
   * @return void
   * @see Jugador para ver los metodos getMegaMonedas y setMegaMonedas
   */
  private void transferenciaAlPropietario(
    Jugador jugadorActual,
    Jugador propietario,
    int precioAlquiler
  ) {
    int monedasJugadorActual = jugadorActual.getMegaMonedas();
    int monedasPropietario = propietario.getMegaMonedas();
    jugadorActual.setMegaMonedas(monedasJugadorActual - precioAlquiler);
    propietario.setMegaMonedas(monedasPropietario + precioAlquiler);
  }
}
