package Materiales;

import Acciones.RecompensaSalida;
import Jugadores.Jugador;
import java.io.IOException;

/*
 * Clase que se encarga de crear las fichas
 * @see Jugador
 */
public class Ficha implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  private int posicion;

  private String colorFicha;

  private Jugador jugador;

  /*
   * Constructor de la clase
   * @param posicion Posición de la ficha
   */
  public Ficha(String colorFicha) {
    this.posicion = 0;
    this.colorFicha = colorFicha;
  }

  public Jugador getJugador() {
    return this.jugador;
  }

  public void setJugador(Jugador jugador) {
    this.jugador = jugador;
  }

  public int getPosicion() {
    return this.posicion;
  }

  public void setPosicion(int posicion) {
    this.posicion = posicion;
  }

  public String getColorFicha() {
    return this.colorFicha;
  }

  public void setColorFicha(String colorFicha) {
    this.colorFicha = colorFicha;
  }


}

