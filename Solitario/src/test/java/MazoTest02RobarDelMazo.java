import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class MazoTest02RobarDelMazo {

    @Test
    public void robarCarta(){
        //arrange

        Mazo mazo = new Mazo(); // no mezcle, entonces siempre devuelve la misma carta

        Palos paloEsperado = Palos.DIAMANTES;
        int numeroEsperado = 13;

        Descarte descarte = new Descarte();
        descarte.agregarCarta(mazo.robarUltimaCarta());
        // act
        Carta cartaObtenida =descarte.robarUltimaCarta();
        //assert
        assertEquals(paloEsperado,cartaObtenida.ObtenerPalo());
        assertEquals(numeroEsperado,cartaObtenida.ObtenerNumero());


    }
    @Test
    public void CartaRobadaCorrecta() {
        //arrange
        Mazo mazo = new Mazo();
        Carta esperada = new Carta(13, Palos.DIAMANTES);
        //act
        Carta resultado = mazo.robarUltimaCarta();
        //assert
        Assert.assertEquals(resultado.ObtenerNumero(), esperada.ObtenerNumero());
        Assert.assertEquals(resultado.ObtenerPalo(), esperada.ObtenerPalo());
    }
}