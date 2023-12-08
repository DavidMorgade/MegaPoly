package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Acciones.Alquiler;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Comprables.Propiedad;
import com.mycompany.megapoly.Jugadores.Jugador;

public class MenuJuegoOpcionesAlquiler extends Menu {

  private Jugador jugadorActual;

  private CasillaPropiedad casillaPropiedad;

  public MenuJuegoOpcionesAlquiler(
    Jugador jugadorActual,
    CasillaPropiedad casillaPropiedad
  ) {
    this.jugadorActual = jugadorActual;
    this.casillaPropiedad = casillaPropiedad;
  }

  public void pagasAlquiler() {
    Propiedad propiedad = this.casillaPropiedad.getPropiedad();
    Alquiler alquiler = new Alquiler(this.jugadorActual, propiedad);
    alquiler.alquilerPropiedad();
  }
}
