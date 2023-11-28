package com.mycompany.megapoly.Tablero;

public class Propiedad extends Casilla {

  private int precio;

  private String propietario;

  public Propiedad(int posicion, char tipo, int precio) {
    super(posicion, tipo);
    this.precio = precio;
  }
}
