package com.mycompany.megapoly.Comprables;

import com.mycompany.megapoly.Jugadores.Jugador;

/*
 * Clase que se encarga de crear los comprables del tablero, sirve de modelo para el resto de comprables
 * @see Jugador
 */
public class Comprable {

  // El propietario por defecto es el banco
  private Jugador propietario = new Jugador("Banco", false, null);
  private String nombreComprable;
  private String descripcion;

  private int precioCompra;

  private int precioVenta;

  protected int alquiler;

  /*
   * Constructor de la clase
   * @param precioCompra Precio de compra del comprable
   * @param alquiler Precio de alquiler del comprable
   * @param nombreComprable Nombre del comprable
   * @param descripcion Descripcion del comprable
   */
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

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setPropietario(Jugador propietario) {
    this.propietario = propietario;
  }
}
