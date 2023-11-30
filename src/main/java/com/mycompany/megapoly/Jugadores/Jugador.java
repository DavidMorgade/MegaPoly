package com.mycompany.megapoly.Jugadores;

import com.mycompany.megapoly.CartasSuerte.CartaSuerte;
import com.mycompany.megapoly.Materiales.Ficha;
import java.util.List;

public class Jugador {

  private String nombre;

  private boolean turno;

  private int megaMonedas;

  // lista de cartas de suerte de cada jugador
  private List<CartaSuerte> cartas;

  Ficha ficha;

  public Jugador(String nombre, boolean turno, Ficha ficha) {
    this.nombre = nombre;
    this.turno = turno;
    this.megaMonedas = 100;
    this.ficha = ficha;
  }

  public Jugador(Ficha ficha) {
    this.ficha = ficha;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
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

  public void getCartas() {
    if (this.cartas.isEmpty()) {
      System.out.println("No tienes cartas de suerte");
    } else {
      for (CartaSuerte carta : this.cartas) {
        System.out.println("Tus cartas de suerte son: ");
        System.out.println("Nombre: " + carta.getNombre());
        System.out.println("Descripcion: " + carta.getDescripcion());
        System.out.println(" ");
      }
    }
  }

  public void usarCarta(int index) {
    this.cartas.get(index).efecto(this);
    this.cartas.remove(index);
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
