package com.mycompany.megapoly.Tablero;

import com.mycompany.megapoly.Ficha;

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
    casillas[24] = new StartUp('-', 400, 50);
    // Inferior izquierda
    casillas[20] = new Carcel('C');

    // lado superior
    casillas[1] = new Propiedad('F', 100);
    casillas[2] = new Propiedad('F', 150);
    casillas[3] = new Suerte('S');

    // lado derecho
    casillas[9] = new Propiedad('F', 200);
    casillas[14] = new Propiedad('G', 250);
    casillas[19] = new Propiedad('G', 350);

    // lado inferior
    casillas[23] = new Propiedad('G', 450);
    casillas[22] = new Propiedad('N', 2000);
    casillas[21] = new Propiedad('N', 2000);

    // lado izquierdo
    casillas[15] = new StartUp('-', 400, 50);
    casillas[10] = new Suerte('S');
    casillas[5] = new Propiedad('T', 500000);

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
