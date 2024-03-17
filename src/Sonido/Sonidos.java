package Sonido;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Sonidos {

    protected Clip sonido;
    protected String ruta;

    public Sonidos() {
    }

    public void reproducir() {
        new Thread(() -> {
            try {
                InputStream inputStream = getClass().getResourceAsStream(this.ruta);
                if (inputStream != null) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    sonido = AudioSystem.getClip();
                    sonido.open(AudioSystem.getAudioInputStream(bufferedInputStream));
                    sonido.start();
                    Thread.sleep(sonido.getMicrosecondLength() / 1000);
                    sonido.close();
                } else {
                    System.err.println("No se pudo cargar el archivo de sonido.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void parar() {
        if (sonido != null && sonido.isRunning()) {
            sonido.stop();
            sonido.close();
        }
    }
}