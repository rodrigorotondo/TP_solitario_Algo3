import Solitario.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class klondiketest02 {
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
        Klondike klondike = new Klondike();
        SerializadorSolitario serializadorSolitario = new SerializadorSolitario();
        klondike.juegoAPuntoDeGanarConCartaEnColumna();
        //act
        //aca sabemos que si movemos una carta ganamos el juego, lo guardamos
        klondike.guardarEstado("JuegoPrueba",serializadorSolitario);

        Solitario klondikeCargado;
        klondikeCargado = Klondike.cargarEstado("JuegoPrueba",serializadorSolitario);
        klondikeCargado.jugadaColumnaAFundacion(0, 3);
        //assert
        assertTrue(klondikeCargado.juegoTerminado());
    }
}