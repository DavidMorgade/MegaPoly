package Sonido;

public class SonidoParking extends Sonidos {

    public SonidoParking() {
        super.ruta =
                getClass().getResource("/Sounds/SonidoParking.wav").getPath();
    }
}
