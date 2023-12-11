package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Ficha;
import java.util.Scanner;

/*
 * Clase que se encarga de mostrar el menu de inicio del juego
 * @see Menu
 */
public class MenuInicio extends Menu {

  private int opcion;

  private int opcionColor;

  private Scanner scanner = new Scanner(System.in);

  /*
   * Constructor de la clase
   * @param jugador1 Jugador 1
   * @param jugador2 Jugador 2
   * @param fichaRoja Ficha roja
   * @param fichaAzul Ficha azul
   */
  public MenuInicio(
    Jugador jugador1,
    Jugador jugador2,
    Ficha fichaRoja,
    Ficha fichaAzul
  ) {
    // Mensaje de bienvenida
    menuInicio();
    switch (opcion) {
      case 1:
        // Preguntamos los nombres de los jugadores
        preguntarNombres(jugador1, jugador2, fichaRoja, fichaAzul);
        break;
      case 2:
        // Salimos del juego
        ConsoleHelpers.limpiarConsola();
        this.printCentradoEnConsola(this.mensajeDespedida);
        System.exit(0);
        break;
      default:
        this.printCentradoEnConsola("Opción no válida");
        break;
    }
  }

  /*
   * Metodo que se encarga de mostrar el menu de inicio
   * @see Menu
   * @see ConsoleHelpers
   */
  private void menuInicio() {
    System.out.print("\033\143"); // Limpiamos la consola
    this.printCentradoEnConsola(this.mensajeBienvenida);
    System.out.println("");
    System.out.println("");
    this.seleccionarOpcionesAlInicio();
  }

  /*
   * Metodo que se encarga de mostrar las opciones del menu de inicio
   * @see ConsoleHelpers
   */
  private void seleccionarOpcionesAlInicio() {
    this.printCentradoEnConsola("Seleccione una opción");
    System.out.println("");
    this.printCentradoEnConsola("1. Jugar");
    System.out.println("");
    this.printCentradoEnConsola("2. Salir");
    opcion = scanner.nextInt();
    System.out.print("\033\143"); // Limpiamos la consola
  }

  /*
   * Metodo que se encarga de preguntar los nombres de los jugadores y asignar las fichas
   * @param jugador1 Jugador 1
   * @param jugador2 Jugador 2
   * @param fichaRoja Ficha roja
   * @param fichaAzul Ficha azul
   * @see Jugador
   * @see Ficha
   * @see ConsoleHelpers
   */
  private void preguntarNombres(
    Jugador jugador1,
    Jugador jugador2,
    Ficha fichaRoja,
    Ficha fichaAzul
  ) {
    System.out.println("");
    this.printCentradoEnConsola("Ingrese el nombre del jugador 1");
    jugador1.setNombre(scanner.next());
    System.out.print("\033\143"); // Limpiamos la consola
    System.out.println(" ");
    this.printCentradoEnConsola("Seleccione una ficha para el jugador 1:");
    System.out.println("");
    System.out.println("");
    this.printCentradoEnConsola("1. Ficha Roja");
    System.out.println("");
    this.printCentradoEnConsola("2. Ficha Azul");
    System.out.println("");
    System.out.println("");
    opcionColor = scanner.nextInt();
    System.out.print("\033\143"); // Limpiamos la consola
    setColorFicha(opcionColor, jugador1, jugador2, fichaRoja, fichaAzul);
    this.printCentradoEnConsola("Ingrese el nombre del jugador 2:");
    jugador2.setNombre(scanner.next());
    System.out.print("\033\143"); // Limpiamos la consola
    System.out.println(" ");
    this.printCentradoEnConsola(
        jugador1.getNombre() +
        " (jugador 1) adquirió la ficha " +
        jugador1.getFicha().getColorFicha() +
        " y " +
        jugador2.getNombre() +
        " adquirió la ficha " +
        jugador2.getFicha().getColorFicha()
      );
    System.out.println("");
    System.out.println("");
    this.printCentradoEnConsola("Presione enter para continuar...");
    try {
      System.in.read();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /*
   * Metodo que se encarga de asignar el color de la ficha
   * @param opcionColor Opcion de color
   * @param jugador1 Jugador 1
   * @param jugador2 Jugador 2
   * @param fichaRoja Ficha roja
   * @param fichaAzul Ficha azul
   * @see Jugador
   * @see Ficha
   * @see ConsoleHelpers
   */
  private void setColorFicha(
    int opcionColor,
    Jugador jugador1,
    Jugador jugador2,
    Ficha fichaRoja,
    Ficha fichaAzul
  ) {
    if (opcionColor == 1) {
      jugador1.getFicha().setColorFicha("Rojo");
      fichaRoja.setJugador(jugador1);
      jugador2.getFicha().setColorFicha("Azul");
      fichaAzul.setJugador(jugador2);
    } else if (opcionColor == 2) {
      jugador1.getFicha().setColorFicha("Azul");
      fichaAzul.setJugador(jugador1);
      jugador2.getFicha().setColorFicha("Rojo");
      fichaRoja.setJugador(jugador2);
    } else {
      this.printCentradoEnConsola("Opción no válida");
    }
  }
}
