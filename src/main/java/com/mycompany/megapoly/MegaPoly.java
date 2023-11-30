/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.megapoly;

import com.mycompany.megapoly.Materiales.Ficha;
import com.mycompany.megapoly.Tablero.Tablero;

/**
 *
 * @author david
 */
public class MegaPoly {

  public static void main(String[] args) {
    Ficha fichaRoja = new Ficha();
    Ficha fichaAzul = new Ficha();
    

    Tablero tablero = new Tablero(5, fichaRoja, fichaAzul);

    tablero.crearTablero();

    tablero.mostrarTablero();

    fichaRoja.avanzar(tablero, 5);

    fichaAzul.avanzar(tablero, 4);
  }
}
