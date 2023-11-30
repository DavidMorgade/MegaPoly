package com.mycompany.megapoly.Jugadores;

import com.mycompany.megapoly.Materiales.Ficha;

public class Jugador {

  private String nombre;

  private boolean turno;

  private int megaMonedas;

  Ficha ficha;

  public Jugador(String nombre, boolean turno, Ficha ficha) {
    this.nombre = nombre;
    this.turno = turno;
    this.megaMonedas = 100;
    this.ficha = ficha;
  }

  public String getNombre() {
    return this.nombre;
  }

  public boolean isTurno() {
    return this.turno;
  }

  public int getMegaMonedas() {
    return this.megaMonedas;
  }

  public Ficha getFicha() {
    return this.ficha;
  }

  public void cambiarTurno() {
    this.turno = !this.turno;
  }

  public void restarMegaMonedas(int cantidad) {
    this.megaMonedas -= cantidad;
  }

  public void sumarMegaMonedas(int cantidad) {
    this.megaMonedas += cantidad;
  }
}
