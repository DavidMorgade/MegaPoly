package CartasSuerte;

import Jugadores.Jugador;

/*
 * Clase que sirve de modelo para las cartas de suerte
 * @see Jugador donde se aplica el efecto de la carta
 * @see CartaDonar para ver un ejemplo de carta de suerte
 */
public class CartaSuerte implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;

    private String descripcion;

    /*
     * Constructor de la clase
     * @param nombre Nombre de la carta
     * @param descripcion Descripcion de la carta
     */
    public CartaSuerte(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    /*
     * Efecto de la carta
     * @param jugador Jugador que tiene la carta
     * @param jugadorEnemigo Jugador contrario
     * @return void
     */
    public void efecto(Jugador jugador, Jugador jugadorEnemigo) {
    }

    @Override
    public String toString() {
        return "Carta de suerte: " + this.nombre;
    }
}
