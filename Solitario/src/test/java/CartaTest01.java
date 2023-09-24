import org.junit.Test;

import static org.junit.Assert.*;

public class CartaTest01 {

    @Test
    public void ComprobarCartaAnterior() {
        //
        Carta carta1 = new Carta(13,Palos.CORAZONES);
        Carta carta2 = new Carta(12,Palos.TREBOLES);
        //
        boolean resultado = carta1.esPosterior(carta2);
        //
        assertTrue(resultado);
    }
    @Test
    public void ComprobarCartaPosterior() {
        //
        Carta carta1 = new Carta(13,Palos.CORAZONES);
        Carta carta2 = new Carta(12,Palos.TREBOLES);
        //
        boolean resultado = carta2.esAnterior(carta1);
        //
        assertTrue(resultado);
    }
}