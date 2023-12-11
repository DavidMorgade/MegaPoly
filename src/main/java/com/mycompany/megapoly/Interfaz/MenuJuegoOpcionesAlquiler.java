package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Acciones.Alquiler;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Comprables.Propiedad;
import com.mycompany.megapoly.Jugadores.Jugador;

/*
 * Clase que se encarga de crear el menu de opciones de alquiler
 * @see Menu
 */
public class MenuJuegoOpcionesAlquiler extends Menu {

  private Jugador jugadorActual;

  private CasillaPropiedad casillaPropiedad;

  /*
   * Constructor de la clase
   * @param jugadorActual Jugador actual
   * @param casillaPropiedad Casilla de propiedad
   */
  public MenuJuegoOpcionesAlquiler(
    Jugador jugadorActual,
    CasillaPropiedad casillaPropiedad
  ) {
    this.jugadorActual = jugadorActual;
    this.casillaPropiedad = casillaPropiedad;
  }

  /*
   * Metodo que se encarga de pasar el alquiler al metodo de alquiler
   */
  public void pagasAlquiler() {
    Propiedad propiedad = this.casillaPropiedad.getPropiedad();
    Alquiler alquiler = new Alquiler(this.jugadorActual, propiedad);
    alquiler.alquilerPropiedad();
  }
}
