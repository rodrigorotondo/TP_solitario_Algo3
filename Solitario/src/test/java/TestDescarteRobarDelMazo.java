import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TestDescarteRobarDelMazo {

    @Test
    public void robarCarta() {
        //arrange

        Mazo mazo = new Mazo(); // no mezcle, entonces siempre devuelve la misma carta

        Palos paloEsperado = Palos.DIAMANTES;
        int numeroEsperado = 13;

        Descarte descarte = new Descarte();
        // act
        descarte.robarCarta(mazo);



        //assert
        assertEquals(paloEsperado,descarte.verUltimaCarta().ObtenerPalo());
        assertEquals(numeroEsperado,descarte.verUltimaCarta().ObtenerNumero());


    }
}