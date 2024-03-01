package Sonido;

public class SonidoSuerte extends Sonidos {

    public SonidoSuerte() {
        super.ruta =
                getClass().getResource("/Sounds/SonidoSuerte.wav").getPath();
    }
}
