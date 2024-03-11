package Casillas;

import Interfaces.ActualizarPosicionCallBack;
import Interfaz.Componentes.CustomJDialog;
import Interfaz.Componentes.JDialogPropiedades;
import Interfaz.Componentes.RoundedButton;
import Jugadores.Jugador;
import Sonido.SonidoPagar;
import Sonido.SonidoPropiedad;

/*
 * Clase que se encarga de crear las casillas de propiedad del tablero
 * @see Casilla
 */
public class CasillaPropiedad extends Casilla {

    private transient SonidoPropiedad sonidoPropiedad;
    private transient SonidoPagar sonidoPagar;
    private final int precio;
    private int alquiler;

    private Jugador propietario;

    /*
     * Constructor de la clase
     * @param tipo Tipo de casilla
     * @param nombre Nombre de la casilla
     * @param propiedad Propiedad que se va a crear
     */
    public CasillaPropiedad(char tipo, String nombre, int precio) {
        super(tipo, nombre);
        this.precio = precio;
        this.alquiler = Math.round(precio / 2);
        this.propietario = new Jugador();
    }

    public void evaluarPropiedad(Jugador jugadorActual, ActualizarPosicionCallBack callBack) {
        if (this.propietario.getNombre().equals("Banco")) {
            this.sonidoPropiedad = new SonidoPropiedad();
            this.sonidoPropiedad.reproducir();
            JDialogPropiedades ventana = new JDialogPropiedades(null, "¿Deseas comprar la empresa " + this.getNombre() + "?", "Compra");
            ventana.setVisible(true);
            boolean resultado = ventana.getResult();
            if (resultado) {
                this.propietario = jugadorActual;
                jugadorActual.restarMegaMonedas(this.precio);
                new CustomJDialog(null, "Has comprado la propiedad " + this.getNombre() + " por " + this.precio + " MM", "Compra");
                callBack.onMostrarFinalizado();
            }
        } else if (this.propietario.equals(jugadorActual)) {
            new CustomJDialog(null, "Ya eres el propietario de esta empresa " + this.getNombre(), this.getNombre());
        } else {
            this.sonidoPagar = new SonidoPagar();
            this.sonidoPagar.reproducir();
            jugadorActual.restarMegaMonedas(this.alquiler);
            this.propietario.sumarMegaMonedas(this.alquiler);
            new CustomJDialog(null, "Has pagado " + this.alquiler + " MM de alquiler a " + this.propietario.getNombre(), "Alquiler");
            callBack.onMostrarFinalizado();
        }
    }

    public Jugador getPropietario() {
        return propietario;
    }
}
