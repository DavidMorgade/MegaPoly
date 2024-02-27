package Interfaz;

import Casillas.*;
import Comprables.Propiedad;
import Jugadores.Jugador;
import Materiales.Ficha;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tablero {
    Jugador jugador1;
    Jugador jugador2;
    private Map<JLabel, Casilla> tablero = new LinkedHashMap<JLabel, Casilla>(40);

    public Tablero(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.CrearTablero();
        this.StyleJLabels();
    }

    // son 40 casillas

    private void CrearTablero() {
        tablero.put(new JLabel(""), new CasillaSalida('S', "Salida"));
        tablero.put(new JLabel("<html>Facebook<br>Cadiz</html>"), new CasillaPropiedad('F', "Facebook Cadiz"));
        tablero.put(new JLabel(""), new CasillaSuerte('S', "Suerte"));
        tablero.put(new JLabel("<html>Facebook<br>Sevilla</html>"), new CasillaPropiedad('F', "Facebook Sevilla"));
        tablero.put(new JLabel("Impuesto 1MM"), new CasillaImpuesto('I', "Impuesto", 1));
        tablero.put(new JLabel("<html>StartUp<br>Cadiz</html>"), new CasillaPropiedad('S', "Startup Cadiz"));
        tablero.put(new JLabel("<html>Twitter<br>Cadiz</html>"), new CasillaPropiedad('T', "Twitter Cadiz"));
        tablero.put(new JLabel("Suerte por definir"), new CasillaSuerte('S', "Suerte por definir"));
        tablero.put(new JLabel("<html>Twitter<br>Sevilla</html>"), new CasillaPropiedad('T', "Twitter Sevilla"));
        tablero.put(new JLabel("<html>Twitter<br>Malaga</html>"), new CasillaPropiedad('T', "Twitter Malaga"));
        tablero.put(new JLabel(), new Carcel('C', "Carcel"));
        tablero.put(new JLabel("<html>Instagram<br>Cadiz</html>"), new CasillaPropiedad('I', "Instagram Cadiz"));
        tablero.put(new JLabel("Impuesto 2MM"), new CasillaImpuesto('I', "Impuesto 2", 2));
        tablero.put(new JLabel("<html>Instagram<br>Sevilla</html>"), new CasillaPropiedad('I', "Instagram Sevilla"));
        tablero.put(new JLabel("<html>Instagram<br>Malaga</html>"), new CasillaPropiedad('I', "Instagram Malaga"));
        tablero.put(new JLabel("<html>Startup<br>Sevilla</html>"), new CasillaPropiedad('S', "Startup Sevilla"));
        tablero.put(new JLabel("<html>Google<br>Cadiz</html>"), new CasillaPropiedad('G', "Google Cadiz"));
        tablero.put(new JLabel(), new CasillaSuerte('S', "Suerte 2"));
        tablero.put(new JLabel("<html>Google<br>Sevilla</html>"), new CasillaPropiedad('G', "Google Sevilla"));
        tablero.put(new JLabel("<html>Google<br>Malaga</html>"), new CasillaPropiedad('G', "Google Malaga"));
        tablero.put(new JLabel(), new CasillaParking('P', "Parking", "Parking"));
        tablero.put(new JLabel("<html>Amazon<br>Cadiz</html>"), new CasillaPropiedad('A', "Amazon Cadiz"));
        tablero.put(new JLabel("Suerte por definir 2"), new CasillaSuerte('S', "Suerte por definir 2"));
        tablero.put(new JLabel("<html>Amazon <br> Servilla</html>"), new CasillaPropiedad('A', "Amazon Sevilla"));
        tablero.put(new JLabel("<html>Amazon<br>Malaga</html>"), new CasillaPropiedad('A', "Amazon Malaga"));
        tablero.put(new JLabel("<html>Startup<br>Malaga</html>"), new CasillaPropiedad('S', "Startup Malaga"));
        tablero.put(new JLabel("<html>Netflix<br>Cadiz</html>"), new CasillaPropiedad('N', "Netflix Cadiz"));
        tablero.put(new JLabel("<html>Netflix<br>Sevilla</html>"), new CasillaPropiedad('N', "Netflix Sevilla"));
        tablero.put(new JLabel("Impuesto 3MM"), new CasillaImpuesto('I', "Impuesto 3", 3));
        tablero.put(new JLabel("<html>Netflix<br>Malaga</html>"), new CasillaPropiedad('N', "Netflix Malaga"));
        tablero.put(new JLabel(""), new Carcel('C', "Carcel 2"));
        tablero.put(new JLabel("<html>Apple<br>Cadiz</html>"), new CasillaPropiedad('A', "Apple Cadiz"));
        tablero.put(new JLabel("<html>Apple<br>Sevilla</html>"), new CasillaPropiedad('A', "Apple Sevilla"));
        tablero.put(new JLabel(), new CasillaSuerte('S', "Suerte 3"));
        tablero.put(new JLabel("<html>Apple<br>Malaga</html>"), new CasillaPropiedad('A', "Apple Malaga"));
        tablero.put(new JLabel("<html>Startup<br>Madrid</html>"), new CasillaPropiedad('S', "Startup Madrid"));
        tablero.put(new JLabel("Suerte por definir 3"), new CasillaSuerte('S', "Suerte por definir 3"));
        tablero.put(new JLabel("<html>Microsoft<br>Cadiz</html>"), new CasillaPropiedad('M', "Microsoft Cadiz"));
        tablero.put(new JLabel("Impuesto 4MM"), new CasillaImpuesto('I', "Impuesto 4", 4));
        tablero.put(new JLabel("<html>Micrososft<br>Sevilla</html>"), new CasillaPropiedad('M', "Microsoft Sevilla"));
    }

    private void StyleJLabels() {
        int i = 0;
        Ficha fichaRoja = jugador1.getFicha();
        Ficha fichaAzul = jugador2.getFicha();
        for (JLabel label : tablero.keySet()) {
            label.setSize(160, 120);
            label.setBounds(i, i, 160, 120);
            label.setForeground(Color.GRAY);
            label.setFont(new Font("Snap ITC Normal", Font.BOLD, 10));
            switch (i) {
                case 0:
                    label.setBounds(1200, 1000, 70, 80);
                    label.add(fichaRoja);
                    label.add(fichaAzul);
                    break;
                case 1:
                    label.setBounds(1090, 1000, 60, 80);
                    break;
                case 2:
                    label.setBackground(Color.GREEN);
                    label.setBounds(1010, 1000, 60, 80);
                    break;
                case 3:
                    label.setBackground(Color.YELLOW);
                    label.setBounds(930, 1000, 60, 80);
                    break;
                case 4:
                    label.setBackground(Color.ORANGE);
                    label.setBounds(850, 1000, 60, 80);
                    break;
                case 5:
                    label.setBackground(Color.PINK);
                    label.setBounds(770, 1000, 60, 80);
                    break;
                case 6:
                    label.setBackground(Color.CYAN);
                    label.setBounds(690, 1000, 60, 80);
                    break;
                case 7:
                    label.setBackground(Color.MAGENTA);
                    label.setBounds(610, 1000, 60, 80);
                    break;
                case 8:
                    label.setBackground(Color.LIGHT_GRAY);
                    label.setBounds(530, 1000, 60, 80);
                    break;
                case 9:
                    label.setBackground(Color.DARK_GRAY);
                    label.setBounds(450, 1000, 60, 80);
                    break;
                case 10:
                    label.setBackground(Color.BLACK);
                    label.setBounds(320, 1000, 80, 80);
                    break;
                case 11:
                    label.setBackground(Color.WHITE);
                    label.setBounds(320, 890, 100, 60);
                    break;
                case 12:
                    label.setBackground(Color.RED);
                    label.setBounds(320, 810, 100, 60);
                    break;
                case 13:
                    label.setBackground(Color.BLUE);
                    label.setBounds(320, 730, 100, 60);
                    break;
                case 14:
                    label.setBackground(Color.GREEN);
                    label.setBounds(320, 650, 100, 60);
                    break;
                case 15:
                    label.setBackground(Color.YELLOW);
                    label.setBounds(320, 570, 100, 60);
                    break;
                case 16:
                    label.setBackground(Color.ORANGE);
                    label.setBounds(320, 490, 100, 60);
                    break;
                case 17:
                    label.setBackground(Color.PINK);
                    label.setBounds(320, 410, 100, 60);
                    break;
                case 18:
                    label.setBackground(Color.CYAN);
                    label.setBounds(320, 330, 100, 60);
                    break;
                case 19:
                    label.setBackground(Color.MAGENTA);
                    label.setBounds(320, 250, 100, 60);
                    break;
                case 20:
                    label.setBackground(Color.LIGHT_GRAY);
                    label.setBounds(320, 130, 100, 80);
                    break;
                case 21:
                    label.setBackground(Color.DARK_GRAY);
                    label.setBounds(450, 110, 60, 80);
                    break;
                case 22:
                    label.setBackground(Color.BLACK);
                    label.setBounds(530, 110, 60, 80);
                    break;
                case 23:
                    label.setBackground(Color.WHITE);
                    label.setBounds(610, 110, 60, 80);
                    break;
                case 24:
                    label.setBackground(Color.RED);
                    label.setBounds(690, 110, 60, 80);
                    break;
                case 25:
                    label.setBackground(Color.BLUE);
                    label.setBounds(770, 110, 60, 80);
                    break;
                case 26:
                    label.setBackground(Color.GREEN);
                    label.setBounds(850, 110, 60, 80);
                    break;
                case 27:
                    label.setBackground(Color.YELLOW);
                    label.setBounds(930, 110, 60, 80);
                    break;
                case 28:
                    label.setBackground(Color.ORANGE);
                    label.setBounds(1010, 110, 60, 80);
                    break;
                case 29:
                    label.setBackground(Color.PINK);
                    label.setBounds(1090, 110, 60, 80);
                    break;
                case 30:
                    label.setBackground(Color.CYAN);
                    label.setBounds(1200, 110, 80, 80);
                    break;
                case 31:
                    label.setBackground(Color.MAGENTA);
                    label.setBounds(1210, 250, 80, 60);
                    break;
                case 32:
                    label.setBackground(Color.LIGHT_GRAY);
                    label.setBounds(1210, 330, 80, 60);
                    break;
                case 33:
                    label.setBackground(Color.RED);
                    label.setBounds(1210, 410, 80, 60);
                    break;
                case 34:
                    label.setBackground(Color.BLUE);
                    label.setBounds(1210, 490, 80, 60);
                    break;
                case 35:
                    label.setBackground(Color.GREEN);
                    label.setBounds(1210, 570, 80, 60);
                    break;
                case 36:
                    label.setBackground(Color.YELLOW);
                    label.setBounds(1210, 650, 80, 60);
                    break;
                case 37:
                    label.setBackground(Color.ORANGE);
                    label.setBounds(1210, 730, 80, 60);
                    break;
                case 38:
                    label.setBackground(Color.PINK);
                    label.setBounds(1210, 810, 80, 60);
                    break;
                case 39:
                    label.setBackground(Color.CYAN);
                    label.setBounds(1210, 890, 80, 60);
                    break;
            }
            i += 1;
        }
    }

    public Map<JLabel, Casilla> getTablero() {
        return this.tablero;
    }
}
