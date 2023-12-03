package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Ficha;
import java.util.Scanner;

public class MenuInicio {

  int opcion;

  int opcionColor;

  Scanner scanner = new Scanner(System.in);

  public MenuInicio(
    Jugador jugador1,
    Jugador jugador2,
    Ficha fichaRoja,
    Ficha fichaAzul
  ) {
    menuInicio();
    switch (opcion) {
      case 1:
        preguntarNombres(jugador1, jugador2, fichaRoja, fichaAzul);
        break;
      case 2:
        System.out.println("Gracias por jugar");
        System.exit(0);
        break;
      default:
        System.out.println("Opción no válida");
        break;
    }
  }

  private void menuInicio() {
    System.out.println("Bienvenido a MegaPoly");
    System.out.println("1. Jugar");
    System.out.println("2. Salir");
    System.out.println("Seleccione una opción");
    opcion = scanner.nextInt();
  }

  private void preguntarNombres(
    Jugador jugador1,
    Jugador jugador2,
    Ficha fichaRoja,
    Ficha fichaAzul
  ) {
    System.out.println("Ingrese el nombre del jugador 1");
    jugador1.setNombre(scanner.next());
    System.out.println(" ");
    System.out.println("Seleccione una ficha para el jugador 1:");
    System.out.println("1. Ficha Roja");
    System.out.println("2. Ficha Azul");
    opcionColor = scanner.nextInt();
    setColorFicha(opcionColor, jugador1, jugador2, fichaRoja, fichaAzul);
    System.out.println("Ingrese el nombre del jugador 2");
    jugador2.setNombre(scanner.next());
    System.out.println(" ");
    System.out.println(
      jugador1.getNombre() +
      " (jugador 1) adquirió la ficha " +
      jugador1.getFicha().getColorFicha() +
      " y " +
      jugador2.getNombre() +
      " adquirió la ficha " +
      jugador2.getFicha().getColorFicha()
    );
  }

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
      System.out.println("Opción no válida");
    }
  }
}
