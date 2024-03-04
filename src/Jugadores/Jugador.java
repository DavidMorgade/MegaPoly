package Jugadores;


import CartasSuerte.CartaSuerte;
import Comprables.Comprable;
import Interfaces.ActualizarPosicionCallBack;
import Interfaz.Componentes.CustomJDialog;
import Materiales.Ficha;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Clase que se encarga de crear los jugadores
 * @see Ficha
 * @see CartaSuerte
 * @see Comprable
 *
 */
public class Jugador implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private boolean carcel = false;

    private static final int w = 100;

    private String nombre;

    private boolean turno;

    private int megaMonedas;

    // lista de cartas de suerte de cada jugador
    private List<CartaSuerte> cartas = new ArrayList<CartaSuerte>();

    // lista de propiedades de cada jugador
    private List<Comprable> comprables = new ArrayList<Comprable>();

    // ficha de cada jugador
    private Ficha ficha;

    /*
     * Constructor de la clase
     * @param nombre Nombre del jugador
     * @param turno Turno del jugador
     * @param ficha Ficha del jugador
     */
    public Jugador(String nombre, boolean turno, Ficha ficha) {
        this.nombre = nombre;
        this.turno = turno;
        this.megaMonedas = 100;
        this.ficha = ficha;
        this.cartas = new ArrayList<CartaSuerte>();
        this.comprables = new ArrayList<Comprable>();
    }

    /*
     * Constructor de la clase
     * @param ficha Ficha del jugador
     * @see Ficha
     */
    public Jugador(String nombre, Ficha ficha) {
        this.ficha = ficha;
        this.nombre = nombre;
        this.megaMonedas = 100;
    }

    // Constructor del jugador banco
    public Jugador() {
        this.nombre = "Banco";
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getTurno() {
        return this.turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public int getMegaMonedas() {
        return this.megaMonedas;
    }

    public void setMegaMonedas(int megaMonedas) {
        this.megaMonedas = megaMonedas;
    }

    public Ficha getFicha() {
        return this.ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public List<CartaSuerte> getCartas() {
        return this.cartas;
    }

    /*
     * Metodo que se encarga de usar las cartas de suerte de cada jugador
     * @param scanner Scanner
     * @param jugadorEnemigo Jugador enemigo
     * @return boolean
     */
    public boolean usarCartas(Scanner scanner, Jugador jugadorEnemigo) {

        int index = scanner.nextInt();
        // Si el jugador no quiere usar ninguna carta
        if (index == -1) {

            // Si el jugador quiere usar una carta
        } else {
            this.usarCarta(index, jugadorEnemigo);
        }
        return true;
    }

    public void setCartas(CartaSuerte carta) {
        this.cartas.add(carta);
    }

    public void setCartasTotales(List<CartaSuerte> cartas) {
        for (CartaSuerte carta : cartas) {
            this.cartas.add(carta);
        }
    }

    /*
     * Metodo que se encarga de usar las cartas de suerte de cada jugador
     * @param index Indice de la carta
     * @param jugadorEnemigo Jugador enemigo
     * @see CartaSuerte
     * @see Jugador
     */
    public void usarCarta(int index, Jugador jugadorEnemigo) {
        this.cartas.get(index).efecto(this, jugadorEnemigo);
        this.cartas.remove(index);
    }

    public void mostrarCartasSuerte(Jugador jugadorEnemigo, ActualizarPosicionCallBack callBack) {
        JComboBox<CartaSuerte> boxCartas = new JComboBox<CartaSuerte>();
        JLabel descripcionCarta = new JLabel();
        JButton botonUsarCarta = new JButton("Usar carta");
        for (CartaSuerte carta : this.cartas) {
            boxCartas.addItem(carta);
            descripcionCarta.setText(carta.getDescripcion());
        }
        JDialog dialog = new JDialog();
        dialog.setTitle("Cartas de suerte");
        dialog.setSize(600, 300);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(null);
        boxCartas.setBounds(50, 100, 200, 50);
        descripcionCarta.setBounds(50, 200, 500, 50);
        botonUsarCarta.setBounds(300, 100, 200, 50);
        if (this.cartas.size() == 0) {
            new CustomJDialog(null, "No tienes cartas de suerte", "Cartas de suerte");
        } else {
            dialog.add(boxCartas);
            dialog.add(botonUsarCarta);
        }
        dialog.add(descripcionCarta);
        boxCartas.addActionListener(e -> {
            CartaSuerte carta = (CartaSuerte) boxCartas.getSelectedItem();
            descripcionCarta.setText(carta.getDescripcion());
        });
        botonUsarCarta.addActionListener(e -> {
            CartaSuerte carta = (CartaSuerte) boxCartas.getSelectedItem();
            carta.efecto(this, jugadorEnemigo);
            this.cartas.remove(carta);
            dialog.dispose();
            callBack.onMostrarFinalizado();
        });
        dialog.setVisible(true);
    }

    public void cambiarTurno() {
        this.turno = !this.turno;
    }

    public void restarMegaMonedas(int cantidad) {
        this.megaMonedas -= cantidad;
    }

    public void sumarMegaMonedas(int cantidad) {
        this.megaMonedas += cantidad;
    }

    public void setPropiedades(Comprable propiedad) {
        this.comprables.add(propiedad);
    }

    public void setPropiedadesTotales(List<Comprable> propiedades) {
        for (Comprable propiedad : propiedades) {
            this.comprables.add(propiedad);
        }
    }

    public void setCarcel(boolean carcel) {
        this.carcel = carcel;
        if (carcel) {
            JOptionPane.showMessageDialog(null, "Has caido en la carcel");
        }
    }

    public boolean getCarcel() {
        return this.carcel;
    }

    public List<Comprable> getPropiedades() {
        return this.comprables;
    }


}
