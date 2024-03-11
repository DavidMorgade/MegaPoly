package Casillas;

import Interfaces.ActualizarPosicionCallBack;
import Interfaz.Componentes.CustomJDialog;
import Jugadores.Jugador;
import Sonido.SonidoPagar;
import Sonido.SonidoSuerte;

public class CasillaAleatoria extends Casilla {

    private transient SonidoPagar sonidoPagar;
    private transient SonidoSuerte sonidoSuerte;

    public CasillaAleatoria(char tipo, String nombre) {
        super(tipo, nombre);
    }

    private void pagarBoda(Jugador jugadorActual, Jugador jugadorEnemigo) {
        int precioBoda = 5;
        new CustomJDialog(null, "Es la boda de " + jugadorEnemigo.getNombre() + " le pagas " + precioBoda + " MM de regalo.", "Boda - Casilla Aleatoria");
        jugadorActual.restarMegaMonedas(precioBoda);
        jugadorEnemigo.sumarMegaMonedas(precioBoda);
    }

    private void pagarCumpleanios(Jugador jugadorActual, Jugador jugadorEnemigo) {
        int precioCumpleaños = 10;
        new CustomJDialog(null, "Es el cumpleaños de " + jugadorEnemigo.getNombre() + " le pagas " + precioCumpleaños + " MM de regalo.", "Cumpleaños - Casilla Aleatoria");
        jugadorActual.restarMegaMonedas(precioCumpleaños);
        jugadorEnemigo.sumarMegaMonedas(precioCumpleaños);
    }

    private void pagarCambioRuedas(Jugador jugadorActual, Jugador jugadorEnemigo) {
        int precioCambioRuedas = 15;
        new CustomJDialog(null, "Se te han pinchado las ruedas, pagas " + precioCambioRuedas + " MM por el cambio.", "Cambio de ruedas - Casilla Aleatoria");
        jugadorActual.restarMegaMonedas(precioCambioRuedas);
    }

    private void pagarMultas(Jugador jugadorActual, Jugador jugadorEnemigo) {
        int precioMultas = 20;
        new CustomJDialog(null, "Has cometido una infracción, pagas " + precioMultas + " MM de multa.", "Multa - Casilla Aleatoria");
        jugadorActual.restarMegaMonedas(precioMultas);
    }

    private void ganasQuiniela(Jugador jugadorActual, Jugador jugadorEnemigo) {
        int premioQuiniela = 25;
        new CustomJDialog(null, "Has ganado la quiniela, recibes " + premioQuiniela + " MM de premio.", "Quiniela - Casilla Aleatoria");
        jugadorActual.sumarMegaMonedas(premioQuiniela);
    }

    private void paguitaDePredroSanchez(Jugador jugadorActual, Jugador jugadorEnemigo) {
        int paguita = 30;
        new CustomJDialog(null, "Te ha llegado la paguita de Pedro Sánchez, recibes " + paguita + " MM de premio.", "Paguita - Casilla Aleatoria");
        jugadorActual.sumarMegaMonedas(paguita);
    }

    private void vueltaAEmpezar(Jugador jugadorActual, Jugador jugadorEnemigo) {
        new CustomJDialog(null, "Vuelves a la casilla de salida. Sin cobrar", "Vuelta a empezar - Casilla Aleatoria");
        jugadorActual.getFicha().setPosicion(0);
    }

    public void efectoAleatorio(Jugador jugadorActual, Jugador jugadorEnemigo, ActualizarPosicionCallBack callback) {
        int aleatorio = (int) (Math.random() * 7);
        sonidoPagar = new SonidoPagar();
        sonidoSuerte = new SonidoSuerte();
        switch (aleatorio) {
            case 0:
                sonidoPagar.reproducir();
                pagarBoda(jugadorActual, jugadorEnemigo);
                break;
            case 1:
                sonidoPagar.reproducir();
                pagarCumpleanios(jugadorActual, jugadorEnemigo);
                break;
            case 2:
                sonidoPagar.reproducir();
                pagarCambioRuedas(jugadorActual, jugadorEnemigo);
                break;
            case 3:
                sonidoPagar.reproducir();
                pagarMultas(jugadorActual, jugadorEnemigo);
                break;
            case 4:
                sonidoSuerte.reproducir();
                ganasQuiniela(jugadorActual, jugadorEnemigo);
                break;
            case 5:
                sonidoSuerte.reproducir();
                paguitaDePredroSanchez(jugadorActual, jugadorEnemigo);
                break;
            case 6:
                sonidoPagar.reproducir();
                vueltaAEmpezar(jugadorActual, jugadorEnemigo);
                break;
        }
        callback.onMostrarFinalizado();
    }

}
