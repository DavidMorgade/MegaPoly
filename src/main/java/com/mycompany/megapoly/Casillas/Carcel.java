package com.mycompany.megapoly.Casillas;

public class Carcel extends Casilla {

  private String nombre;

  private String descripcion;

  public Carcel(char tipo, String nombre) {
    super(tipo, nombre);
    this.nombre = "Carcel";
    this.descripcion = "Necesitas sacar un 5 para salir de la carcel.";
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getDescripcion() {
    return this.descripcion;
  }
}
