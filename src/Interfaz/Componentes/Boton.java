package Interfaz.Componentes;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {

    public Boton(String texto) {
        super(texto);
        this.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBackground(Color.BLUE);
        this.setForeground(Color.WHITE);
    }



}
