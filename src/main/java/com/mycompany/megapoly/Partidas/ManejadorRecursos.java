package com.mycompany.megapoly.Partidas;

import com.mycompany.megapoly.Casillas.Casilla;
import com.mycompany.megapoly.Casillas.CasillaPropiedad;
import com.mycompany.megapoly.Comprables.Comprable;
import com.mycompany.megapoly.Comprables.Propiedad;
import com.mycompany.megapoly.ConsoleHelpers.ConsoleHelpers;
import com.mycompany.megapoly.Jugadores.Jugador;
import com.mycompany.megapoly.Materiales.Ficha;
import com.mycompany.megapoly.Materiales.Tablero;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ManejadorRecursos {

  public static final String DIRECTORIO_GUARDADO =
    "C:/Users/david/Documents/DAM/MegaPoly/MegaPoly/src/guardadas";

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

  public static void mostrarPartidasGuardadas(
    Jugador jugadorTurno,
    Jugador jugadorEnemigo,
    Ficha fichaRoja,
    Ficha fichaAzul,
    Tablero tablero
  ) {
    File carpetaGuardado = new File(DIRECTORIO_GUARDADO);
    File[] archivosGuardados = carpetaGuardado.listFiles((dir, name) ->
      name.endsWith(".dat")
    );

    if (archivosGuardados.length == 0) {
      ConsoleHelpers.printCentrado("No hay partidas guardadas");
    } else {
      ConsoleHelpers.printCentrado("Seleccione una partida: (0 para salir))");
      for (int i = 0; i < archivosGuardados.length; i++) {
        ConsoleHelpers.printCentrado(
          (i + 1) + ". " + archivosGuardados[i].getName()
        );
      }
      Scanner sc = new Scanner(System.in);
      int opcion = sc.nextInt();
      if (opcion >= 1 && opcion <= archivosGuardados.length) {
        String nombreArchivo = archivosGuardados[opcion - 1].getName();
        System.out.println(nombreArchivo);
        GuardarPartida datos = (GuardarPartida) ManejadorRecursos.cargar(
          DIRECTORIO_GUARDADO + "/" + nombreArchivo
        );
        List<Comprable> comprablesJugador1 = datos.comprablesJugador1;
        List<Comprable> comprablesJugador2 = datos.comprablesJugador2;
        Casilla[] casillas = tablero.getCasillas();
        for (int i = 0; i < casillas.length; i++) {
          if (casillas[i] instanceof CasillaPropiedad) {
            CasillaPropiedad casillaPropiedad = (CasillaPropiedad) casillas[i];
            Propiedad propiedad = (Propiedad) casillaPropiedad.getPropiedad();
            if (comprablesJugador1.contains(propiedad)) {
              propiedad.setPropietario(datos.jugador1);
            } else if (comprablesJugador2.contains(propiedad)) {
              propiedad.setPropietario(datos.jugador2);
            }
          }
        }
        jugadorTurno.setNombre(datos.jugador1.getNombre());
        jugadorEnemigo.setNombre(datos.jugador2.getNombre());
        jugadorTurno.setFicha(datos.jugador1.getFicha());
        jugadorEnemigo.setFicha(datos.jugador2.getFicha());
        jugadorTurno.setCartasTotales(datos.jugador1.getCartas());
        jugadorEnemigo.setCartasTotales(datos.jugador2.getCartas());
        jugadorTurno.setPropiedadesTotales(datos.jugador1.getPropiedades());
        jugadorEnemigo.setPropiedadesTotales(datos.jugador2.getPropiedades());
        jugadorTurno.setMegaMonedas(datos.jugador1.getMegaMonedas());
        jugadorEnemigo.setMegaMonedas(datos.jugador2.getMegaMonedas());
        jugadorTurno.setCartasTotales(datos.jugador1.getCartas());
        jugadorEnemigo.setCartasTotales(datos.jugador2.getCartas());
        fichaRoja.setPosicion(datos.jugador1.getFicha().getPosicion());
        fichaAzul.setPosicion(datos.jugador2.getFicha().getPosicion());
      } else {
        System.out.println("No se cargara ninguna partida");
      }
    }
  }
}
