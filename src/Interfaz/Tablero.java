package Interfaz;

import Casillas.*;
import Comprables.Propiedad;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Tablero {

    private Map<JLabel, Casilla> tablero = new HashMap<JLabel, Casilla>(40);

    public Tablero(){
        this.CrearTablero();
        this.StyleJLabels();
    }

    // son 40 casillas

    private void CrearTablero() {
        tablero.put(new JLabel("Casilla Salida"), new CasillaSalida('S', "Salida"));
        tablero.put(new JLabel("Casilla Facebook Cadiz"), new CasillaPropiedad('F', "Facebook Cadiz"));
        tablero.put(new JLabel("Casilla Suerte"), new CasillaSuerte('S', "Suerte"));
        tablero.put(new JLabel("Casilla Facebook Sevilla"), new CasillaPropiedad('F', "Facebook Sevilla"));
        tablero.put(new JLabel("Casilla Impuesto"), new Casilla('I', "Impuesto"));
        tablero.put(new JLabel("Casilla Startup Cadiz"), new CasillaPropiedad('S', "Startup Cadiz"));
        tablero.put(new JLabel("Casilla Twitter Cadiz"), new CasillaPropiedad('T', "Twitter Cadiz"));
        tablero.put(new JLabel("Casilla Suerte por definir"), new CasillaSuerte('S', "Suerte por definir"));
        tablero.put(new JLabel("Casilla Twitter Sevilla"), new CasillaPropiedad('T', "Twitter Sevilla"));
        tablero.put(new JLabel("Casilla Twitter Malaga"), new CasillaPropiedad('T', "Twitter Malaga"));
        tablero.put(new JLabel("Casilla Carcel"), new Carcel('C', "Carcel"));
        tablero.put(new JLabel("Casilla Instagram Cadiz"), new CasillaPropiedad('I', "Instagram Cadiz"));
        tablero.put(new JLabel("Casilla Impuesto 2"), new Casilla('I', "Impuesto 2"));
        tablero.put(new JLabel("Casilla Instagram Sevilla"), new CasillaPropiedad('I', "Instagram Sevilla"));
        tablero.put(new JLabel("Casilla Instagram Malaga"), new CasillaPropiedad('I', "Instagram Malaga"));
        tablero.put(new JLabel("Casilla Startup Sevilla"), new CasillaPropiedad('S', "Startup Sevilla"));
        tablero.put(new JLabel("Casilla Google Cadiz"), new CasillaPropiedad('G', "Google Cadiz"));
        tablero.put(new JLabel("Casilla Suerte 2"), new CasillaSuerte('S', "Suerte 2"));
        tablero.put(new JLabel("Casilla Google Sevilla"), new CasillaPropiedad('G', "Google Sevilla"));
        tablero.put(new JLabel("Casilla Google Malaga"), new CasillaPropiedad('G', "Google Malaga"));
        tablero.put(new JLabel("Casilla Parking"), new CasillaParking('P', "Parking", "Parking"));
        tablero.put(new JLabel("Casilla Amazon Cadiz"), new CasillaPropiedad('A', "Amazon Cadiz"));
        tablero.put(new JLabel("Casilla Suerte por definir 2"), new CasillaSuerte('S', "Suerte por definir 2"));
        tablero.put(new JLabel("Casilla Amazon Sevilla"), new CasillaPropiedad('A', "Amazon Sevilla"));
        tablero.put(new JLabel("Casilla Amazon Malaga"), new CasillaPropiedad('A', "Amazon Malaga"));
        tablero.put(new JLabel("Casilla Startup Malaga"), new CasillaPropiedad('S', "Startup Malaga"));
        tablero.put(new JLabel("Casilla Netflix Cadiz"), new CasillaPropiedad('N', "Netflix Cadiz"));
        tablero.put(new JLabel("Casilla Netflix Sevilla"), new CasillaPropiedad('N', "Netflix Sevilla"));
        tablero.put(new JLabel("Casilla Impuesto 3"), new Casilla('I', "Impuesto 3"));
        tablero.put(new JLabel("Casilla Netflix Malaga"), new CasillaPropiedad('N', "Netflix Malaga"));
        tablero.put(new JLabel("Casilla Carcel 2"), new Carcel('C', "Carcel 2"));
        tablero.put(new JLabel("Casilla Apple Cadiz"), new CasillaPropiedad('A', "Apple Cadiz"));
        tablero.put(new JLabel("Casilla Apple Sevilla"), new CasillaPropiedad('A', "Apple Sevilla"));
        tablero.put(new JLabel("Casilla Suerte 3"), new CasillaSuerte('S', "Suerte 3"));
        tablero.put(new JLabel("Casilla Apple Malaga"), new CasillaPropiedad('A', "Apple Malaga"));
        tablero.put(new JLabel("Casilla Startup Madrid"), new CasillaPropiedad('S', "Startup Madrid"));
        tablero.put(new JLabel("Casilla Suerte por definir 3"), new CasillaSuerte('S', "Suerte por definir 3"));
        tablero.put(new JLabel("Casilla Microsoft Cadiz"), new CasillaPropiedad('M', "Microsoft Cadiz"));
        tablero.put(new JLabel("Casilla Impuesto 4"), new Casilla('I', "Impuesto 4"));
        tablero.put(new JLabel("Casilla Microsoft Sevilla"), new CasillaPropiedad('M', "Microsoft Sevilla"));
    }
    private void StyleJLabels(){
        int i = 0;
        for (JLabel label : tablero.keySet()) {
            i+=10;
            label.setSize(160, 120);
            label.setBounds(i, i, 160, 120);
            label.setOpaque(true);
            label.setBackground(Color.RED);
        }
    }
    public Map<JLabel, Casilla> getTablero() {
        return this.tablero;
    }
}
