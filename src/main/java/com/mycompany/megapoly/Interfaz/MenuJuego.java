package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Tablero;
import java.util.Scanner;

/*
 * Clase que se encarga de mostrar el menu del juego
 * @see Menu
 */
public class MenuJuego extends Menu {

  private Jugador jugadorTurno;

  private Jugador jugadorEnemigo;

  private Scanner scanner = new Scanner(System.in);

  private boolean salir = false;

  private boolean usaCartas = false;

  /*
   * Constructor de la clase
   * @param jugador1 Jugador 1
   * @param jugador2 Jugador 2
   * @param tablero Tablero del juego
   */
  public MenuJuego(Jugador jugador1, Jugador jugador2, Tablero tablero) {
    jugador1.setTurno(true);
    jugador2.setTurno(false);

    tablero.crearTablero();
    while (!salir) {
      this.comenzarPartida(jugador1, jugador2, tablero, this.scanner);
      this.finalizarPartida(jugador1, jugador2);
    }
  }

  /*
   * Metodo principal que se encarga de comenzar la partida
   * @param jugador1 Jugador 1
   * @param jugador2 Jugador 2
   * @param tablero Tablero del juego
   * @param scanner Scanner para leer datos por consola
   * @see MenuJuegoInicio
   * @see MenuJuegoOpcionesPrincipales
   * @see MenuJuegoOpcionesCasilla
   * @see ConsoleHelpers
   */
  private void comenzarPartida(
    Jugador jugador1,
    Jugador jugador2,
    Tablero tablero,
    Scanner scanner
  ) {
    MenuJuegoInicio Inicio = new MenuJuegoInicio(
      jugador1,
      jugador2,
      tablero,
      scanner
    );
    this.jugadorTurno = Inicio.determinarTurno();
    this.determinarEnemigo(jugador1, jugador2);
    Inicio.mostrarTurno(this.jugadorTurno);
    MenuJuegoOpcionesPrincipales OpcionesPrincipales = new MenuJuegoOpcionesPrincipales(
      this.jugadorTurno,
      this.jugadorEnemigo,
      this.scanner,
      tablero
    );
    // Mientras usaCartas sea true, mostraremos este menu
    do {
      usaCartas = OpcionesPrincipales.mostrarCartasOTirarDado();
    } while (usaCartas);
    MenuJuegoOpcionesCasilla opcionesCasilla = new MenuJuegoOpcionesCasilla(
      this.jugadorTurno,
      this.scanner,
      tablero
    );
    opcionesCasilla.opcionesSuerteCompraPropiedad();
    //Cambiamos el turno
    this.cambiarTurno(jugador1, jugador2);
  }

  private void finalizarPartida(Jugador jugador1, Jugador jugador2) {
    if (jugador1.getMegaMonedas() <= 0) {
      ConsoleHelpers.printCentrado(
        "El jugador " +
        jugador1.getNombre() +
        " ha perdido" +
        " el ganador es " +
        jugador2.getNombre()
      );
      this.salir = true;
      return;
    } else if (jugador2.getMegaMonedas() <= 0) {
      ConsoleHelpers.printCentrado(
        "El jugador " +
        jugador2.getNombre() +
        " ha perdido" +
        " el ganador es " +
        jugador1.getNombre()
      );
      this.salir = true;
      return;
    }
  }

  /*
   * Metodo que se encarga de cambiar el turno de los jugadores
   * @param jugador1 Jugador 1
   * @param jugador2 Jugador 2
   * @see Jugador
   * @see ConsoleHelpers
   */
  private void cambiarTurno(Jugador jugador1, Jugador jugador2) {
    jugador1.setTurno(!jugador1.getTurno());
    jugador2.setTurno(!jugador2.getTurno());
    ConsoleHelpers.presionaEnterParaContinuar();
  }

  /*
   * Metodo que se encarga de determinar el enemigo del jugador
   * @param jugador1 Jugador 1
   * @param jugador2 Jugador 2
   * @see Jugador
   */
  private void determinarEnemigo(Jugador jugador1, Jugador jugador2) {
    if (jugador1.getTurno()) {
      this.jugadorEnemigo = jugador2;
    } else {
      this.jugadorEnemigo = jugador1;
    }
  }
}
