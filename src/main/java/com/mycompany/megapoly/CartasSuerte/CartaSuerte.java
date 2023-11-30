package com.mycompany.megapoly.CartasSuerte;

public class CartaSuerte {

  private String nombre;

  private String descripcion;


  public String getNombre() {
    return this.nombre;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public CartaSuerte(String nombre, String descripcion) {
    this.nombre = nombre;
    this.descripcion = descripcion;
  }
}
