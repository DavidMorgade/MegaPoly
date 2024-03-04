package Casillas;

import Interfaces.ActualizarPosicionCallBack;
import Interfaz.Componentes.CustomJDialog;
import Interfaz.Componentes.JDialogPropiedades;
import Interfaz.Componentes.RoundedButton;
import Jugadores.Jugador;
import Sonido.SonidoPropiedad;

/*
 * Clase que se encarga de crear las casillas de propiedad del tablero
 * @see Casilla
 */
public class CasillaPropiedad extends Casilla {

    private SonidoPropiedad sonidoPropiedad;

    private Jugador propietario;

    /*
     * Constructor de la clase
     * @param tipo Tipo de casilla
     * @param nombre Nombre de la casilla
     * @param propiedad Propiedad que se va a crear
     */
    public CasillaPropiedad(char tipo, String nombre) {
        super(tipo, nombre);
        this.propietario = new Jugador();
    }

    public void sonarSonido() {
        sonidoPropiedad = new SonidoPropiedad();
        sonidoPropiedad.reproducir();
    }

    public void evaluarPropiedad(Jugador jugadorActual, ActualizarPosicionCallBack callBack) {
        if (this.propietario.getNombre().equals("Banco")) {
            JDialogPropiedades ventana = new JDialogPropiedades(null, "¿Deseas comprar la propiedad " + this.getNombre() + "?", "Compra");
            ventana.setVisible(true);
            boolean resultado = ventana.getResult();
            // TODO: evaluar compra y resto de condiciones
        }
    }
}
