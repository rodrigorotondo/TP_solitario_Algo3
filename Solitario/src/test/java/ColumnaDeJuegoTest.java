import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnaDeJuegoTest {

    @Test
    public void agregarCartas() {

        ColumnaDeJuego ColQueMuevo = new ColumnaDeJuego();
        ColumnaDeJuego ColDestino = new ColumnaDeJuego();

        Carta carta1 = new Carta(13, Palo.CORAZONES);
        Carta carta2 = new Carta(12, Palo.TREBOLES);
        Carta carta3 = new Carta(11, Palo.CORAZONES);
        Carta carta4 = new Carta(10, Palo.TREBOLES);
        Carta carta5 = new Carta(9, Palo.CORAZONES);
        Carta carta6 = new Carta(8, Palo.TREBOLES);

        ColDestino.agregarCarta(carta1);
        ColDestino.agregarCarta(carta2);
        ColDestino.agregarCarta(carta3);

        ColQueMuevo.agregarCarta(carta4);
        ColQueMuevo.agregarCarta(carta5);
        ColQueMuevo.agregarCarta(carta6);

        ColDestino.agregarCartas(ColQueMuevo);

        assertEquals(carta6.obtenerNumero(),ColDestino.obtenerNumeroUltimaCarta());
        assertEquals(carta6.obtenerPalo(),ColDestino.obtenerPaloUltimaCarta());

    }
    @Test
    public void cambiarDeColumna01() {

        ColumnaDeJuego colQueMuevo = new ColumnaDeJuego();
        ColumnaDeJuego colDestino = new ColumnaDeJuego();

        Carta carta1 = new Carta(13, Palo.CORAZONES);
        Carta carta2 = new Carta(12, Palo.TREBOLES);
        Carta carta3 = new Carta(11, Palo.CORAZONES);
        Carta carta4 = new Carta(10, Palo.TREBOLES);
        Carta carta5 = new Carta(9, Palo.CORAZONES);
        Carta carta6 = new Carta(8, Palo.TREBOLES);

        Carta carta11 = new Carta(13, Palo.CORAZONES);
        Carta carta22 = new Carta(12, Palo.TREBOLES);
        Carta carta33 = new Carta(11, Palo.CORAZONES);
        Carta carta44 = new Carta(10, Palo.TREBOLES);
        Carta carta55 = new Carta(9, Palo.CORAZONES);
        Carta carta66 = new Carta(8, Palo.TREBOLES);
        Carta carta77 = new Carta(7, Palo.CORAZONES);
        Carta carta88 = new Carta(6, Palo.TREBOLES);

        colDestino.agregarCarta(carta1);
        colDestino.agregarCarta(carta2);
        colDestino.agregarCarta(carta3);
        colDestino.agregarCarta(carta4);
        colDestino.agregarCarta(carta5);
        colDestino.agregarCarta(carta6);

        colQueMuevo.agregarCarta(carta11);
        colQueMuevo.agregarCarta(carta22);
        colQueMuevo.agregarCarta(carta33);
        colQueMuevo.agregarCarta(carta44);
        colQueMuevo.agregarCarta(carta55);
        colQueMuevo.agregarCarta(carta66);
        colQueMuevo.agregarCarta(carta77);
        colQueMuevo.agregarCarta(carta88);

        colQueMuevo.cambiarDeColumna(colDestino,carta77);

        assertTrue(colQueMuevo.obtenerTamanio() == 6);
        assertTrue(colDestino.obtenerTamanio() == 8);
        assertEquals(colDestino.obtenerNumeroUltimaCarta(),carta88.obtenerNumero());
        assertEquals(colDestino.obtenerPaloUltimaCarta(),carta88.obtenerPalo());

    }
}