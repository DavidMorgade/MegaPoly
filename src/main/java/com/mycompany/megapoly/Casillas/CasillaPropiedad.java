package com.mycompany.megapoly.Casillas;

import com.mycompany.megapoly.Comprables.Propiedad;

public class CasillaPropiedad extends Casilla {

  private Propiedad propiedad;

  public CasillaPropiedad(char tipo, String nombre, Propiedad propiedad) {
    super(tipo, nombre);
    this.propiedad = propiedad;
  }

  public Propiedad getPropiedad() {
    return this.propiedad;
  }
}
