package com.mycompany.megapoly.CartasSuerte;

import com.mycompany.megapoly.Acciones.EntradaSalidaCarcel;
import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import org.apache.commons.lang3.StringUtils;

public class CartaEvitarCarcel extends CartaSuerte {

  public CartaEvitarCarcel() {
    super("Evitar Carcel", "Si estas en la carcel, sales de ella");
  }

  public void efecto(Jugador jugadorEnPosesion, Jugador jugadorEnemigo) {
    System.out.println(
      StringUtils.center(
        "Sobornas al guardia con un par de cajetillas de malboro de contrabando y sales de la carcel",
        100
      )
    );
    EntradaSalidaCarcel.salirCarcel(jugadorEnPosesion);
    ConsoleHelpers.presionaEnterParaContinuar();
  }
}
