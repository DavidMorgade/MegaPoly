package com.mycompany.megapoly.CartasSuerte;

public class CartaEvitarCarcel extends CartaSuerte {

  public CartaEvitarCarcel() {
    super("Evitar Carcel", "Si estas en la carcel, sales de ella");
  }

  public void efecto() {
    System.out.println(
      "Sobornas al guardia con un par de cajetillas de malboro de contrabando y sales de la carcel"
    );
  }
}
