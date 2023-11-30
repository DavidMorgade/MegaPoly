package com.mycompany.megapoly.Casillas;

public class CasillaSalida extends Casilla {

  private int recompensa;

  public CasillaSalida(char tipo) {
    super(tipo);
    this.recompensa = 20;
  }

  public int getRecompensa() {
    return this.recompensa;
  }
}
