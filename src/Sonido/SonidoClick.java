package Sonido;

public class SonidoClick extends Sonidos {

    public SonidoClick() {
        super.ruta =
                getClass().getResource("/Sounds/ClickSound.wav").getPath();
    }
}
