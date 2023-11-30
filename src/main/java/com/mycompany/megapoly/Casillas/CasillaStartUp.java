package com.mycompany.megapoly.Casillas;

public class CasillaStartUp extends Casilla {

  private int precio;

  private int rentabilidad;

  public CasillaStartUp(
    char tipo,
    String nombre,
    int precio,
    int rentabilidad
  ) {
    super(tipo, nombre);
    this.precio = precio;
    this.rentabilidad = rentabilidad;
  }

  public int getPrecio() {
    return this.precio;
  }

  public int getRentabilidad() {
    return this.rentabilidad;
  }
}
