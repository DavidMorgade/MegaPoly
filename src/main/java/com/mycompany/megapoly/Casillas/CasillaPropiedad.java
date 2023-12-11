package com.mycompany.megapoly.Casillas;

import com.mycompany.megapoly.Comprables.Propiedad;

/*
 * Clase que se encarga de crear las casillas de propiedad del tablero
 * @see Casilla
 */
public class CasillaPropiedad extends Casilla {

  private Propiedad propiedad;

  /*
   * Constructor de la clase
   * @param tipo Tipo de casilla
   * @param nombre Nombre de la casilla
   * @param propiedad Propiedad que se va a crear
   */
  public CasillaPropiedad(char tipo, String nombre, Propiedad propiedad) {
    super(tipo, nombre);
    this.propiedad = propiedad;
  }

  public Propiedad getPropiedad() {
    return this.propiedad;
  }
}
