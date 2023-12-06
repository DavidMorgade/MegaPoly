package com.mycompany.megapoly.Jugadores;

import com.mycompany.megapoly.CartasSuerte.CartaSuerte;
import com.mycompany.megapoly.Comprables.Comprable;
import com.mycompany.megapoly.Materiales.Ficha;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Jugador {

  private static final int w = 100;

  private String nombre;

  private boolean turno;

  private int megaMonedas;

  // lista de cartas de suerte de cada jugador
  private List<CartaSuerte> cartas = new ArrayList<CartaSuerte>();

  private List<Comprable> comprables = new ArrayList<Comprable>();

  Ficha ficha;

  public Jugador(String nombre, boolean turno, Ficha ficha) {
    this.nombre = nombre;
    this.turno = turno;
    this.megaMonedas = 100;
    this.ficha = ficha;
    this.cartas = new ArrayList<CartaSuerte>();
    this.comprables = new ArrayList<Comprable>();
  }

  public Jugador(Ficha ficha) {
    this.ficha = ficha;
    this.megaMonedas = 100;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public boolean getTurno() {
    return this.turno;
  }

  public void setTurno(boolean turno) {
    this.turno = turno;
  }

  public int getMegaMonedas() {
    return this.megaMonedas;
  }

  public void setMegaMonedas(int megaMonedas) {
    this.megaMonedas = megaMonedas;
  }

  public Ficha getFicha() {
    return this.ficha;
  }

  public void mostrarCartas() {
    if (this.cartas.isEmpty()) {
      System.out.println("");
      System.out.println(StringUtils.center("No tienes cartas de suerte", w));
      System.out.println("");
    } else {
      System.out.println(StringUtils.center("Tus cartas de suerte son: ", w));
      for (CartaSuerte carta : this.cartas) {
        int index = this.cartas.indexOf(carta);
        System.out.println(StringUtils.center("Carta " + index + ": ", w));
        System.out.println(" ");
        System.out.println(
          StringUtils.center("Nombre: " + carta.getNombre(), w)
        );
        System.out.println(" ");
        System.out.println(
          StringUtils.center("Descripcion: " + carta.getDescripcion(), w)
        );
        System.out.println(" ");
      }
    }
  }

  public boolean usarCartas(Scanner scanner) {
    System.out.println(
      StringUtils.center(
        "Ingrese el numero de la carta que desea usar (-1 para no usar ninguna): ",
        w
      )
    );
    int index = scanner.nextInt();
    if (index == -1) {
      System.out.println(
        StringUtils.center(
          "No se usara ninguna carta, se seguira con el juego:",
          w
        )
      );
      System.out.println(" ");
    } else {
      this.cartas.get(index).efecto(this);
      this.cartas.remove(index);
    }
    return true;
  }

  public void setCartas(CartaSuerte carta) {
    this.cartas.add(carta);
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

  public void setPropiedades(Comprable propiedad) {
    this.comprables.add(propiedad);
  }

  public List<Comprable> getPropiedades() {
    return this.comprables;
  }
}
