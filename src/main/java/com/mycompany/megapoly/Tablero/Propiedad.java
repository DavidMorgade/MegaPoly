package com.mycompany.megapoly.Tablero;

public class Propiedad extends Casilla {

  private int precio;

  private String propietario;

  Empresa empresa;

  public Propiedad(char tipo, int precio) {
    super(tipo);
    this.precio = precio;
  }
}
