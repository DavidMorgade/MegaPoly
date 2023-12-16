package com.mycompany.megapoly.Interfaz;

import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;

public class ReglasJuego {

  private final String REGLAS_JUEGO =
    "\r\n" + //
    "\r\n" + //
    "                                                               \r\n" + //
    " _____         _              _     _       __                 \r\n" + //
    "| __  |___ ___| |___ ___    _| |___| |   __|  |_ _ ___ ___ ___ \r\n" + //
    "|    -| -_| . | | .'|_ -|  | . | -_| |  |  |  | | | -_| . | . |\r\n" + //
    "|__|__|___|_  |_|__,|___|  |___|___|_|  |_____|___|___|_  |___|\r\n" + //
    "          |___|                                       |___|    \r\n" + //
    "\r\n" + //
    "";

  private final String REGLA_CARCEL =
    "1. Si caes en la casilla de la carcel, debes sacar un 5 para salir de ella. Si no lo sacas, pierdes el turno, podrás salir también si tienes una carta de \"Evitar Carcel\"";

  private final String REGLA_PASAR_POR_SALIDA =
    "2. Si pasas por la casilla de salida, recibes 20 MegaMonedas";

  private final String REGLA_PAGAR_ALQUILER =
    "3. Si caes en una casilla que tiene dueño, debes pagar el alquiler de la casilla";

  private final String REGLA_COMPRAR_PROPIEDAD =
    "4. Si caes en una casilla que no tiene dueño, puedes comprarla";

  private final String REGLA_EMPRESA_COMPLETA =
    "5. Si tienes todas las empresas de un color, puedes construir un hotel y cobrar el doble de alquiler";

  private final String REGLA_CARTAS_SUERTE =
    "6. Si caes en una casilla de carta de suerte, consigues una carta de suerte y puedes usarla cuando quieras";

  public ReglasJuego() {}

  /*
   * Metodo que se encarga de mostrar las reglas del juego
   * @return void
   */
  public void mostrarReglas() {
    System.out.println(REGLAS_JUEGO);
    System.out.println(" ");
    System.out.println(" ");
    System.out.println(this.REGLA_CARCEL);
    System.out.println(" ");
    System.out.println(this.REGLA_PASAR_POR_SALIDA);
    System.out.println(" ");
    System.out.println(this.REGLA_PAGAR_ALQUILER);
    System.out.println(" ");
    System.out.println(this.REGLA_COMPRAR_PROPIEDAD);
    System.out.println(" ");
    System.out.println(this.REGLA_EMPRESA_COMPLETA);
    System.out.println(" ");
    System.out.println(this.REGLA_CARTAS_SUERTE);
    System.out.println(" ");
    ConsoleHelpers.presionaEnterParaContinuar();
  }
}
