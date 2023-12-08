package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Dado;
import com.mycompany.megapoly.Materiales.Tablero;
import java.util.Scanner;

public class MenuJuegoOpcionesPrincipales extends Menu {

  Jugador jugadorTurno;

  Scanner scanner;

  Tablero tablero;

  Dado dado = new Dado();

  private int opcion;

  public MenuJuegoOpcionesPrincipales(
    Jugador jugadorTurno,
    Scanner scanner,
    Tablero tablero
  ) {
    this.jugadorTurno = jugadorTurno;
    this.scanner = scanner;
    this.tablero = tablero;
  }

  public boolean mostrarCartasOTirarDado() {
    this.mostrarOpciones();
    switch (this.opcion) {
      case 1:
        int numeroDado = this.tirarDado();
        this.jugadorTurno.getFicha().avanzar(this.tablero, numeroDado);
        this.mostrarTiradaDado(numeroDado);
        return false;
      case 2:
        this.jugadorTurno.mostrarCartas();
        return this.jugadorTurno.usarCartas(this.scanner);
      case 3:
        this.salirDelJuego();
        return false;
      default:
        return false;
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
    opcion = this.scanner.nextInt();
  }

  private int tirarDado() {
    this.dado.setNumeroAleatorio();
    return this.dado.getNumero();
  }

  private void salirDelJuego() {
    this.printCentradoEnConsola("Gracias por jugar");
    System.exit(0);
  }
}
