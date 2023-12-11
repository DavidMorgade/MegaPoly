package com.mycompany.megapoly.Casillas;

import com.mycompany.megapoly.Comprables.Comprable;

/*
 * Clase que se encarga de crear las casillas de startUp del tablero
 * @see Casilla
 */
public class CasillaStartUp extends Casilla {

  private Comprable startUp;

  /*
   * Constructor de la clase
   * @param tipo Tipo de casilla
   * @param nombre Nombre de la casilla
   * @param startUp Comprable que se va a crear
   */
  public CasillaStartUp(char tipo, String nombre, Comprable startUp) {
    super(tipo, nombre);
    this.startUp = startUp;
  }

  public Comprable getStartUp() {
    return this.startUp;
  }
}
