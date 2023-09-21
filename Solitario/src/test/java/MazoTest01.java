import org.junit.Test;

import static org.junit.Assert.*;

public class MazoTest01 {
    @Test
    public void CartaRobadaCorrecta() {
        //arrange
        Mazo mazo = new Mazo();
        Carta esperada = new Carta(13, Palos.DIAMANTES);
        //act
        Carta resultado = mazo.robarDelMazo();
        //assert
        assertEquals(resultado.ObtenerNumero(), esperada.ObtenerNumero());
        assertEquals(resultado.ObtenerPalos(), esperada.ObtenerPalos());
    }
}