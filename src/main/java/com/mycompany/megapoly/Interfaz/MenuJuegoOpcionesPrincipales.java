package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Acciones.EntradaSalidaCarcel;
import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Dado;
import com.mycompany.megapoly.Materiales.Tablero;
import java.util.Scanner;

/*
 * Clase que se encarga de crear el menu de opciones principales
 * @see Menu
 */
public class MenuJuegoOpcionesPrincipales extends Menu {

  Jugador jugadorTurno;

  Jugador jugadorEnemigo;

  Scanner scanner;

  Tablero tablero;

  Dado dado = new Dado();

  private int opcion;

  /*
   * Constructor de la clase
   * @param jugadorTurno Jugador actual
   * @param jugadorEnemigo Jugador enemigo
   * @param scanner Scanner para leer datos por consola
   * @param tablero Tablero del juego
   */
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

  /*
   * Metodo que se encarga de mostrar cartas o tirar dado
   * @see Menu
   * @return boolean
   */
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

  /*
   * Metodo que se encarga de avanzar la ficha
   * @param numeroDado Numero del dado
   * @return void
   */
  private void avanzarFicha(int numeroDado) {
    // Si el jugador esta en la carcel
    if (this.jugadorTurno.getCarcel()) {
      // Si el jugador saca un 5
      if (numeroDado == 5) {
        EntradaSalidaCarcel.salirCarcel(this.jugadorTurno);
        System.out.println("");
        this.printCentradoEnConsola("Has sacado un 5, sales de la carcel.");
        System.out.println("");
        ConsoleHelpers.presionaEnterParaContinuar();
        this.jugadorTurno.getFicha().avanzar(this.tablero, numeroDado);
        // Si el jugador no saca un 5
      } else {
        this.mostrarTiradaDado(numeroDado);
        this.printCentradoEnConsola(
            "No has sacado un 5, no sales de la carcel."
          );
        ConsoleHelpers.presionaEnterParaContinuar();
      }
      // Si el jugador no esta en la carcel
    } else {
      this.jugadorTurno.getFicha().avanzar(this.tablero, numeroDado);
      this.mostrarTiradaDado(numeroDado);
    }
  }

  /*
   * Metodo que se encarga de mostrar la tirada del dado
   * @param numeroDado Numero del dado
   * @return void
   */
  private void mostrarTiradaDado(int numeroDado) {
    System.out.println(" ");
    this.printCentradoEnConsola("Has sacado un " + numeroDado);
    System.out.println(" ");
  }

  /*
   * Metodo que se encarga de mostrar las opciones
   * @see Menu
   * @return void
   */
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

  /*
   * Metodo que se encarga de tirar el dado
   * @return int
   */
  private int tirarDado() {
    this.dado.setNumeroAleatorio();
    return this.dado.getNumero();
  }

  /*
   * Metodo que se encarga de salir del juego
   * @return void
   */
  private void salirDelJuego() {
    this.printCentradoEnConsola(this.mensajeDespedida);
    System.exit(0);
  }
}
