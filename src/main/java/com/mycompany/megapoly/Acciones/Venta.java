package com.mycompany.megapoly.Acciones;

import com.mycompany.megapoly.Comprables.Comprable;
import com.mycompany.megapoly.Jugadores.Jugador;

/*
 * Clase que se encarga de realizar la venta de una propiedad
 * @see CompraVenta
 *
 */
public class Venta extends CompraVenta {

  public Venta() {}

  /*
   * Metodo que se encarga de realizar la venta de la propiedad
   * @param jugador Jugador que vende la propiedad
   * @param propiedad Propiedad que se va a vender
   * @return void
   * @see Jugador para ver los metodos getMegaMonedas y setMegaMonedas
   * @see Comprable para ver los metodos getPrecioVenta y getPropietario
   */
  public void venderPropiedad(Jugador jugador, Comprable propiedad) {
    if (jugador.getPropiedades().contains(propiedad)) {
      jugador.setMegaMonedas(
        jugador.getMegaMonedas() + propiedad.getPrecioVenta()
      );
      jugador.getPropiedades().remove(propiedad);
      propiedad.setPropietario(null);
      this.ventaValida(propiedad);
    } else {
      this.ventaNoValida();
    }
  }

  /*
   * Metodo que se encarga de mostrar un mensaje de que no se puede vender la propiedad
   * @return void
   */
  private void ventaNoValida() {
    System.out.println("No se puede vender la propiedad");
  }

  /*
   * Metodo que se encarga de mostrar un mensaje de que se ha vendido la propiedad
   * @param propiedad Propiedad Comprable que se va a vender
   * @return void
   * @see Comprable para ver los metodos getNombreComprable y getPrecioVenta
   */
  private void ventaValida(Comprable propiedad) {
    System.out.println(
      "Se ha vendido la propiedad " +
      propiedad.getNombreComprable() +
      " a la banca por " +
      propiedad.getPrecioVenta() +
      " monedas"
    );
  }
}
