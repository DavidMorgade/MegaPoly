package com.mycompany.megapoly.Partidas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManejadorRecursos {

  public static final String DIRECTORIO_GUARDADO =
    "C:/Users/david/Documents/DAM/MegaPoly/MegaPoly/src/guardados";

  public static void guardar(Serializable objeto, String nombreArchivo) {
    try (
      ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream(nombreArchivo)
      )
    ) {
      oos.writeObject(objeto);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Object cargar(String nombreArchivo) {
    try (
      ObjectInputStream ois = new ObjectInputStream(
        Files.newInputStream(Paths.get(nombreArchivo))
      )
    ) {
      return ois.readObject();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void mostrarPartidasGuardadas() {
    File carpetaGuardado = new File(DIRECTORIO_GUARDADO);
    File[] archivosGuardados = carpetaGuardado.listFiles((dir, name) ->
      name.endsWith(".dat")
    );

    if (archivosGuardados.length == 0) {
      System.out.println("No hay partidas guardadas.");
    } else {
      System.out.println("Partidas guardadas:");
      for (File archivo : archivosGuardados) {
        System.out.println(archivo.getName());
      }
    }
  }
}
