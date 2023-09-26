import org.junit.Test;

import static org.junit.Assert.*;

public class ReglasTestPuedoSacarDelMazo {

    @Test
    public void PuedoSacarCartaDelDeposito() {
        Mazo mazo = new Mazo();
        Reglas reglas = new Reglas();
        boolean resultado = reglas.PuedoSacarCartaDelDeposito(mazo);
        assertTrue(resultado);
    }
}