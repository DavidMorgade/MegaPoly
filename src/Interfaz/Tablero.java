package Interfaz;

import Casillas.*;
import Comprables.Propiedad;
import Jugadores.Jugador;
import Materiales.Ficha;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tablero implements Serializable {

    private static final long serialVersionUID = 1L;
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
        tablero.put(new JLabel("<html>Facebook<br>Cadiz</html>"), new CasillaPropiedad('F', "Facebook Cadiz", 5));
        tablero.put(new JLabel(""), new CasillaSuerte('S', "Suerte"));
        tablero.put(new JLabel("<html>Facebook<br>Sevilla</html>"), new CasillaPropiedad('F', "Facebook Sevilla", 6));
        tablero.put(new JLabel("Impuesto 1MM"), new CasillaImpuesto('I', "Impuesto", 1));
        tablero.put(new JLabel("<html>StartUp<br>Cadiz</html>"), new CasillaPropiedad('S', "Startup Cadiz", 5));
        tablero.put(new JLabel("<html>Twitter<br>Cadiz</html>"), new CasillaPropiedad('T', "Twitter Cadiz", 6));
        tablero.put(new JLabel(""), new CasillaAleatoria('A', "Casilla Aleatoria"));
        tablero.put(new JLabel("<html>Twitter<br>Sevilla</html>"), new CasillaPropiedad('T', "Twitter Sevilla", 7));
        tablero.put(new JLabel("<html>Twitter<br>Malaga</html>"), new CasillaPropiedad('T', "Twitter Malaga", 8));
        tablero.put(new JLabel(), new Carcel('C', "Carcel"));
        tablero.put(new JLabel("<html>Instagram<br>Cadiz</html>"), new CasillaPropiedad('I', "Instagram Cadiz", 8));
        tablero.put(new JLabel("Impuesto 2MM"), new CasillaImpuesto('I', "Impuesto 2", 2));
        tablero.put(new JLabel("<html>Instagram<br>Sevilla</html>"), new CasillaPropiedad('I', "Instagram Sevilla", 10));
        tablero.put(new JLabel("<html>Instagram<br>Malaga</html>"), new CasillaPropiedad('I', "Instagram Malaga", 12));
        tablero.put(new JLabel("<html>Startup<br>Sevilla</html>"), new CasillaPropiedad('S', "Startup Sevilla", 5));
        tablero.put(new JLabel("<html>Google<br>Cadiz</html>"), new CasillaPropiedad('G', "Google Cadiz", 12));
        tablero.put(new JLabel(), new CasillaSuerte('S', "Suerte 2"));
        tablero.put(new JLabel("<html>Google<br>Sevilla</html>"), new CasillaPropiedad('G', "Google Sevilla", 14));
        tablero.put(new JLabel("<html>Google<br>Malaga</html>"), new CasillaPropiedad('G', "Google Malaga", 18));
        tablero.put(new JLabel(), new CasillaParking('P', "Parking", "Parking"));
        tablero.put(new JLabel("<html>Amazon<br>Cadiz</html>"), new CasillaPropiedad('A', "Amazon Cadiz", 18));
        tablero.put(new JLabel(), new CasillaAleatoria('A', "Casilla Aleatoria"));
        tablero.put(new JLabel("<html>Amazon <br> Servilla</html>"), new CasillaPropiedad('A', "Amazon Sevilla", 22));
        tablero.put(new JLabel("<html>Amazon<br>Malaga</html>"), new CasillaPropiedad('A', "Amazon Malaga", 26));
        tablero.put(new JLabel("<html>Startup<br>Malaga</html>"), new CasillaPropiedad('S', "Startup Malaga", 5));
        tablero.put(new JLabel("<html>Netflix<br>Cadiz</html>"), new CasillaPropiedad('N', "Netflix Cadiz", 30));
        tablero.put(new JLabel("<html>Netflix<br>Sevilla</html>"), new CasillaPropiedad('N', "Netflix Sevilla", 35));
        tablero.put(new JLabel("Impuesto 3MM"), new CasillaImpuesto('I', "Impuesto 3", 3));
        tablero.put(new JLabel("<html>Netflix<br>Malaga</html>"), new CasillaPropiedad('N', "Netflix Malaga", 40));
        tablero.put(new JLabel(""), new CasillaPolicia('P', "Policia"));
        tablero.put(new JLabel("<html>Apple<br>Cadiz</html>"), new CasillaPropiedad('A', "Apple Cadiz", 40));
        tablero.put(new JLabel("<html>Apple<br>Sevilla</html>"), new CasillaPropiedad('A', "Apple Sevilla", 50));
        tablero.put(new JLabel(), new CasillaSuerte('S', "Suerte 3"));
        tablero.put(new JLabel("<html>Apple<br>Malaga</html>"), new CasillaPropiedad('A', "Apple Malaga", 70));
        tablero.put(new JLabel("<html>Startup<br>Madrid</html>"), new CasillaPropiedad('S', "Startup Madrid", 5));
        tablero.put(new JLabel(), new CasillaAleatoria('A', "Casilla Aleatoria"));
        tablero.put(new JLabel("<html>Microsoft<br>Cadiz</html>"), new CasillaPropiedad('M', "Microsoft Cadiz", 40));
        tablero.put(new JLabel("Impuesto 4MM"), new CasillaImpuesto('I', "Impuesto 4", 4));
        tablero.put(new JLabel("<html>Micrososft<br>Sevilla</html>"), new CasillaPropiedad('M', "Microsoft Sevilla", 80));
    }

    private void StyleJLabels() {
        int i = 0;
        for (JLabel label : tablero.keySet()) {
            label.setSize(160, 120);
            label.setBounds(i, i, 160, 120);
            label.setForeground(Color.GRAY);
            label.setFont(new Font("Snap ITC Normal", Font.BOLD, 10));
            switch (i) {
                case 0:
                    label.setBounds(1200, 1000, 70, 80);
                    break;
                case 1:
                    label.setBounds(1090, 1000, 60, 80);
                    break;
                case 2:
                    label.setBounds(1010, 1000, 60, 80);
                    break;
                case 3:
                    label.setBounds(930, 1000, 60, 80);
                    break;
                case 4:
                    label.setBounds(850, 1000, 60, 80);
                    break;
                case 5:
                    label.setBounds(770, 1000, 60, 80);
                    break;
                case 6:
                    label.setBounds(690, 1000, 60, 80);
                    break;
                case 7:
                    label.setBounds(610, 1000, 60, 80);
                    break;
                case 8:
                    label.setBounds(530, 1000, 60, 80);
                    break;
                case 9:
                    label.setBounds(450, 1000, 60, 80);
                    break;
                case 10:
                    label.setBounds(320, 1000, 80, 80);
                    break;
                case 11:
                    label.setBounds(320, 890, 100, 60);
                    break;
                case 12:
                    label.setBounds(320, 810, 100, 60);
                    break;
                case 13:
                    label.setBounds(320, 730, 100, 60);
                    break;
                case 14:
                    label.setBounds(320, 650, 100, 60);
                    break;
                case 15:
                    label.setBounds(320, 570, 100, 60);
                    break;
                case 16:
                    label.setBounds(320, 490, 100, 60);
                    break;
                case 17:
                    label.setBounds(320, 410, 100, 60);
                    break;
                case 18:
                    label.setBounds(320, 330, 100, 60);
                    break;
                case 19:
                    label.setBounds(320, 250, 100, 60);
                    break;
                case 20:
                    label.setBounds(320, 130, 100, 80);
                    break;
                case 21:
                    label.setBounds(450, 110, 60, 80);
                    break;
                case 22:
                    label.setBounds(530, 110, 60, 80);
                    break;
                case 23:
                    label.setBounds(610, 110, 60, 80);
                    break;
                case 24:
                    label.setBounds(690, 110, 60, 80);
                    break;
                case 25:
                    label.setBounds(770, 110, 60, 80);
                    break;
                case 26:
                    label.setBounds(850, 110, 60, 80);
                    break;
                case 27:
                    label.setBounds(930, 110, 60, 80);
                    break;
                case 28:
                    label.setBounds(1010, 110, 60, 80);
                    break;
                case 29:
                    label.setBounds(1090, 110, 60, 80);
                    break;
                case 30:
                    label.setBounds(1200, 110, 80, 80);
                    break;
                case 31:
                    label.setBounds(1210, 250, 80, 60);
                    break;
                case 32:
                    label.setBounds(1210, 330, 80, 60);
                    break;
                case 33:
                    label.setBounds(1210, 410, 80, 60);
                    break;
                case 34:
                    label.setBounds(1210, 490, 80, 60);
                    break;
                case 35:
                    label.setBounds(1210, 570, 80, 60);
                    break;
                case 36:
                    label.setBounds(1210, 650, 80, 60);
                    break;
                case 37:
                    label.setBounds(1210, 730, 80, 60);
                    break;
                case 38:
                    label.setBounds(1210, 810, 80, 60);
                    break;
                case 39:
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
