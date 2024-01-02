package com.mycompany.megapoly.Jugadores;

import com.mycompany.megapoly.CartasSuerte.CartaSuerte;
import com.mycompany.megapoly.Comprables.Comprable;
import com.mycompany.megapoly.Materiales.Ficha;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/*
 * Clase que se encarga de crear los jugadores
 * @see Ficha
 * @see CartaSuerte
 * @see Comprable
 *
 */
public class Jugador implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  private boolean carcel = false;

  private static final int w = 100;

  private String nombre;

  private boolean turno;

  private int megaMonedas;

  // lista de cartas de suerte de cada jugador
  private List<CartaSuerte> cartas = new ArrayList<CartaSuerte>();

  // lista de propiedades de cada jugador
  private List<Comprable> comprables = new ArrayList<Comprable>();

  // ficha de cada jugador
  private Ficha ficha;

  /*
   * Constructor de la clase
   * @param nombre Nombre del jugador
   * @param turno Turno del jugador
   * @param ficha Ficha del jugador
   */
  public Jugador(String nombre, boolean turno, Ficha ficha) {
    this.nombre = nombre;
    this.turno = turno;
    this.megaMonedas = 100;
    this.ficha = ficha;
    this.cartas = new ArrayList<CartaSuerte>();
    this.comprables = new ArrayList<Comprable>();
  }

  /*
   * Constructor de la clase
   * @param ficha Ficha del jugador
   * @see Ficha
   */
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

  public void setFicha(Ficha ficha) {
    this.ficha = ficha;
  }

  public List<CartaSuerte> getCartas() {
    return this.cartas;
  }

  /*
   * Metodo que se encarga de mostrar las cartas de suerte de cada jugador
   * @see CartaSuerte
   */
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

  /*
   * Metodo que se encarga de usar las cartas de suerte de cada jugador
   * @param scanner Scanner
   * @param jugadorEnemigo Jugador enemigo
   * @return boolean
   */
  public boolean usarCartas(Scanner scanner, Jugador jugadorEnemigo) {
    System.out.println(
      StringUtils.center(
        "Ingrese el numero de la carta que desea usar (-1 para no usar ninguna): ",
        w
      )
    );
    int index = scanner.nextInt();
    // Si el jugador no quiere usar ninguna carta
    if (index == -1) {
      System.out.println(
        StringUtils.center(
          "No se usara ninguna carta, se seguira con el juego:",
          w
        )
      );
      System.out.println(" ");
      // Si el jugador quiere usar una carta
    } else {
      this.usarCarta(index, jugadorEnemigo);
    }
    return true;
  }

  public void setCartas(CartaSuerte carta) {
    this.cartas.add(carta);
  }

  public void setCartasTotales(List<CartaSuerte> cartas) {
    for (CartaSuerte carta : cartas) {
      this.cartas.add(carta);
    }
  }

  /*
   * Metodo que se encarga de usar las cartas de suerte de cada jugador
   * @param index Indice de la carta
   * @param jugadorEnemigo Jugador enemigo
   * @see CartaSuerte
   * @see Jugador
   */
  public void usarCarta(int index, Jugador jugadorEnemigo) {
    this.cartas.get(index).efecto(this, jugadorEnemigo);
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

  public void setCarcel(boolean carcel) {
    this.carcel = carcel;
  }

  public boolean getCarcel() {
    return this.carcel;
  }

  public List<Comprable> getPropiedades() {
    return this.comprables;
  }
}
