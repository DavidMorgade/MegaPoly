package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Casillas.Casilla;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Casillas.CasillaSuerte;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Dado;
import com.mycompany.megapoly.Materiales.Tablero;
import java.util.Scanner;

public class MenuJuego {

  Scanner scanner = new Scanner(System.in);

  private boolean salir = false;

  private boolean usaCartas = false;

  private int opcion;

  private Dado dado = new Dado();

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
    Jugador jugadorTurno = this.determinarTurno(jugador1, jugador2);
    this.mostrarTurno(jugadorTurno);
    do {
      this.mostrarOpciones(jugadorTurno);
      this.mostrarCartasOTirarDado(jugadorTurno, tablero);
    } while (usaCartas);
    Casilla casillaActual = this.obtenerCasilla(tablero, jugadorTurno);
    this.mostrarCasilla(casillaActual, jugadorTurno);
    this.cambiarTurno(jugador1, jugador2);
  }

  private void mostrarTurno(Jugador jugadorTurno) {
    System.out.println("Turno de: " + jugadorTurno.getNombre());
    System.out.println("Ficha: " + jugadorTurno.getFicha().getColorFicha());
    System.out.println("Mega monedas: " + jugadorTurno.getMegaMonedas());
    System.out.println(" ");
  }

  private void mostrarOpciones(Jugador jugadorTurno) {
    System.out.println("Opciones: ");
    System.out.println("1. Tirar dado");
    System.out.println("2. Ver cartas de suerte");
    System.out.println("3. Salir");
    System.out.println(" ");
    opcion = scanner.nextInt();
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

  private Jugador determinarTurno(Jugador jugador1, Jugador jugador2) {
    return jugador1.getTurno() ? jugador1 : jugador2;
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
    System.out.println("Has caido en la casilla: " + casilla.getNombre());
    if (casilla instanceof CasillaPropiedad) {
      System.out.println(
        "Precio: " +
        ((CasillaPropiedad) casilla).getPropiedad().getPrecioCompra()
      );
      if (((CasillaPropiedad) casilla).getPropietario() == null) {
        System.out.println("No tiene dueño");
      } else {
        System.out.println(
          "Dueño: " + ((CasillaPropiedad) casilla).getPropietario().getNombre()
        );
      }
    }
    if (casilla instanceof CasillaSuerte) {
      CasillaSuerte casillaSuerte = (CasillaSuerte) casilla;
      casillaSuerte.setCarta();
      System.out.println(
        "Carta de suerte: " +
        casillaSuerte.getCarta().getNombre() +
        " se agrega en tu inventario de cartas."
      );
      jugadorActual.setCartas(casillaSuerte.getCarta());
    }
  }
}
