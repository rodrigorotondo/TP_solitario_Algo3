
import Solitario.*;
import org.junit.Test;

import java.io.IOException;

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
    public void klondikeCargarJuego() throws IOException, ClassNotFoundException {
        //arrange
        Solitario klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnColumna();
        //act
        //aca sabemos que si movemos una carta ganamos el juego, lo guardamos
        klondike.guardarEstado("JuegoPrueba");

        Solitario  klondikeCargado;
        klondikeCargado = Solitario.cargarEstado("JuegoPrueba");
        klondikeCargado.jugadaColumnaAFundacion(0, 3);
        //assert
        assertTrue(klondikeCargado.juegoTerminado());

    }

}