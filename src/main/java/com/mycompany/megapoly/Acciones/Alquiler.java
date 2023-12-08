package com.mycompany.megapoly.Acciones;

import com.mycompany.megapoly.Comprables.Propiedad;
import com.mycompany.megapoly.Jugadores.Jugador;
import org.apache.commons.lang3.StringUtils;

public class Alquiler extends CompraVenta {

  private int w = 100;

  public Alquiler(Jugador jugador, Propiedad propiedad) {
    this.jugador = jugador;
    this.propiedad = propiedad;
  }

  public void alquilerPropiedad() {
    Jugador propietario = this.propiedad.getPropietario();
    String nombreJugadorActual = this.jugador.getNombre();
    String nombrePropietario = propietario.getNombre();
    if (nombreJugadorActual.equals(nombrePropietario)) {
      System.out.println(
        StringUtils.center(
          "Estas en tu empresa, la gente te vitorea, Bienvenido!",
          w
        )
      );
      System.out.println(" ");
    } else {
      int precioAlquiler = this.propiedad.getAlquiler();
      this.transferenciaAlPropietario(
          this.jugador,
          propietario,
          precioAlquiler
        );
      System.out.println(" ");
      System.out.println(
        StringUtils.center("Has caido en la empresa de" + nombrePropietario, w)
      );
      System.out.println(
        StringUtils.center(
          nombreJugadorActual +
          "paga la cantidad de " +
          precioAlquiler +
          " al jugador " +
          nombrePropietario +
          " en concepto de alquiler",
          w
        )
      );
      System.out.println(" ");
    }
  }

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
