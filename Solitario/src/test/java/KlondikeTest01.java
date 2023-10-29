import Solitario.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class KlondikeTest01 {

   @Test
    public void klondikeInicializacionEnEstadoAPuntoDeGanar() {

        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnColumna();
        assertFalse(klondike.juegoTerminado());
    }

    @Test
    public void klondikeJuegoGanado() {

        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnColumna();
        klondike.jugadaColumnaAFundacion(0, 3);
        assertTrue(klondike.juegoTerminado());
    }

    @Test
    public void klondikeMovimientoDesdeColumnaVacia() {

        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnColumna();
        klondike.jugadaColumnaAFundacion(4, 3);
        assertFalse(klondike.juegoTerminado());
    }



    @Test
    public void klondikeDescarteVacio() {
        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnColumna();
        klondike.jugadaDescarteFundacion(3);
        assertFalse(klondike.juegoTerminado());
    }







}