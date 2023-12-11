package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Acciones.Comprar;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Jugadores.Jugador;
import java.util.Scanner;

/*
 * Clase que se encarga de crear el menu de opciones de compra
 * @see Menu
 */
public class MenuJuegoOpcionesCompra extends Menu {

  Scanner scanner;

  Jugador jugadorTurno;

  CasillaPropiedad casillaPropiedad;

  private Comprar comprar = new Comprar();

  private int opcionCompra;

  /*
   * Constructor de la clase
   * @param jugadorTurno Jugador actual
   * @param casillaPropiedad Casilla de propiedad
   * @param scanner Scanner para leer datos por consola
   */
  public MenuJuegoOpcionesCompra(
    Scanner scanner,
    Jugador jugadorTurno,
    CasillaPropiedad casillaPropiedad
  ) {
    this.scanner = scanner;
    this.jugadorTurno = jugadorTurno;
    this.casillaPropiedad = casillaPropiedad;
  }

  /*
   * Metodo que muestra el menu de compra de propiedad
   * @see Menu
   * @return void
   */
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

  /*
   * Metodo que imprime las opciones de compra
   * @return void
   */
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
