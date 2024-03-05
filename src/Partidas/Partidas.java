package Partidas;

import java.io.*;

public class Partidas {

    private static final String DIRECTORIO = "/Partidas/";

    public static void guardarPartida(Serializable Jugador, Serializable Tablero, String nombrePartida) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(nombrePartida + ".dat"));
            oos.writeObject(Jugador);
            oos.writeObject(Tablero);
        } catch (Exception e) {
            System.out.println("Error al guardar la partida");
            System.out.println(e.toString());
        }
    }

    public static Object cargarPartida(String nombrePartida) {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(nombrePartida));
            return ois.readObject();
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
