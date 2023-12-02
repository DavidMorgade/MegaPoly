package com.mycompany.megapoly.Casillas;

import com.mycompany.megapoly.Comprables.Comprable;

public class CasillaStartUp extends Casilla {

  private Comprable startUp;

  public CasillaStartUp(char tipo, String nombre, Comprable startUp) {
    super(tipo, nombre);
    this.startUp = startUp;
  }

  public Comprable getStartUp() {
    return this.startUp;
  }
}
