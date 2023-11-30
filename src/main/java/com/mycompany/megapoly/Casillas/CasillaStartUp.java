package com.mycompany.megapoly.Casillas;

public class CasillaStartUp extends Casilla {

  private int precio;

  private String propietario;

  private int rentabilidad;

  public CasillaStartUp(char tipo, int precio, int rentabilidad) {
    super(tipo);
    this.precio = precio;
    this.rentabilidad = rentabilidad;
  }

  public int getPrecio() {
    return this.precio;
  }

  public String getPropietario() {
    return this.propietario;
  }

  public int getRentabilidad() {
    return this.rentabilidad;
  }

  public void setPropietario(String propietario) {
    this.propietario = propietario;
  }
}
