package Sonido;

public class SonidoPropiedad extends Sonidos {

    public SonidoPropiedad() {
        super.ruta =
                getClass().getResource("/Sounds/SonidoCaerPropiedad.wav").getPath();
    }
}