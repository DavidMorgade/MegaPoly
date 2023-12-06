package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Casillas.Casilla;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Casillas.CasillaSuerte;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Tablero;
import java.util.Scanner;

public class MenuJuego extends Menu {

  Scanner scanner = new Scanner(System.in);

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
    Jugador jugadorTurno = Inicio.determinarTurno();
    Inicio.mostrarTurno(jugadorTurno);
    MenuJuegoOpcionesPrincipales OpcionesPrincipales = new MenuJuegoOpcionesPrincipales(
      jugadorTurno,
      scanner,
      tablero
    );
    do {
      usaCartas = OpcionesPrincipales.mostrarCartasOTirarDado();
    } while (usaCartas);
    Casilla casillaActual = this.obtenerCasilla(tablero, jugadorTurno);
    this.mostrarCasilla(casillaActual, jugadorTurno);
    if (casillaActual instanceof CasillaPropiedad) {
      CasillaPropiedad casillaPropiedad = (CasillaPropiedad) casillaActual;
      MenuJuegoOpcionesCompra opcionesCompra = new MenuJuegoOpcionesCompra(
        scanner,
        jugadorTurno,
        casillaPropiedad
      );
      opcionesCompra.menuCompraPropiedad();
    }
    this.cambiarTurno(jugador1, jugador2);
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
