package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Acciones.EntradaSalidaCarcel;
import com.mycompany.megapoly.CartasSuerte.CartaSuerte;
import com.mycompany.megapoly.Casillas.Carcel;
import com.mycompany.megapoly.Casillas.Casilla;
import com.mycompany.megapoly.Casillas.CasillaParking;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Casillas.CasillaSuerte;
import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Tablero;
import com.mycompany.megapoly.Sonido.SonidoCarcel;
import com.mycompany.megapoly.Sonido.SonidoPagar;
import com.mycompany.megapoly.Sonido.SonidoParking;
import com.mycompany.megapoly.Sonido.SonidoSuerte;
import java.util.Scanner;

/*
 * Clase que se encarga de crear el menu de opciones de casilla
 * @see Menu
 */
public class MenuJuegoOpcionesCasilla extends Menu {

  private SonidoCarcel sonido = new SonidoCarcel();

  private SonidoPagar sonidoPagar = new SonidoPagar();

  private SonidoSuerte sonidoSuerte = new SonidoSuerte();

  private SonidoParking sonidoParking = new SonidoParking();

  private Casilla casillaActual;

  private Tablero tablero;

  private Jugador jugadorActual;

  private Scanner scanner;

  /*
   * Constructor de la clase
   * @param jugadorActual Jugador actual
   * @param scanner Scanner para leer datos por consola
   * @param tablero Tablero del juego
   */
  public MenuJuegoOpcionesCasilla(
    Jugador jugadorActual,
    Scanner scanner,
    Tablero tablero
  ) {
    this.jugadorActual = jugadorActual;
    this.scanner = scanner;
    this.tablero = tablero;
  }

  /*
   * Metodo que se encarga de mostrar las opciones de la casilla o cartas de suerte
   * @see Menu
   * @return void
   */
  public void opcionesSuerteCompraPropiedad() {
    tablero.mostrarTablero();
    this.mostrarCasillas();
  }

  /*
   * Metodo que se encarga de mostrar las opciones de la casilla o cartas de suerte
   * @see Menu
   * @return void
   */
  private void mostrarCasillas() {
    tablero.mostrarTablero();
    this.obtenerCasilla();
    System.out.println(" ");

    if (this.casillaActual instanceof CasillaPropiedad) {
      ConsoleHelpers.printCentrado(
        "Has caido en la casilla: " + this.casillaActual.getNombre()
      );
      this.casillaPropiedad();
    }
    if (this.casillaActual instanceof CasillaSuerte) {
      ConsoleHelpers.printCentrado(
        "Has caido en la casilla: " + this.casillaActual.getNombre()
      );
      this.casillaSuerte();
    }
    if (this.casillaActual instanceof Carcel) {
      ConsoleHelpers.printCentrado(
        "Estas en alcalameco, saca un 5 para salir. "
      );
      this.casillaCarcel();
    }
    if (this.casillaActual instanceof CasillaParking) {
      sonidoParking.reproducir();
      System.out.println(" ");
      ConsoleHelpers.printCentrado(
        "Has caido en la casilla: " + this.casillaActual.getNombre()
      );
      ConsoleHelpers.printCentrado("No ocurre nada en la casilla de Parking");
    }
  }

  /*
   * Metodo que se encarga de obtener la casilla actual
   * @return void
   */
  private void obtenerCasilla() {
    int posicion = this.jugadorActual.getFicha().getPosicion();
    this.casillaActual = this.tablero.getCasillas()[posicion];
  }

  /*
   * Metodo que se encarga de mostrar las opciones de la casilla propiedad
   * @return void
   */
  private void casillaPropiedad() {
    String propietario =
      ((CasillaPropiedad) casillaActual).getPropiedad()
        .getPropietario()
        .getNombre();
    boolean esDelBanco = propietario.equals("Banco");
    int precio =
      ((CasillaPropiedad) casillaActual).getPropiedad().getPrecioCompra();
    System.out.println(" ");
    if (esDelBanco) {
      ConsoleHelpers.printCentrado("Precio: " + precio);
      System.out.println(" ");
      ConsoleHelpers.printCentrado("No tiene dueño");
      System.out.println(" ");
      this.menuComprarCasilla();
    } else {
      System.out.println(" ");
      ConsoleHelpers.printCentrado("Dueño: " + propietario);
      System.out.println(" ");
      this.menuPagasPorCasilla();
    }
  }

  /*
   * Metodo que se encarga de mostrar las opciones de la casilla carcel
   * @return void
   */
  private void casillaCarcel() {
    sonido.reproducir();
    EntradaSalidaCarcel.entrarCarcel(this.jugadorActual);
    System.out.println(" ");
  }

  /*
   * Metodo que se encarga de comprar la casilla
   * @return void
   */
  private void menuComprarCasilla() {
    if (this.casillaActual instanceof CasillaPropiedad) {
      CasillaPropiedad casillaPropiedad = (CasillaPropiedad) this.casillaActual;
      MenuJuegoOpcionesCompra opcionesCompra = new MenuJuegoOpcionesCompra(
        this.scanner,
        this.jugadorActual,
        casillaPropiedad
      );
      opcionesCompra.menuCompraPropiedad();
    }
  }

  /*
   * Metodo que se encarga de pagar el alquiler de la casilla
   * @return void
   */
  private void menuPagasPorCasilla() {
    if (this.casillaActual instanceof CasillaPropiedad) {
      CasillaPropiedad casillaPropiedad = (CasillaPropiedad) this.casillaActual;
      MenuJuegoOpcionesAlquiler opcionesAlquiler = new MenuJuegoOpcionesAlquiler(
        this.jugadorActual,
        casillaPropiedad
      );
      sonidoPagar.reproducir();
      opcionesAlquiler.pagasAlquiler();
    }
  }

  /*
   * Metodo que se encarga de mostrar las opciones de la casilla suerte, obtener la carta y agregarla al inventario
   * @return void
   */
  private void casillaSuerte() {
    CasillaSuerte casillaSuerte = (CasillaSuerte) this.casillaActual;
    sonidoSuerte.reproducir();
    casillaSuerte.setCarta();
    CartaSuerte cartaConseguida = casillaSuerte.getCarta();
    String nombreCarta = cartaConseguida.getNombre();
    System.out.println("");
    ConsoleHelpers.printCentrado(
      "Carta de suerte: " +
      nombreCarta +
      " se agrega en tu inventario de cartas."
    );
    System.out.println(" ");
    System.out.println(" ");
    jugadorActual.setCartas(cartaConseguida);
  }
}
