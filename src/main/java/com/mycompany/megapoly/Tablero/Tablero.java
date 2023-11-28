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
    casillas[0] = new Casilla(0, 'S');
    casillas[1] = new Propiedad(1, 'F', 100);
    casillas[2] = new Propiedad(2, 'F', 150);
    casillas[3] = new Propiedad(3, 'F', 250);
    casillas[4] = new Propiedad(4, 'G', 300);
    casillas[5] = new Propiedad(5, 'G', 400);
    casillas[6] = new Propiedad(6, 'G', 500);
    casillas[7] = new StartUp(7, 'E', 500, 50);
    casillas[8] = new Propiedad(8, 'A', 600);
    casillas[9] = new Propiedad(9, 'A', 700);
  }
}
