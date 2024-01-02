package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Ficha;
import com.mycompany.megapoly.Sonido.SonidoInicio;
import java.util.Scanner;

/*
 * Clase que se encarga de mostrar el menu de inicio del juego
 * @see Menu
 */
public class MenuInicio extends Menu {

  private SonidoInicio sonido = new SonidoInicio();

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
    sonido.reproducir();
    menuInicio();
    boolean seguirMenuInicio = true;
    while (seguirMenuInicio) {
      switch (opcion) {
        case 1:
          // Preguntamos los nombres de los jugadores
          preguntarNombres(jugador1, jugador2, fichaRoja, fichaAzul);
          seguirMenuInicio = false;
          break;
        case 2:
          // Mostramos las reglas del juego
          ReglasJuego reglasJuego = new ReglasJuego();
          reglasJuego.mostrarReglas();
          menuInicio();
          break;
        case 3:
          // Cargamos la partida
          ConsoleHelpers.printCentrado(
            "Esta funcion aun no esta disponible :("
          );
          System.out.println(" ");
          ConsoleHelpers.presionaEnterParaContinuar();
          menuInicio();
          break;
        case 4:
          // Salimos del juego
          ConsoleHelpers.limpiarConsola();
          ConsoleHelpers.printCentrado(this.mensajeDespedida);
          seguirMenuInicio = false;
          System.exit(0);
          break;
        default:
          ConsoleHelpers.printCentrado("Opción no válida");
          menuInicio();
          break;
      }
    }
    sonido.parar();
  }

  /*
   * Metodo que se encarga de mostrar el menu de inicio
   * @see Menu
   * @see ConsoleHelpers
   */
  private void menuInicio() {
    ConsoleHelpers.limpiarConsola();
    ConsoleHelpers.printCentrado(this.mensajeBienvenida);
    System.out.println("");
    System.out.println("");
    this.seleccionarOpcionesAlInicio();
  }

  /*
   * Metodo que se encarga de mostrar las opciones del menu de inicio
   * @see ConsoleHelpers
   */
  private void seleccionarOpcionesAlInicio() {
    ConsoleHelpers.printCentrado("Seleccione una opción");
    System.out.println("");
    ConsoleHelpers.printCentrado("1. Jugar");
    System.out.println("");
    ConsoleHelpers.printCentrado("2. Reglas");
    System.out.println("");
    ConsoleHelpers.printCentrado("3. Cargar partida");
    System.out.println("");
    ConsoleHelpers.printCentrado("4. Salir");
    opcion = scanner.nextInt();
    ConsoleHelpers.limpiarConsola();
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
    ConsoleHelpers.printCentrado("Ingrese el nombre del jugador 1");
    jugador1.setNombre(scanner.next());
    System.out.print("\033\143"); // Limpiamos la consola
    System.out.println(" ");
    ConsoleHelpers.printCentrado("Seleccione una ficha para el jugador 1:");
    System.out.println("");
    System.out.println("");
    ConsoleHelpers.printCentrado("1. Ficha Roja");
    System.out.println("");
    ConsoleHelpers.printCentrado("2. Ficha Azul");
    System.out.println("");
    System.out.println("");
    opcionColor = scanner.nextInt();
    System.out.print("\033\143"); // Limpiamos la consola
    setColorFicha(opcionColor, jugador1, jugador2, fichaRoja, fichaAzul);
    ConsoleHelpers.printCentrado("Ingrese el nombre del jugador 2:");
    jugador2.setNombre(scanner.next());
    System.out.print("\033\143"); // Limpiamos la consola
    System.out.println(" ");
    ConsoleHelpers.printCentrado(
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
    ConsoleHelpers.printCentrado("Presione enter para continuar...");
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
      ConsoleHelpers.printCentrado("Opción no válida");
    }
  }
}
