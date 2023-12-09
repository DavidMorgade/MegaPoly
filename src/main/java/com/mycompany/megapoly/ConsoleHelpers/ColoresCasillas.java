package com.mycompany.megapoly.ConsoleHelpers;

public class ColoresCasillas {

  public static void imprimirCasillaVerde(char tipoCasilla) {
    System.out.print(
      ConsoleColor.GREEN_BOLD +
      "           " +
      tipoCasilla +
      "           " +
      ConsoleColor.RESET
    );
  }

  public static void imprimirCasillaAzul(char tipoCasilla) {
    System.out.print(
      ConsoleColor.BLUE_BOLD +
      "           " +
      tipoCasilla +
      "           " +
      ConsoleColor.RESET
    );
  }

  public static void imprimirCasillaRoja(char tipoCasilla) {
    System.out.print(
      ConsoleColor.RED_BOLD +
      "           " +
      tipoCasilla +
      "           " +
      ConsoleColor.RESET
    );
  }

  public static void imprimirCasillaNormal(char tipoCasilla) {
    System.out.print("           " + tipoCasilla + "           ");
  }

  public static void imprimirPropiedadBanco(char tipoCasilla) {
    System.out.print(
      "           " +
      ConsoleColor.WHITE_UNDERLINED +
      tipoCasilla +
      ConsoleColor.RESET +
      "           "
    );
  }

  public static void imprimirCasillaFondoRojo(char tipoCasilla) {
    System.out.print(
      "           " +
      ConsoleColor.RED_BACKGROUND +
      tipoCasilla +
      ConsoleColor.RESET +
      "           "
    );
  }

  public static void imprimirCasilaFondoAzul(char tipoCasilla) {
    System.out.print(
      "           " +
      ConsoleColor.BLUE_BACKGROUND +
      tipoCasilla +
      ConsoleColor.RESET +
      "           "
    );
  }
}
