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
        Carta resultado = d.robarUltimaCarta();
        //assert
        assertEquals(resultado.ObtenerNumero(), esperada.ObtenerNumero());
        assertEquals(resultado.ObtenerPalo(), esperada.ObtenerPalo());
    }
}