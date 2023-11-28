/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.megapoly;

import com.mycompany.megapoly.Tablero.Tablero;

/**
 *
 * @author david
 */
public class MegaPoly {

  public static void main(String[] args) {
    Tablero tablero = new Tablero(25);

    tablero.crearTablero();

    tablero.mostrarTablero();
  }
}
