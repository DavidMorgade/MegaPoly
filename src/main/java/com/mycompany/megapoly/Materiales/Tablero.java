package com.mycompany.megapoly.Materiales;

import com.mycompany.megapoly.Casillas.Carcel;
import com.mycompany.megapoly.Casillas.Casilla;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Casillas.CasillaSalida;
import com.mycompany.megapoly.Casillas.CasillaStartUp;
import com.mycompany.megapoly.Casillas.CasillaSuerte;

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
    casillas[0] = new CasillaSalida('I');
    // Superior derecha
    casillas[4] = new Carcel('C');
    // Inferior derecha
    casillas[24] = new CasillaStartUp('-', 20, 5);
    // Inferior izquierda
    casillas[20] = new Carcel('C');

    // lado superior
    casillas[1] = new CasillaPropiedad('F', 10, 2);
    casillas[2] = new CasillaPropiedad('F', 12, 3);
    casillas[3] = new CasillaSuerte('S');

    // lado derecho
    casillas[9] = new CasillaPropiedad('F', 15, 5);
    casillas[14] = new CasillaPropiedad('G', 15, 5);
    casillas[19] = new CasillaPropiedad('G', 25, 10);

    // lado inferior
    casillas[23] = new CasillaPropiedad('G', 30, 15);
    casillas[22] = new CasillaPropiedad('N', 35, 15);
    casillas[21] = new CasillaPropiedad('N', 40, 20);

    // lado izquierdo
    casillas[15] = new CasillaStartUp('-', 20, 5);
    casillas[10] = new CasillaSuerte('S');
    casillas[5] = new CasillaPropiedad('T', 80, 30);

    // Centro (dejamos vacías)
    casillas[6] = new Casilla(' ');
    casillas[7] = new Casilla(' ');
    casillas[8] = new Casilla(' ');
    casillas[11] = new Casilla(' ');
    casillas[12] = new Casilla(' ');
    casillas[13] = new Casilla(' ');
    casillas[16] = new Casilla(' ');
    casillas[17] = new Casilla(' ');
    casillas[18] = new Casilla(' ');
  }
}
