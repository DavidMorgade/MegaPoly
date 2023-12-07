package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Acciones.Comprar;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Jugadores.Jugador;
import java.util.Scanner;

public class MenuJuegoOpcionesCompra extends Menu {

  Scanner scanner;

  Jugador jugadorTurno;

  CasillaPropiedad casillaPropiedad;

  private Comprar comprar = new Comprar();

  private int opcionCompra;

  public MenuJuegoOpcionesCompra(
    Scanner scanner,
    Jugador jugadorTurno,
    CasillaPropiedad casillaPropiedad
  ) {
    this.scanner = scanner;
    this.jugadorTurno = jugadorTurno;
    this.casillaPropiedad = casillaPropiedad;
  }

  public void menuCompraPropiedad() {
    if (
      this.casillaPropiedad.getPropiedad()
        .getPropietario()
        .getNombre()
        .equals("Banco")
    ) {
      System.out.println("");
      this.mostrarOpcionesCompra();
      switch (this.opcionCompra) {
        case 1:
          comprar.comprarPropiedad(
            this.jugadorTurno,
            this.casillaPropiedad.getPropiedad()
          );
          break;
        case 2:
          this.printCentradoEnConsola(
              "No se compro la propiedad, se seguira con el juego"
            );
          System.out.println(" ");
          break;
        default:
          break;
      }
    }
  }

  private void mostrarOpcionesCompra() {
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
}
