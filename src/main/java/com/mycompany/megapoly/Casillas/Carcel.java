package com.mycompany.megapoly.Casillas;

public class Carcel extends Casilla {

  private String nombre;

  private String descripcion;

  public Carcel(char tipo) {
    super(tipo);
    this.nombre = "Carcel";
    this.descripcion = "Estas de visita en la carcel, no te toca pagar nada";
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getDescripcion() {
    return this.descripcion;
  }
}
