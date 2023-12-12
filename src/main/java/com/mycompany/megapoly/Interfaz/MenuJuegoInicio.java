package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Tablero;
import java.util.Scanner;

/*
 * Clase que se encarga de mostrar el menu del juego al inicio de una ronda
 * @see Menu
 */
public class MenuJuegoInicio extends Menu {

  Jugador jugador1;
  Jugador jugador2;
  Tablero tablero;
  Scanner scanner;

  /*
   * Constructor de la clase
   * @param jugador1 Jugador 1
   * @param jugador2 Jugador 2
   * @param tablero Tablero del juego
   * @param scanner Scanner para leer datos por consola
   */
  public MenuJuegoInicio(
    Jugador jugador1,
    Jugador jugador2,
    Tablero tablero,
    Scanner scanner
  ) {
    this.jugador1 = jugador1;
    this.jugador2 = jugador2;
    this.tablero = tablero;
    this.scanner = scanner;
  }

  /*
   * Metodo principal que se encarga de comenzar la partida
   * @param jugador1 Jugador 1
   * @param jugador2 Jugador 2
   * @param tablero Tablero del juego
   * @param scanner Scanner para leer datos por consola
   * @see Menu
   * @see ConsoleHelpers
   */
  public void mostrarTurno(Jugador jugadorTurno) {
    tablero.mostrarTablero();
    ConsoleHelpers.printCentrado("Turno de: " + jugadorTurno.getNombre());
    ConsoleHelpers.printCentrado(
      "Ficha: " + jugadorTurno.getFicha().getColorFicha()
    );
    ConsoleHelpers.printCentrado(
      "Mega monedas: " + jugadorTurno.getMegaMonedas()
    );
    ConsoleHelpers.printCentrado(" ");
    ConsoleHelpers.presionaEnterParaContinuar();
  }

  /*
   * Metodo que determina el turno de los jugadores
   * @return Jugador que tiene el turno
   */
  public Jugador determinarTurno() {
    return this.jugador1.getTurno() ? this.jugador1 : this.jugador2;
  }
}
