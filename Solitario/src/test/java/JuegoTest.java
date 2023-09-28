import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {

    @Test
    public void empezarJuegoEnEstado() {
        //arrange
        ColumnaDeJuego columna = new ColumnaDeJuego();
        Mazo mazo = new Mazo();
        Carta esperada = new Carta(13, Palo.DIAMANTES);
        //act
        Carta resultado = mazo.robarUltimaCarta();
        //assert
        Assert.assertTrue(!(resultado.esPosterior(esperada)) && !(resultado.esAnterior(esperada))); //si no es mayor ni menor es igual
        Assert.assertTrue(resultado.esMismoPalo(esperada));
    }
}