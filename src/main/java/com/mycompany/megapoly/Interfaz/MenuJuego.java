package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Acciones.Comprar;
import com.mycompany.megapoly.Acciones.Venta;
import com.mycompany.megapoly.Casillas.Casilla;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Casillas.CasillaSuerte;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Dado;
import com.mycompany.megapoly.Materiales.Tablero;
import java.util.Scanner;

public class MenuJuego extends Menu {

  Scanner scanner = new Scanner(System.in);

  private boolean salir = false;

  private boolean usaCartas = false;

  private int opcion;

  private int opcionCompra;

  private Dado dado = new Dado();

  private Comprar comprar = new Comprar();

  private Venta venta = new Venta();

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

    Jugador jugadorTurno = Inicio.determinarTurno(jugador1, jugador2);
    Inicio.mostrarTurno(jugadorTurno);
    do {
      this.mostrarOpciones(jugadorTurno);
      this.mostrarCartasOTirarDado(jugadorTurno, tablero);
    } while (usaCartas);
    Casilla casillaActual = this.obtenerCasilla(tablero, jugadorTurno);
    this.mostrarCasilla(casillaActual, jugadorTurno);
    if (casillaActual instanceof CasillaPropiedad) {
      CasillaPropiedad casillaPropiedad = (CasillaPropiedad) casillaActual;
      if (
        casillaPropiedad
          .getPropiedad()
          .getPropietario()
          .getNombre()
          .equals("Banco")
      ) {
        this.comprarPropiedad(jugadorTurno, casillaPropiedad);
      }
    }
    this.cambiarTurno(jugador1, jugador2);
  }

  private void mostrarOpciones(Jugador jugadorTurno) {
    this.printCentradoEnConsola("Opciones: ");
    this.printCentradoEnConsola("");
    this.printCentradoEnConsola("");
    this.printCentradoEnConsola("1. Tirar dado");
    this.printCentradoEnConsola("");
    this.printCentradoEnConsola("2. Ver cartas de suerte");
    this.printCentradoEnConsola("");
    this.printCentradoEnConsola("3. Salir");
    this.printCentradoEnConsola(" ");
    opcion = scanner.nextInt();
  }

  private void mostrarOpcionesCompra(Jugador jugadorTurno) {
    this.printCentradoEnConsola("Opciones: ");
    System.out.println("");
    System.out.println("");
    this.printCentradoEnConsola("1. Comprar");
    System.out.println("");
    this.printCentradoEnConsola("2. No comprar");
    this.printCentradoEnConsola(" ");
    System.out.println("");
    opcionCompra = scanner.nextInt();
  }

  private void comprarPropiedad(
    Jugador jugadorTurno,
    CasillaPropiedad casillaPropiedad
  ) {
    System.out.println("");
    this.printCentradoEnConsola("Desea comprar la propiedad?");
    this.mostrarOpcionesCompra(jugadorTurno);
    switch (this.opcionCompra) {
      case 1:
        comprar.comprarPropiedad(jugadorTurno, casillaPropiedad.getPropiedad());
        break;
      case 2:
        this.printCentradoEnConsola(
            "No se compro la propiedad, se seguira con el juego"
          );
        break;
      default:
        break;
    }
  }

  private void tirarDado() {
    dado.setNumeroAleatorio();
  }

  private void mostrarCartasOTirarDado(Jugador jugadorTurno, Tablero tablero) {
    switch (this.opcion) {
      case 1:
        this.tirarDado();
        jugadorTurno.getFicha().avanzar(tablero, dado.getNumero());
        usaCartas = false;
        break;
      case 2:
        jugadorTurno.mostrarCartas();
        usaCartas = jugadorTurno.usarCartas(scanner);
        break;
      case 3:
        salir = true;
        return;
      default:
        break;
    }
  }

  private void cambiarTurno(Jugador jugador1, Jugador jugador2) {
    jugador1.setTurno(!jugador1.getTurno());
    jugador2.setTurno(!jugador2.getTurno());
  }

  private Casilla obtenerCasilla(Tablero tablero, Jugador jugador) {
    int posicion = jugador.getFicha().getPosicion();
    return tablero.getCasillas()[posicion];
  }

  private void mostrarCasilla(Casilla casilla, Jugador jugadorActual) {
    this.printCentradoEnConsola(
        "Has caido en la casilla: " + casilla.getNombre()
      );
    if (casilla instanceof CasillaPropiedad) {
      System.out.println(" ");
      this.printCentradoEnConsola(
          "Precio: " +
          ((CasillaPropiedad) casilla).getPropiedad().getPrecioCompra()
        );
      if (
        ((CasillaPropiedad) casilla).getPropiedad()
          .getPropietario()
          .getNombre()
          .equals("Banco")
      ) {
        System.out.println(" ");
        this.printCentradoEnConsola("No tiene dueño");
        System.out.println(" ");
      } else {
        System.out.println("");
        this.printCentradoEnConsola(
            "Dueño: " +
            ((CasillaPropiedad) casilla).getPropiedad()
              .getPropietario()
              .getNombre()
          );
      }
    }
    if (casilla instanceof CasillaSuerte) {
      CasillaSuerte casillaSuerte = (CasillaSuerte) casilla;
      casillaSuerte.setCarta();
      System.out.println("");
      this.printCentradoEnConsola(
          "Carta de suerte: " +
          casillaSuerte.getCarta().getNombre() +
          " se agrega en tu inventario de cartas."
        );
      jugadorActual.setCartas(casillaSuerte.getCarta());
    }
  }
}
