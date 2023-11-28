package com.mycompany.megapoly.Tablero;

public class StartUp extends Casilla {

  private int precio;

  private String propietario;

  private int rentabilidad;

  public StartUp(int posicion, char tipo, int precio, int rentabilidad) {
    super(posicion, tipo);
    this.precio = precio;
    this.rentabilidad = rentabilidad;
  }
}
