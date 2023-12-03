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
    for (int i = 0; i < tamanioLado; i++) {
      for (int j = 0; j < tamanioLado; j++) {
        int indice = i * tamanioLado + j;
        if (
          (i == 0 || i == tamanioLado - 1 || j == 0 || j == tamanioLado - 1) &&
          !(i > 0 && i < tamanioLado - 1 && j > 0 && j < tamanioLado - 1)
        ) {
          if (
            fichaRoja.getPosicion() == fichaAzul.getPosicion() &&
            indice == fichaRoja.getPosicion()
          ) {
            System.out.print(
              "\u001B[32m" + // Cambié a verde (32)
              " " +
              casillas[indice].getTipo() +
              " " +
              "\u001B[0m"
            );
          } else if (indice == fichaAzul.getPosicion()) {
            System.out.print(
              "\u001B[34m" +
              " " +
              casillas[indice].getTipo() +
              " " +
              "\u001B[0m"
            );
          } else if (indice == fichaRoja.getPosicion()) {
            System.out.print(
              "\u001B[31m" +
              " " +
              casillas[indice].getTipo() +
              " " +
              "\u001B[0m"
            );
          } else if (casillas[indice] instanceof CasillaPropiedad) {
            Jugador propietario =
              ((CasillaPropiedad) casillas[indice]).getPropiedad()
                .getPropietario();
            if (propietario.getNombre().equals("Banco")) {
              System.out.print(" " + casillas[indice].getTipo() + " ");
            } else if (propietario.equals(fichaRoja.getJugador())) {
              System.out.print(
                "\u001B[31m" +
                " " +
                casillas[indice].getTipo() +
                " " +
                "\u001B[0m"
              );
            } else if (propietario.equals(fichaAzul.getJugador())) {
              System.out.print(
                "\u001B[34m" +
                " " +
                casillas[indice].getTipo() +
                " " +
                "\u001B[0m"
              );
            }
          } else {
            System.out.print(" " + casillas[indice].getTipo() + " ");
          }
        } else {
          System.out.print("   "); // Espacio para las casillas del centro
        }
      }
      System.out.println();
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
}
