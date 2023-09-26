import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class SolitarioTestInicializacion {
    @Test
    public void MazoCorrectamenteRepartido() {
        Solitario solitario = new Solitario();
        solitario.IniciarMesa();
        assertTrue(solitario.mazo.tamanioPila() == 24);
    }

    public void JuegoEnEstadoParticular() {
    }
}