import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class MazoTest02RobarDelMazo {

    @Test
    public void robarCarta(){
        //arrange
        Mazo mazo = new Mazo(); // no mezcle, entonces siempre devuelve la misma carta
        Carta cartaEsperada = new Carta(13, Palos.DIAMANTES);
        Descarte descarte = new Descarte();
        descarte.agregarCarta(mazo.robarUltimaCarta());
        // act
        Carta cartaObtenida = descarte.robarUltimaCarta();
        //assert
        assertTrue(cartaObtenida.esMismoPalo(cartaEsperada));
        Assert.assertTrue(!(cartaObtenida.esPosterior(cartaEsperada)) && !(cartaObtenida.esAnterior(cartaEsperada)));
    }
    @Test
    public void CartaRobadaCorrecta() {
        //arrange
        Mazo mazo = new Mazo();
        Carta esperada = new Carta(13, Palos.DIAMANTES);
        //act
        Carta resultado = mazo.robarUltimaCarta();
        //assert
        Assert.assertTrue(!(resultado.esPosterior(esperada)) && !(resultado.esAnterior(esperada))); //si no es mayor ni menor es igual
        Assert.assertTrue(resultado.esMismoPalo(esperada));
    }
}