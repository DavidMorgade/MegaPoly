package com.mycompany.megapoly.Tablero;

public class Casilla {

  private int posicion;

  private char tipo;

  public Casilla(int posicion, char tipo) {
    this.posicion = posicion;
    this.tipo = tipo;
  }

  public char getTipo() {
    return this.tipo;
  }

  public void setTipo(char tipo) {
    this.tipo = tipo;
  }

  public int getPosicion() {
    return this.posicion;
  }
}
