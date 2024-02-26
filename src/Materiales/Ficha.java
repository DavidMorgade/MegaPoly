package Materiales;

import Jugadores.Jugador;

import javax.swing.*;
import java.awt.*;

/*
 * Clase que se encarga de crear las fichas
 * @see Jugador
 */
public class Ficha extends JLabel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private int posicion;

    private String colorFicha;

    private Jugador jugador;

    /*
     * Constructor de la clase
     * @param posicion Posición de la ficha
     */
    public Ficha(String colorFicha) {
        this.posicion = 0;
        this.colorFicha = colorFicha;
        this.setPreferredSize(new Dimension(50, 50));
        //TODO
        // CONSEGUIR QUE SE PINTE LA FICHA EN EL TABLERO
        this.setOpaque(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.colorFicha.equals("Rojo") ? Color.RED : Color.BLUE);
        g.fillOval(0, 0, 50, 50);
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getColorFicha() {
        return this.colorFicha;
    }

    public void setColorFicha(String colorFicha) {
        this.colorFicha = colorFicha;
    }


}

