package com.mycompany.megapoly.Acciones;

import com.mycompany.megapoly.Comprables.Comprable;
import com.mycompany.megapoly.Jugadores.Jugador;

public class Comprar extends CompraVenta {

  public Comprar() {}

  public void comprarPropiedad(Jugador jugador, Comprable propiedad) {
    if (
      jugador.getMegaMonedas() >= propiedad.getPrecioCompra() &&
      propiedad.getPropietario() == null
    ) {
      propiedad.setPropietario(jugador);
      jugador.setMegaMonedas(
        jugador.getMegaMonedas() - propiedad.getPrecioCompra()
      );
      jugador.setPropiedades(propiedad);
      this.compraValida(jugador, propiedad);
    } else {
      this.compraNoValida();
    }
  }

  private void compraNoValida() {
    System.out.println("No se puede comprar la propiedad");
  }

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
