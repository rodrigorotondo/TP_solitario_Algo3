import Solitario.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class klondiketest01 {
   @Test
    public void klondikeInicializacionEnEstadoAPuntoDeGanar() {
        FabricaDeSolitarios FabricaKlondike = new FabricaDeSolitariosKlondike();
        Solitario klondike = FabricaKlondike.crearSolitario();
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
    public void klondikeDescarteVacio() throws Exception {
        FabricaDeSolitarios fabricaKlondike = new FabricaDeSolitariosKlondike();
        Solitario klondike = fabricaKlondike.crearSolitario();
        klondike.jugadaDescarteFundacion(3);
        assertFalse(klondike.juegoTerminado());
    }
    @Test
    public void klondikeVariasJugadas() {
        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnDescarte();
        klondike.jugadaDescarteColumna(3);
        klondike.jugadaFundacionAColumna(3, 3);
        klondike.jugadaSacarCartaDelMazo();
        klondike.jugadaColumnaAFundacion(3, 3);
        klondike.jugadaColumnaAFundacion(3, 3);
        assertTrue(klondike.juegoTerminado());
    }
}