package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Jugadores.Jugador;

public class MenuJuegoInicio extends Menu {

  public MenuJuegoInicio(Jugador jugador1, Jugador jugador2) {}

  public void mostrarTurno(Jugador jugadorTurno) {
    this.printCentradoEnConsola("Turno de: " + jugadorTurno.getNombre());
    this.printCentradoEnConsola(
        "Ficha: " + jugadorTurno.getFicha().getColorFicha()
      );
    this.printCentradoEnConsola(
        "Mega monedas: " + jugadorTurno.getMegaMonedas()
      );
    this.printCentradoEnConsola(" ");
  }

  public Jugador determinarTurno(Jugador jugador1, Jugador jugador2) {
    return jugador1.getTurno() ? jugador1 : jugador2;
  }
}
