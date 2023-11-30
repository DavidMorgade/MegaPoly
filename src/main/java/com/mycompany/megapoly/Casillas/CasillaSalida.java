package com.mycompany.megapoly.Casillas;

public class CasillaSalida extends Casilla {

  private int recompensa;

  public CasillaSalida(char tipo, String nombre) {
    super(tipo, nombre);
    this.recompensa = 20;
  }

  public int getRecompensa() {
    return this.recompensa;
  }
}
