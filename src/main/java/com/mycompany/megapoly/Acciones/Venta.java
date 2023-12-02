package com.mycompany.megapoly.Acciones;

import com.mycompany.megapoly.Comprables.Comprable;
import com.mycompany.megapoly.Jugadores.Jugador;

public class Venta extends CompraVenta {

  public Venta() {}

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

  private void ventaNoValida() {
    System.out.println("No se puede vender la propiedad");
  }

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
