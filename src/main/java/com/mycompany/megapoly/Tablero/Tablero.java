package com.mycompany.megapoly.Tablero;

public class Tablero {

  private int numeroCasillas;

  private Casilla[] casillas;

  private int longitud;

  public Tablero(int numeroCasillas) {
    this.longitud = (int) Math.ceil(Math.sqrt(numeroCasillas));
    this.casillas = new Casilla[numeroCasillas];
  }

  public void mostrarTablero() {
    for (int i = 0; i < longitud; i++) {
      for (int j = 0; j < longitud; j++) {
        if (i == 0 || i == longitud - 1 || j == 0 || j == longitud - 1) {
          // Imprimir letras solo en los bordes
          System.out.print(" " + casillas[i].getTipo() + " ");
        } else {
          // Imprimir espacio en el centro
          System.out.print("   ");
        }
      }
      System.out.println();
    }
  }

  public void crearTablero() {
    for (int i = 0; i < casillas.length; i++) {
      casillas[i] = new Casilla(i, 'N');
    }
  }
}
