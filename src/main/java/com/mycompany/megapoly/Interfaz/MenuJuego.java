package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Tablero;
import java.util.Scanner;

public class MenuJuego extends Menu {

  private Jugador jugadorTurno;

  private Scanner scanner = new Scanner(System.in);

  private boolean salir = false;

  private boolean usaCartas = false;

  public MenuJuego(Jugador jugador1, Jugador jugador2, Tablero tablero) {
    jugador1.setTurno(true);
    jugador2.setTurno(false);

    tablero.crearTablero();
    while (!salir) {
      this.comenzarPartida(jugador1, jugador2, tablero);
    }
  }

  private void comenzarPartida(
    Jugador jugador1,
    Jugador jugador2,
    Tablero tablero
  ) {
    MenuJuegoInicio Inicio = new MenuJuegoInicio(jugador1, jugador2);
    // Mostramos el tablero
    tablero.mostrarTablero();
    this.jugadorTurno = Inicio.determinarTurno();
    Inicio.mostrarTurno(this.jugadorTurno);

    MenuJuegoOpcionesPrincipales OpcionesPrincipales = new MenuJuegoOpcionesPrincipales(
      this.jugadorTurno,
      this.scanner,
      tablero
    );
    do {
      usaCartas = OpcionesPrincipales.mostrarCartasOTirarDado();
    } while (usaCartas);
    MenuJuegoOpcionesCasilla opcionesCasilla = new MenuJuegoOpcionesCasilla(
      this.jugadorTurno,
      this.scanner,
      tablero
    );
    opcionesCasilla.opcionesSuerteCompraPropiedad();
    // Mostramos el tablero
    tablero.mostrarTablero();
    this.cambiarTurno(jugador1, jugador2);
  }

  private void cambiarTurno(Jugador jugador1, Jugador jugador2) {
    jugador1.setTurno(!jugador1.getTurno());
    jugador2.setTurno(!jugador2.getTurno());
  }
}
