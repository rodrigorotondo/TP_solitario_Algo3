import org.junit.Test;

import static org.junit.Assert.*;

public class DescarteTest01 {

    @Test
    public void robarCarta() {
        //arrange
        Descarte d = new Descarte();
        Carta c = new Carta(1,Palos.DIAMANTES);
        d.agregarCarta(c);
        Carta c2 = new Carta(2,Palos.DIAMANTES);
        d.agregarCarta(c2);
        Carta c3 = new Carta(3,Palos.DIAMANTES);
        d.agregarCarta(c3);
        Carta esperada = c3;
        //act
        Carta obtenida = d.robarUltimaCarta();
        //assert
        assertTrue(!(obtenida.esPosterior(esperada)) && !(obtenida.esAnterior(esperada))); //si no es mayor ni menor es igual
        assertTrue(obtenida.esMismoPalo(esperada));
    }
}