package com.mycompany.megapoly.Casillas;

public class CasillaPropiedad extends Casilla {

  private int precio;

  private int alquiler;

  public CasillaPropiedad(char tipo, String nombre, int precio, int alquiler) {
    super(tipo, nombre);
    this.precio = precio;
    this.alquiler = alquiler;
  }

  public int getPrecio() {
    return this.precio;
  }

  public int getAlquiler() {
    return this.alquiler;
  }

  public void alquilerConTresPropiedades() {
    this.alquiler = this.alquiler * 3;
  }
}
