package com.mycompany.megapoly.Tablero;

public class Casilla {

  private char tipo;

  public Casilla(char tipo) {
    this.tipo = tipo;
  }

  public char getTipo() {
    return this.tipo;
  }

  public void setTipo(char tipo) {
    this.tipo = tipo;
  }
}
