package com.mycompany.megapoly.Sonido;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonidos {

  protected Clip sonido;

  protected String ruta;

  public Sonidos() {}

  public void reproducir() {
    new Thread(() -> {
      try {
        File archivo = new File(this.ruta);
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
