package com.mycompany.megapoly.Materiales;

import com.mycompany.megapoly.Casillas.Carcel;
import com.mycompany.megapoly.Casillas.Casilla;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Casillas.CasillaSalida;
import com.mycompany.megapoly.Casillas.CasillaStartUp;
import com.mycompany.megapoly.Casillas.CasillaSuerte;
import com.mycompany.megapoly.Comprables.Propiedad;
import com.mycompany.megapoly.Comprables.StartUp;
import com.mycompany.megapoly.Jugadores.Jugador;

public class Tablero {

  private Casilla[] casillas;

  private Ficha fichaRoja;

  private Ficha fichaAzul;

  private int tamanioLado;

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

  public void mostrarTablero() {
    System.out.print("\033\143"); // Limpiamos la consola
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
            this.imprimirCasillaVerde(tipoCasilla);
            // Si esta la ficha azul solamente la imprimimos de color azul
          } else if (indice == posicionAzul) {
            this.imprimirCasillaAzul(tipoCasilla);
            // Si esta la ficha roja solamente la imprimimos de color rojo
          } else if (indice == posicionRoja) {
            this.imprimirCasillaRoja(tipoCasilla);
            // Si la casilla es una propiedad
          } else if (casilla instanceof CasillaPropiedad) {
            // Obtenemos el propietario de la propiedad
            Jugador propietario =
              ((CasillaPropiedad) casilla).getPropiedad().getPropietario();
            // Si el propietario es el banco, la imprimimos normal
            if (propietario.getNombre().equals("Banco")) {
              this.imprimirCasillaNormal(tipoCasilla);
              // Si el propietario es el jugador rojo, la imprimimos de color rojo
            } else if (propietario.equals(fichaRoja.getJugador())) {
              this.imprimirCasillaRoja(tipoCasilla);
              // Si el propietario es el jugador azul, la imprimimos de color azul
            } else if (propietario.equals(fichaAzul.getJugador())) {
              this.imprimirCasillaAzul(tipoCasilla);
            }
            // Si no se cumple ninguna condicion anterior se imprime normal
          } else {
            this.imprimirCasillaNormal(tipoCasilla);
          }
          // Espacio para las casillas del centro
        } else {
          System.out.print("                     ");
        }
      }
      System.out.println("");
      System.out.println("");
    }
  }

  public void crearTablero() {
    // Esquinas
    // Superior izquierda
    casillas[0] = new CasillaSalida('I', "Inicio");
    // Superior derecha
    casillas[4] = new Carcel('C', "Carcel");
    // Inferior derecha
    casillas[24] =
      new CasillaStartUp(
        '-',
        "StartUp",
        new StartUp(
          20,
          5,
          "StartUp India",
          "StartUp que se dedica a realizar codigo de dudosa calidad"
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
    casillas[2] =
      new CasillaPropiedad(
        'F',
        "Facebook",
        new Propiedad(
          12,
          3,
          "Facebook Barcelona",
          "Facebook Barcelona, importa empleados desde cualquier parte del mundo"
        )
      );
    casillas[3] = new CasillaSuerte('S', "Suerte");

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
    casillas[14] =
      new CasillaPropiedad(
        'G',
        "Google",
        new Propiedad(
          20,
          8,
          "Google Madrid",
          "Google Madrid, los trabajadores no tienen para el alquiler pero mas o menos sobreviven"
        )
      );
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
    casillas[22] =
      new CasillaPropiedad(
        'N',
        "Netflix",
        new Propiedad(
          35,
          15,
          "Netflix Madrid",
          "Netflix Madrid, a diferencia de la competencia, los empleados tienen subscripcion a Netflix"
        )
      );
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
      new CasillaStartUp(
        '-',
        "StartUp",
        new StartUp(
          20,
          5,
          "StartUp Marruecos",
          "StartUp dedicada exclusivamente en realizar codigo en el lenguaje de programación Objective-C para aplicaciones de Apple"
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

  private void imprimirCasillaNormal(char tipoCasilla) {
    System.out.print("          " + tipoCasilla + "          ");
  }

  private void imprimirCasillaVerde(char tipoCasilla) {
    System.out.print(
      "\u001B[32m" + "          " + tipoCasilla + "          " + "\u001B[0m"
    );
  }

  private void imprimirCasillaAzul(char tipoCasilla) {
    System.out.print(
      "\u001B[34m" + "          " + tipoCasilla + "          " + "\u001B[0m"
    );
  }

  private void imprimirCasillaRoja(char tipoCasilla) {
    System.out.print(
      "\u001B[31m" + "          " + tipoCasilla + "       " + "\u001B[0m"
    );
  }
}
