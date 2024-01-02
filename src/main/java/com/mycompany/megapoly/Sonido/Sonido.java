package com.mycompany.megapoly.Sonido;

// Librerias necesarias para importar sonido
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {

  String ruta =
    "C:/Users/david/Documents/DAM/MegaPoly/MegaPoly/MusicaIntroduccion.wav";

  private Clip sonido;

  public Sonido() {}

  public void reproducir() {
    new Thread(() -> {
      try {
        File archivo = new File(this.ruta);
        System.out.println(archivo.getCanonicalPath());
        this.sonido = AudioSystem.getClip();
        this.sonido.open(AudioSystem.getAudioInputStream(archivo));
        this.sonido.start();
        Thread.sleep(this.sonido.getMicrosecondLength() / 1000);
        this.sonido.close(); // Close the Clip after playback
      } catch (Exception e) {
        System.out.println("" + e);
      }
    })
      .start();
  }

  public void parar() {
    if (sonido != null && sonido.isRunning()) {
      sonido.stop();
      sonido.close();
    }
  }
}
