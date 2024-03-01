package Sonido;

public class SonidoCarcel extends Sonidos {

    public SonidoCarcel() {
        super.ruta =
                getClass().getResource("/Sounds/SonidoCarcel.wav").getPath();
    }
}
