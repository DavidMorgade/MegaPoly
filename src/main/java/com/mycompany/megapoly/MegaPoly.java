/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.megapoly;

import com.mycompany.megapoly.Interfaz.MenuInicio;
import com.mycompany.megapoly.Interfaz.MenuJuego;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Ficha;
import com.mycompany.megapoly.Materiales.Tablero;

/**
 *
 * @author david
 */
public class MegaPoly {

  public static void main(String[] args) {
    Ficha fichaUno = new Ficha();
    Ficha fichaDos = new Ficha();

    Jugador jugador1 = new Jugador(fichaUno);
    Jugador jugador2 = new Jugador(fichaDos);

    Tablero tablero = new Tablero(5, fichaUno, fichaDos);

    MenuInicio menuInicio = new MenuInicio(jugador1, jugador2);

    MenuJuego menuJuego = new MenuJuego(jugador1, jugador2, tablero);
  }
}
