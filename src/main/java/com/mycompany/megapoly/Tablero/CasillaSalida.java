package com.mycompany.megapoly.Tablero;

public class CasillaSalida extends Casilla {

  private int recompensa;

  public CasillaSalida(char tipo) {
    super(tipo);
    this.recompensa = 1000;
  }
}
