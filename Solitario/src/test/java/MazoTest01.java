import org.junit.Test;

import static org.junit.Assert.*;

public class MazoTest01 {
    @Test
    public void MazoCorrectamenteLleno() {
        //arrange
        Mazo mazo = new Mazo();
        Carta esperada = new Carta(13, Palos.DIAMANTES);
        //act
        Carta resultado = mazo.robarDelMazo();
        //assert
        assertEquals(resultado, esperada);
    }
}