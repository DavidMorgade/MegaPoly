package com.mycompany.megapoly.Interfaz;

import org.apache.commons.lang3.StringUtils;

public class Menu {

  protected String mensajeBienvenida =
    "\r\n" + //
    "\r\n" + //
    "                                                                                 \r\n" + //
    " _____ _                     _   _               _____                     _     \r\n" + //
    "| __  |_|___ ___ _ _ ___ ___|_|_| |___    ___   |     |___ ___ ___ ___ ___| |_ _ \r\n" + //
    "| __ -| | -_|   | | | -_|   | | . | . |  | .'|  | | | | -_| . | .'| . | . | | | |\r\n" + //
    "|_____|_|___|_|_|\\_/|___|_|_|_|___|___|  |__,|  |_|_|_|___|_  |__,|  _|___|_|_  |\r\n" + //
    "                                                          |___|   |_|       |___|\r\n" + //
    "\r\n" + //
    "";
  protected String mensajeDespedida =
    "\r\n" + //
    "\r\n" + //
    "                                                                     \r\n" + //
    " _____             _                              __                 \r\n" + //
    "|   __|___ ___ ___|_|___ ___    ___ ___ ___    __|  |_ _ ___ ___ ___ \r\n" + //
    "|  |  |  _| .'|  _| | .'|_ -|  | . | . |  _|  |  |  | | | . | .'|  _|\r\n" + //
    "|_____|_| |__,|___|_|__,|___|  |  _|___|_|    |_____|___|_  |__,|_|  \r\n" + //
    "                               |_|                      |___|        \r\n" + //
    "\r\n" + //
    "";

  protected void printCentradoEnConsola(String texto) {
    int w = 100;
    System.out.println(StringUtils.center(texto, w));
  }
}
