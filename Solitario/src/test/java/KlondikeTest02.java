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

    @Test
    public void klondikeJugadaDescarteAColumna(){
        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnDescarte();
        klondike.jugadaDescarteColumna(0);
        assertTrue(klondike.descarte.estaVacia());
        assertFalse(klondike.tablero[0].estaVacia());
    }
    @Test
    //Quiero porbar que cuando el mazo esta vacio y lo tengo todo en descarte, cuando quiero perdirle una carta
    //eso hace que todo el descarte se vacie (se de vuelta) y vuelva a mazo.
    public void klondikeJugadaMazoVacio(){
        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnDescarte();//Esta funcion deja el mazo vacio, y el descarte con una unica carta que es el 13 de PICAS
        klondike.jugadaSacarCartaDelMazo();

        assertTrue(klondike.descarte.estaVacia());
        assertFalse(klondike.mazo.verUltimaCarta().esVisible());
    }
}