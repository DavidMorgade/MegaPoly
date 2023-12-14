package com.mycompany.megapoly.Materiales;

import com.mycompany.megapoly.Casillas.Carcel;
import com.mycompany.megapoly.Casillas.Casilla;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Casillas.CasillaSalida;
import com.mycompany.megapoly.Casillas.CasillaSuerte;
import com.mycompany.megapoly.Comprables.Propiedad;
import com.mycompany.megapoly.ConsoleHelpers.ColoresCasillas;
import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;

/*
 * Clase que se encarga de crear el tablero del juego

 */
public class Tablero {

  private Casilla[] casillas;

  private Ficha fichaRoja;

  private Ficha fichaAzul;

  private int tamanioLado;

  /*
   * Constructor de la clase
   * @param tamanioLado Tamaño del tablero
   * @param fichaRoja Ficha del jugador rojo
   * @param fichaAzul Ficha del jugador azul
   */
  public Tablero(int tamanioLado, Ficha fichaRoja, Ficha fichaAzul) {
    this.tamanioLado = tamanioLado;
    this.casillas = new Casilla[tamanioLado * tamanioLado];
    this.fichaRoja = fichaRoja;
    this.fichaAzul = fichaAzul;
  }

  public int getTamanioLado() {
    return this.tamanioLado;
  }

  public Casilla[] getCasillas() {
    return this.casillas;
  }

  public char getTipoCasilla(int posicion) {
    return this.casillas[posicion].getTipo();
  }

  /*
   * Metodo que se encarga de mostrar el tablero por consola en forma de cuadrado
   * @return void
   */
  public void mostrarTablero() {
    ConsoleHelpers.limpiarConsola();
    int posicionRoja = fichaRoja.getPosicion(); // Obtenemos la posicion de la ficha roja
    int posicionAzul = fichaAzul.getPosicion(); // Obtenemos la posicion de la ficha azul
    boolean mismaPosicion = fichaRoja.getPosicion() == fichaAzul.getPosicion(); // Boolean que comprueba si las fichas estan en la misma posicion

    for (int i = 0; i < tamanioLado; i++) {
      for (int j = 0; j < tamanioLado; j++) {
        // Calculamos el indice de la casilla
        int indice = i * tamanioLado + j;
        // Obtenemos la casilla
        Casilla casilla = casillas[indice];
        // Obtenemos el tipo de casilla
        char tipoCasilla = casilla.getTipo();
        // Imprimimos la casilla para que forme un cuadrado en forma de tablero
        if (
          (i == 0 || i == tamanioLado - 1 || j == 0 || j == tamanioLado - 1) &&
          !(i > 0 && i < tamanioLado - 1 && j > 0 && j < tamanioLado - 1)
        ) {
          // Si la ficha roja y azul están en la misma posición, la imprimimos de color verde
          if (mismaPosicion && indice == fichaRoja.getPosicion()) {
            ColoresCasillas.imprimirCasillaVerde(tipoCasilla);
            // Si esta la ficha azul solamente la imprimimos de color azul
          } else if (indice == posicionAzul) {
            ColoresCasillas.imprimirCasillaAzul(tipoCasilla);
            // Si esta la ficha roja solamente la imprimimos de color rojo
          } else if (indice == posicionRoja) {
            ColoresCasillas.imprimirCasillaRoja(tipoCasilla);
            // Si la casilla es una propiedad
          } else if (casilla instanceof CasillaPropiedad) {
            // Obtenemos el propietario de la propiedad
            Jugador propietario =
              ((CasillaPropiedad) casilla).getPropiedad().getPropietario();
            // Si el propietario es el banco, la imprimimos normal
            if (propietario.getNombre().equals("Banco")) {
              ColoresCasillas.imprimirPropiedadBanco(tipoCasilla);
              // Si el propietario es el jugador rojo, la imprimimos de color rojo
            } else if (propietario.equals(fichaRoja.getJugador())) {
              ColoresCasillas.imprimirCasillaFondoRojo(tipoCasilla);
              // Si el propietario es el jugador azul, la imprimimos de color azul
            } else if (propietario.equals(fichaAzul.getJugador())) {
              ColoresCasillas.imprimirCasilaFondoAzul(tipoCasilla);
            }
            // Si no se cumple ninguna condicion anterior se imprime normal
          } else {
            ColoresCasillas.imprimirCasillaNormal(tipoCasilla);
          }
          // Espacio para las casillas del centro
        } else {
          System.out.print("                       ");
        }
      }
      System.out.println("");
      System.out.println("");
    }
    System.out.println("");
    System.out.println("");
  }

  /*
   * Metodo que se encarga de crear el tablero
   * @return void
   */
  public void crearTablero() {
    // Esquinas
    // Superior izquierda
    casillas[0] = new CasillaSalida('I', "Inicio");
    // Superior derecha
    casillas[4] = new Carcel('C', "Carcel");
    // Inferior derecha
    casillas[24] =
      new CasillaPropiedad(
        'G',
        "Google",
        new Propiedad(
          30,
          15,
          "Google Cadiz",
          "Google Cadiz, los trabajadores teletrabajan desde la playa"
        )
      );
    // Inferior izquierda
    casillas[20] = new Carcel('C', "Carcel");

    // lado superior
    casillas[1] =
      new CasillaPropiedad(
        'F',
        "Facebook",
        new Propiedad(
          10,
          1,
          "Facebook Madrid",
          "Facebook Madrid, los trabajadores no tienen para el alquiler pero mas o menos sobreviven"
        )
      );
    casillas[2] = new Casilla('P', null);
    casillas[3] =
      new CasillaPropiedad(
        'F',
        "Facebook",
        new Propiedad(
          15,
          5,
          "Facebook Cadiz",
          "Facebook Cadiz, los trabajadores no tienen para el alquiler pero mas o menos sobreviven"
        )
      );
    // lado derecho
    casillas[9] =
      new CasillaPropiedad(
        'F',
        "Facebook",
        new Propiedad(
          15,
          5,
          "Facebook Valencia",
          "Facebook Valencia funciona bastante bien pero libran en fallas"
        )
      );

    casillas[14] = new CasillaSuerte('S', "Suerte");
    casillas[19] =
      new CasillaPropiedad(
        'G',
        "Google",
        new Propiedad(
          25,
          10,
          "Google Barcelona",
          "Google Barcelona, importa empleados desde cualquier parte del mundo"
        )
      );
    // lado inferior
    casillas[23] =
      new CasillaPropiedad(
        'G',
        "Google",
        new Propiedad(
          30,
          15,
          "Google Valencia",
          "Google Valencia funciona bastante bien pero libran en fallas"
        )
      );

    casillas[22] = new Casilla('P', null);
    casillas[21] =
      new CasillaPropiedad(
        'N',
        "Netflix",
        new Propiedad(
          40,
          20,
          "Netflix Barcelona",
          "Netflix Barcelona la mayoria de los empleados usan HBO"
        )
      );
    // lado izquierdo
    casillas[15] =
      new CasillaPropiedad(
        'N',
        "Netflix",
        new Propiedad(
          50,
          25,
          "Netflix Cadiz",
          "Netflix Cadiz, ven las series piratas porque no pueden pagar la suscripcion"
        )
      );

    casillas[10] = new CasillaSuerte('S', "Suerte");
    casillas[5] =
      new CasillaPropiedad(
        'T',
        "Twitter",
        new Propiedad(
          80,
          30,
          "Twitter Ohio",
          "Twitter Ohio, no es tan malo pero el jefe es Elon Musk"
        )
      );
    // Centro (dejamos vacías)
    casillas[6] = new Casilla(' ', "");

    casillas[7] = new Casilla(' ', "");
    casillas[8] = new Casilla(' ', "");
    casillas[11] = new Casilla(' ', "");
    casillas[12] = new Casilla(' ', "");
    casillas[13] = new Casilla(' ', "");
    casillas[16] = new Casilla(' ', "");
    casillas[17] = new Casilla(' ', "");
    casillas[18] = new Casilla(' ', "");
  }
}
