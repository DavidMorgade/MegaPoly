package com.mycompany.megapoly.Materiales;

import com.mycompany.megapoly.Acciones.RecompensaSalida;
import com.mycompany.megapoly.Jugadores.Jugador;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/*
 * Clase que se encarga de crear las fichas
 * @see Jugador
 */
public class Ficha {

  private int posicion;

  private String colorFicha;

  private Jugador jugador;

  /*
   * Constructor de la clase
   * @param posicion Posición de la ficha
   */
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

  /*
   * Metodo que se encarga de avanzar la ficha
   * @param tablero Tablero del juego
   * @param posiciones Posiciones que se van a avanzar
   * @see Tablero
   * @return void
   */
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

    // Actualizar la posición de la ficha
    this.setPosicion(indicesValidos[nuevoIndice]);

    // Si caemos en la casilla de salida, obtenemos una recompensa
    if ((indiceActual >= 10 || indiceActual == 5) && this.getPosicion() <= 9) {
      tablero.mostrarTablero();
      RecompensaSalida recompensaSalida = new RecompensaSalida();
      int recompensa = recompensaSalida.getRecompensa();
      this.jugador.setMegaMonedas(this.jugador.getMegaMonedas() + recompensa);
      System.out.println(" ");
      System.out.println(" ");
      System.out.println(
        StringUtils.center(
          "Consigues una recompensa de " +
          recompensa +
          " MegaMonedas al pasar por la casilla de salida",
          100
        )
      );
      System.out.println(" ");
      System.out.println(
        StringUtils.center("Presione enter para continuar...", 100)
      );
      try {
        System.in.read();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
