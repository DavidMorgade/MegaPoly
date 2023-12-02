package com.mycompany.megapoly.Casillas;

import com.mycompany.megapoly.Jugadores.Jugador;

public class Casilla {

  private char tipo;

  private String nombre;

  private Jugador propietario = new Jugador("Banco", false, null);

  public Casilla(char tipo, String nombre) {
    this.tipo = tipo;
    this.nombre = nombre;
  }

  public char getTipo() {
    return this.tipo;
  }

  public void setTipo(char tipo) {
    this.tipo = tipo;
  }

  public Jugador getPropietario() {
    return this.propietario;
  }

  public void setPropietario(Jugador propietario) {
    this.propietario = propietario;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
