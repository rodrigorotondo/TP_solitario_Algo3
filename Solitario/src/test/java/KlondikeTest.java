import Solitario.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class KlondikeTest {
   @Test
    public void klondikeInicializacionEnEstadoAPuntoDeGanar1() {
        FabricaDeSolitarios FabricaKlondike = new FabricaDeSolitariosKlondike();
        Solitario klondike = FabricaKlondike.crearSolitario();
        klondike.juegoAPuntoDeGanarConCartaEnColumna();
        assertFalse(klondike.juegoTerminado());
    }
    @Test
    public void klondikeJuegoGanado1() {
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

    @Test
    public void klondikeInicializacionEnEstadoAPuntoDeGanar2() {
        Klondike klondike = new Klondike();
        klondike.juegoAPuntoDeGanarConCartaEnDescarte();
        assertFalse(klondike.juegoTerminado());
    }
    @Test
    public void klondikeJuegoGanado2() {
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