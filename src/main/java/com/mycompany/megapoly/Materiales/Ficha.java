package com.mycompany.megapoly.Materiales;

import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Tablero.Tablero;

public class Ficha {

  private int posicion;

  private String colorFicha;

  private Jugador jugador;

  public Ficha() {
    this.posicion = 0;
    this.jugador = null;
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

  public void avanzar(Tablero tablero, int posiciones) {
    int posicionActual = this.getPosicion();

    // Índices válidos
    int[] indicesValidos = {
      0,
      1,
      2,
      3,
      4,
      9,
      14,
      19,
      24,
      23,
      22,
      21,
      20,
      15,
      10,
      5,
    };

    // Encontrar la posición actual en el array de índices válidos
    int indiceActual = -1;
    for (int i = 0; i < indicesValidos.length; i++) {
      if (posicionActual == indicesValidos[i]) {
        indiceActual = i;
        break;
      }
    }

    // Calcular la nueva posición avanzando un número específico de posiciones
    int nuevoIndice = (indiceActual + posiciones) % indicesValidos.length;

    // Asegurar que el índice es no negativo
    if (nuevoIndice < 0) {
      nuevoIndice += indicesValidos.length;
    }

    this.setPosicion(indicesValidos[nuevoIndice]);

    // Mostramos el tablero
    tablero.mostrarTablero();
  }
}
