package com.mycompany.megapoly.Tablero;

public class Suerte extends Casilla {
    
    private String nombre;

    private String descripcion;

    public Suerte(int posicion, char tipo, String nombre, String descripcion) {
        super(posicion, tipo);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

}
