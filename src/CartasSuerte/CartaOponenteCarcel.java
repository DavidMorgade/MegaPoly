package CartasSuerte;

import Jugadores.Jugador;

import javax.swing.*;

public class CartaOponenteCarcel extends CartaSuerte {

    public CartaOponenteCarcel() {
        super(
                "Oponente a la carcel",
                "Si tu oponente no esta en la carcel, lo mandas a la carcel"
        );
    }

    public void efecto(Jugador jugador, Jugador jugadorEnemigo) {
        jugadorEnemigo.setCarcel(true);
        jugadorEnemigo.getFicha().setPosicion(10);
        JOptionPane.showMessageDialog(null, "Tu oponente ha sido enviado a la carcel" + " suerte " + jugador.getNombre() + "!");
    }
}
