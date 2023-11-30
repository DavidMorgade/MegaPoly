package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Dado;
import com.mycompany.megapoly.Materiales.Tablero;
import java.util.Scanner;

public class MenuJuego {

  Scanner scanner = new Scanner(System.in);

  private boolean salir = false;

  private int opcion;

  private Dado dado = new Dado();

  public MenuJuego(Jugador jugador1, Jugador jugador2, Tablero tablero) {
    jugador1.setTurno(true);
    jugador2.setTurno(false);

    tablero.crearTablero();
    while (!salir) {
      Jugador jugadorTurno = this.determinarTurno(jugador1, jugador2);
      this.mostrarTurno(jugadorTurno);
      this.mostrarOpciones();
      this.mostrarCartasOTirarDado(jugadorTurno, tablero);
      this.cambiarTurno(jugador1, jugador2);
    }
  }

  private void mostrarTurno(Jugador jugadorTurno) {}

  private void mostrarOpciones() {
    System.out.println("1. Tirar dado");
    System.out.println("2. Ver cartas de suerte");
    System.out.println("3. Salir");
    opcion = scanner.nextInt();
  }

  private void tirarDado() {
    dado.setNumeroAleatorio();
  }

  private void mostrarCartas(Jugador jugador, Tablero tablero) {
    System.out.println("Cartas de suerte: ");
    jugador.getCartas();
    System.out.println(" ");
    tablero.mostrarTablero();
  }

  private void mostrarCartasOTirarDado(Jugador jugadorTurno, Tablero tablero) {
    switch (this.opcion) {
      case 1:
        this.tirarDado();
        jugadorTurno.getFicha().avanzar(tablero, dado.getNumero());
        break;
      case 2:
        this.mostrarCartas(jugadorTurno, tablero);
        break;
      case 3:
        salir = true;
        return;
      default:
        System.out.println("Opcion no valida");
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
}
