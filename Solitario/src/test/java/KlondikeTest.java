import org.junit.Test;

import static org.junit.Assert.*;

public class KlondikeTest {

   @Test
    public void klondikeInicializacionEnEstadoAPuntoDeGanar() {

        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanar();
        assertFalse(klondike.juegoTerminado());
    }

    @Test
    public void klondikeJuegoGanado() {

        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanar();
        klondike.jugadaColumnaAFundacion(0, 3);
        assertTrue(klondike.juegoTerminado());
    }

    @Test
    public void klondikeMovimientoDesdeColumnaVacia() {

        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanar();
        klondike.jugadaColumnaAFundacion(4, 3);
        assertFalse(klondike.juegoTerminado());
    }

    @Test
    public void klondikeMovimientoDeReyAOtraColumna() {

        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanar();
        klondike.jugadaColumnaAColumna(5, 0, 0);
        assertFalse(klondike.tablero[5].estaVacia());
        assertTrue(klondike.tablero[0].estaVacia());
    }


}