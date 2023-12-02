package com.mycompany.megapoly.Comprables;

public class Comprable {

  private String propietario;

  private int precioCompra;

  private int precioVenta;

  private String nombreComprable;

  protected int alquiler;

  public Comprable(int precioCompra, int alquiler, String nombreComprable) {
    this.precioCompra = precioCompra;
    this.precioVenta = precioCompra / 2;
    this.alquiler = alquiler;
    this.nombreComprable = nombreComprable;
  }

  public int getPrecioCompra() {
    return this.precioCompra;
  }

  public int getPrecioVenta() {
    return this.precioVenta;
  }

  public int getAlquiler() {
    return this.alquiler;
  }

  public String getPropietario() {
    return this.propietario;
  }

  public String getNombreComprable() {
    return this.nombreComprable;
  }

  public void setPropietario(String propietario) {
    this.propietario = propietario;
  }
}
