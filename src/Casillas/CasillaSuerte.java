package Casillas;

import CartasSuerte.CartaDonar;
import CartasSuerte.CartaEvitarCarcel;
import CartasSuerte.CartaSuerte;
import CartasSuerte.CartaVolver;
import Sonido.SonidoSuerte;

/*
 * Clase que se encarga de crear las casillas de suerte del tablero
 * @see Casilla
 */
public class CasillaSuerte extends Casilla {

    // Numero total de cartas de suerte
    final int NUMERO_TOTAL_CARTAS = 3;

    SonidoSuerte sonidoSuerte;
    private CartaSuerte carta;

    /*
     * Constructor de la clase
     * @param tipo Tipo de casilla
     * @param nombre Nombre de la casilla
     */
    public CasillaSuerte(char tipo, String nombre) {
        super(tipo, nombre);
    }

    public CartaSuerte getCarta() {
        return this.carta;
    }

    public void setCarta() {
        this.carta = setCartaDeManeraAleatoria();
    }

    public void sonarSonido() {
        sonidoSuerte = new SonidoSuerte();
        sonidoSuerte.reproducir();
    }

    /*
     * Metodo que se encarga de crear una carta de manera aleatoria
     * @return Carta de suerte
     */
    private CartaSuerte setCartaDeManeraAleatoria() {
        int numeroAleatorio = (int) (Math.random() * NUMERO_TOTAL_CARTAS + 1);
        switch (numeroAleatorio) {
            case 1:
                return new CartaVolver();
            case 2:
                return new CartaEvitarCarcel();
            case 3:
                return new CartaDonar();
            default:
                return null;
        }
    }
}
