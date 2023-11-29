package com.mycompany.megapoly.Tablero;

public class Carcel extends Casilla {

  private String nombre;

  private String descripcion;

  public Carcel(char tipo) {
    super(tipo);
    this.nombre = "Carcel";
    this.descripcion = "Estas de visita en la carcel, no te toca pagar nada";
  }
}
