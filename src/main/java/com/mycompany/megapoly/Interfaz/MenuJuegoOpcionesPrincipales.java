package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Acciones.EntradaSalidaCarcel;
import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Dado;
import com.mycompany.megapoly.Materiales.Tablero;
import java.util.Scanner;

public class MenuJuegoOpcionesPrincipales extends Menu {

  Jugador jugadorTurno;

  Jugador jugadorEnemigo;

  Scanner scanner;

  Tablero tablero;

  Dado dado = new Dado();

  private int opcion;

  public MenuJuegoOpcionesPrincipales(
    Jugador jugadorTurno,
    Jugador jugadorEnemigo,
    Scanner scanner,
    Tablero tablero
  ) {
    this.jugadorTurno = jugadorTurno;
    this.jugadorEnemigo = jugadorEnemigo;
    this.scanner = scanner;
    this.tablero = tablero;
  }

  public boolean mostrarCartasOTirarDado() {
    tablero.mostrarTablero();
    this.mostrarOpciones();
    switch (this.opcion) {
      case 1:
        int numeroDado = this.tirarDado();
        this.avanzarFicha(numeroDado);
        return false;
      case 2:
        this.jugadorTurno.mostrarCartas();
        return this.jugadorTurno.usarCartas(this.scanner, this.jugadorEnemigo);
      case 3:
        ConsoleHelpers.limpiarConsola();
        this.salirDelJuego();
        return false;
      default:
        return false;
    }
  }

  private void avanzarFicha(int numeroDado) {
    if (this.jugadorTurno.getCarcel()) {
      if (numeroDado == 5) {
        EntradaSalidaCarcel.salirCarcel(this.jugadorTurno);
        System.out.println("");
        this.printCentradoEnConsola("Has sacado un 5, sales de la carcel.");
        System.out.println("");
        ConsoleHelpers.presionaEnterParaContinuar();
        this.jugadorTurno.getFicha().avanzar(this.tablero, numeroDado);
      } else {
        this.mostrarTiradaDado(numeroDado);
        this.printCentradoEnConsola(
            "No has sacado un 5, no sales de la carcel."
          );
        ConsoleHelpers.presionaEnterParaContinuar();
      }
    } else {
      this.jugadorTurno.getFicha().avanzar(this.tablero, numeroDado);
      this.mostrarTiradaDado(numeroDado);
    }
  }

  private void mostrarTiradaDado(int numeroDado) {
    System.out.println(" ");
    this.printCentradoEnConsola("Has sacado un " + numeroDado);
    System.out.println(" ");
  }

  private void mostrarOpciones() {
    this.printCentradoEnConsola("Opciones: ");
    this.printCentradoEnConsola("");
    this.printCentradoEnConsola("");
    this.printCentradoEnConsola("1. Tirar dado");
    this.printCentradoEnConsola("");
    this.printCentradoEnConsola("2. Ver cartas de suerte");
    this.printCentradoEnConsola("");
    this.printCentradoEnConsola("3. Salir");
    this.printCentradoEnConsola(" ");
    this.opcion = this.scanner.nextInt();
  }

  private int tirarDado() {
    this.dado.setNumeroAleatorio();
    return this.dado.getNumero();
  }

  private void salirDelJuego() {
    this.printCentradoEnConsola(this.mensajeDespedida);
    System.exit(0);
  }
}
