package com.mycompany.megapoly.Casillas;

public class CasillaPropiedad extends Casilla {

  private int precio;

  private int alquiler;

  private String propietario;

  public CasillaPropiedad(char tipo, int precio, int alquiler) {
    super(tipo);
    this.precio = precio;
    this.alquiler = alquiler;
  }

  public int getPrecio() {
    return this.precio;
  }

  public int getAlquiler() {
    return this.alquiler;
  }

  public String getPropietario() {
    return this.propietario;
  }

  public void setPropietario(String propietario) {
    this.propietario = propietario;
  }

  public void alquilerConTresPropiedades() {
    this.alquiler = this.alquiler * 3;
  }
}
