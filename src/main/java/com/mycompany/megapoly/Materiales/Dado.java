package com.mycompany.megapoly.Materiales;

public class Dado {

  private int numero;

  public Dado() {
    this.numero = 0;
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumeroAleatorio() {
    this.numero = this.generarNumero();
  }

  private int generarNumero() {
    return (int) (Math.random() * 6 + 1);
  }
}
