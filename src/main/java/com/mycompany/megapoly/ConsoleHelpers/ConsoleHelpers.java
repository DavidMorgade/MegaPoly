package com.mycompany.megapoly.ConsoleHelpers;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/*
 * Clase que ayuda a la impresion de consola
 */
public class ConsoleHelpers {

  /*
   * Metodo que limpia la consola
   */
  public static void limpiarConsola() {
    System.out.print("\033\143"); // Limpiamos la consola
  }

  /*
   * Metodo que ayuda a mantener al usuario en la consola, hasta que presione enter
   */
  public static void presionaEnterParaContinuar() {
    System.out.println(
      StringUtils.center("Presiona enter para continuar...", 100)
    );
    try {
      System.in.read();
    } catch (Exception e) {
      e.printStackTrace();
    }
    Scanner sc = new Scanner(System.in);
    sc.nextLine();
  }
}
