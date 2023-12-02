package com.mycompany.megapoly.Comprables;

import com.mycompany.megapoly.Jugadores.Jugador;

public class Comprable {

  private Jugador propietario;
  private String nombreComprable;
  private String descripcion;

  private int precioCompra;

  private int precioVenta;

  protected int alquiler;

  public Comprable(
    int precioCompra,
    int alquiler,
    String nombreComprable,
    String descripcion
  ) {
    this.precioCompra = precioCompra;
    this.precioVenta = precioCompra / 2;
    this.alquiler = alquiler;
    this.nombreComprable = nombreComprable;
    this.descripcion = descripcion;
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

  public Jugador getPropietario() {
    return this.propietario;
  }

  public String getNombreComprable() {
    return this.nombreComprable;
  }

  public void setPropietario(Jugador propietario) {
    this.propietario = propietario;
  }
}
