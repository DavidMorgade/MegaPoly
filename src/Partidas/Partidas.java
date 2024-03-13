package Partidas;

import Jugadores.Jugador;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Partidas {

    private static final String DIRECTORIO = "partidas/";

    public static void guardarPartida(Serializable JugadorActual, Serializable JugadorSegundo, Serializable Tablero, String nombrePartida) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    Files.newOutputStream(Paths.get("partidas/" + nombrePartida + ".dat")));
            oos.writeObject(JugadorActual);
            oos.writeObject(JugadorSegundo);
            oos.writeObject(Tablero);
            System.out.println("Partida guardada");
            System.out.println(JugadorActual.toString());
            System.out.println(JugadorSegundo.toString());
            System.out.println(Tablero.toString());
        } catch (Exception e) {
            System.out.println("Error al guardar la partida");
            System.out.println(e.toString());
        }
    }

    public static Object[] cargarPartida(String nombrePartida) {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    Files.newInputStream(Paths.get("partidas/" + nombrePartida)));
            Serializable jugadorActual = (Serializable) ois.readObject();
            Serializable jugadorSegundo = (Serializable) ois.readObject();
            Serializable tablero = (Serializable) ois.readObject();
            return new Object[]{jugadorActual, jugadorSegundo, tablero};
        } catch (Exception e) {
            System.out.println("Error al cargar la partida");
            System.out.println(e.toString());
            return null;
        }
    }

    public static String[] listarPartidas() {
        File dir = new File(DIRECTORIO);
        String[] ficheros = dir.list();
        return ficheros;
    }
}
