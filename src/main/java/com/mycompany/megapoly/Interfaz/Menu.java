package com.mycompany.megapoly.Interfaz;

import org.apache.commons.lang3.StringUtils;

public class Menu {

  protected void printCentradoEnConsola(String texto) {
    int w = 100;
    System.out.println(StringUtils.center(texto, w));
  }
}
