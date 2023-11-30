package com.mycompany.megapoly.CartasSuerte;

import com.mycompany.megapoly.Jugadores.Jugador;

public class CartaSuerte {

  private String nombre;

  private String descripcion;

  public CartaSuerte(String nombre, String descripcion) {
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void efecto(Jugador jugador) {}
}
