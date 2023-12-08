package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Tablero;
import java.io.IOException;
import java.util.Scanner;

public class MenuJuegoInicio extends Menu {

  Jugador jugador1;
  Jugador jugador2;
  Tablero tablero;
  Scanner scanner;

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

  public void mostrarTurno(Jugador jugadorTurno) {
    tablero.mostrarTablero();
    this.printCentradoEnConsola("Turno de: " + jugadorTurno.getNombre());
    this.printCentradoEnConsola(
        "Ficha: " + jugadorTurno.getFicha().getColorFicha()
      );
    this.printCentradoEnConsola(
        "Mega monedas: " + jugadorTurno.getMegaMonedas()
      );
    this.printCentradoEnConsola(" ");
    this.printCentradoEnConsola("Presione enter para continuar...");
    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Jugador determinarTurno() {
    return this.jugador1.getTurno() ? this.jugador1 : this.jugador2;
  }
}
