package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.Jugadores.Jugador;

public class MenuJuegoInicio extends Menu {

  Jugador jugador1;
  Jugador jugador2;

  public MenuJuegoInicio(Jugador jugador1, Jugador jugador2) {
    this.jugador1 = jugador1;
    this.jugador2 = jugador2;
  }

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

  public Jugador determinarTurno() {
    return this.jugador1.getTurno() ? this.jugador1 : this.jugador2;
  }
}
