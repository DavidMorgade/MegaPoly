package Sonido;

public class SonidoPagar extends Sonidos {

    public SonidoPagar() {
        super.ruta =
                getClass().getResource("/Sounds/SonidoPagar.wav").getPath();
    }
}
