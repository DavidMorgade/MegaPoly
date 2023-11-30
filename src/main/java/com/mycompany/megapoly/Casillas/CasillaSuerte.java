package com.mycompany.megapoly.Casillas;

import com.mycompany.megapoly.CartasSuerte.CartaDonar;
import com.mycompany.megapoly.CartasSuerte.CartaEvitarCarcel;
import com.mycompany.megapoly.CartasSuerte.CartaSuerte;
import com.mycompany.megapoly.CartasSuerte.CartaVolver;

public class CasillaSuerte extends Casilla {

  final int NUMERO_TOTAL_CARTAS = 3;

  private CartaSuerte carta;

  public CasillaSuerte(char tipo) {
    super(tipo);
  }

  public CartaSuerte getCarta() {
    return this.carta;
  }

  public void setCarta() {
    this.carta = setCartaDeManeraAleatoria();
  }

  private CartaSuerte setCartaDeManeraAleatoria() {
    int numeroAleatorio = (int) (Math.random() * NUMERO_TOTAL_CARTAS + 1);
    switch (numeroAleatorio) {
      case 1:
        return new CartaVolver();
      case 2:
        return new CartaEvitarCarcel();
      case 3:
        return new CartaDonar();
      default:
        return null;
    }
  }
}
