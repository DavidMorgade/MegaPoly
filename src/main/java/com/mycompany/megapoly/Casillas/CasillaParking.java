package com.mycompany.megapoly.Casillas;

public class CasillaParking extends Casilla {

  private String descripcion;

  public CasillaParking(char tipo, String nombre, String descripcion) {
    super(tipo, nombre);
    this.descripcion = descripcion;
  }
}
