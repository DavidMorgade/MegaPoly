package Sonido;

public class SonidoInicio extends Sonidos {

  public SonidoInicio() {
    super.ruta =
      getClass().getResource("/Sounds/MusicaIntroduccion.wav").getPath();
  }
}
