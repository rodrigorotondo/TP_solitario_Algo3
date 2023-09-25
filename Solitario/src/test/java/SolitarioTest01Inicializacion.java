import org.junit.Test;

import static org.junit.Assert.*;

public class SolitarioTest01Inicializacion {
    @Test
    public void InicializacionCorrecta() {

        Solitario solitario = new Solitario();
        //me voy de rango :c//solucionado
        solitario.IniciarMesa();
        assertTrue(solitario.tablero[0].tamanioPila() == 1);
        assertTrue(solitario.tablero[0].verUltimaCarta().esVisible());
        assertTrue(solitario.tablero[6].tamanioPila() == 7);
        assertTrue(solitario.tablero[6].verUltimaCarta().esVisible());
        assertTrue(solitario.fundaciones[0].estaVacia());
        assertTrue(solitario.fundaciones[3].estaVacia());
        assertTrue(solitario.mazo.tamanioPila() == 24);
    }

}