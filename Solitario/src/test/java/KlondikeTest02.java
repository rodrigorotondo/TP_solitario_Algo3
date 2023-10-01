import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KlondikeTest02 {
    @Test
    public void klondikeInicializacionEnEstadoAPuntoDeGanar() {

        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnDescarte();
        assertFalse(klondike.juegoTerminado());
    }
    @Test
    public void klondikeJuegoGanado() {

        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnDescarte();
        klondike.jugadaDescarteFundacion(3);
        assertTrue(klondike.juegoTerminado());
    }


}