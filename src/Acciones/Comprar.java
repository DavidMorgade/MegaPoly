package Acciones;

import Comprables.Comprable;
import Jugadores.Jugador;

/*
 * Clase que se encarga de realizar la compra de una propiedad
 * @see CompraVenta
 *
 */
public class Comprar extends CompraVenta {

  public Comprar() {}

  /*
   * Metodo que se encarga de realizar la compra de la propiedad
   * @param jugador Jugador que compra la propiedad
   * @param propiedad Propiedad que se va a comprar
   * @return void
   * @see Jugador para ver los metodos getMegaMonedas y setMegaMonedas
   * @see Comprable para ver los metodos getPrecioCompra y getPropietario
   */
  public void comprarPropiedad(Jugador jugador, Comprable propiedad) {
    // Si el jugador tiene suficientes monedas y la propiedad no tiene propietario
    if (
      jugador.getMegaMonedas() >= propiedad.getPrecioCompra() &&
      propiedad.getPropietario().getNombre().equals("Banco")
    ) {
      // Completa la compra de la propiedad
      propiedad.setPropietario(jugador);
      jugador.setMegaMonedas(
        jugador.getMegaMonedas() - propiedad.getPrecioCompra()
      );
      jugador.setPropiedades(propiedad);
      this.compraValida(jugador, propiedad);
      // Si el jugador no tiene suficientes monedas o la propiedad tiene propietario
    } else {
      // No se puede comprar la propiedad
      this.compraNoValida();
    }
  }

  /*
   * Metodo que se encarga de mostrar un mensaje de que no se puede comprar la propiedad
   * @return void
   */
  private void compraNoValida() {
    System.out.println("No se puede comprar la propiedad");
  }

  /*
   * Metodo que se encarga de mostrar un mensaje de que se ha comprado la propiedad
   * @param jugador Jugador que compra la propiedad
   * @param propiedad Propiedad que se va a comprar
   * @return void
   * @see Jugador para ver el metodo getNombre
   * @see Comprable para ver los metodos getNombreComprable y getPrecioCompra
   */
  private void compraValida(Jugador jugador, Comprable propiedad) {
    System.out.println(
      "El jugador " +
      jugador.getNombre() +
      " ha comprado la propiedad " +
      propiedad.getNombreComprable() +
      " por " +
      propiedad.getPrecioCompra() +
      " monedas"
    );
  }
}
