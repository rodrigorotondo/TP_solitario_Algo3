import org.junit.Test;

import static org.junit.Assert.*;

public class ReglasTest01PuedoAgregarAs {

    @Test
    public void puedoAgregarCarta() {
        //arrange
        Fundacion fundacion = new Fundacion();
        Reglas reglas = new Reglas();
        Carta carta = new Carta(1,Palos.CORAZONES);

        //act
        boolean valorObtenido = reglas.PuedoAgregarCarta(carta,fundacion);
        //preguntamos si podemos agregar un as que puede estar en la fundacion

        //assert
        assertTrue(valorObtenido);
    }
    @Test
    public void puedoAgregarCarta2() {
        //arrange
        Fundacion fundacion = new Fundacion();
        Reglas reglas = new Reglas();
        Carta carta1 = new Carta(1,Palos.CORAZONES);
        Carta carta2 = new Carta(3,Palos.TREBOLES);
        fundacion.agregarCarta(carta1);

        //act
        boolean valorObtenido = reglas.PuedoAgregarCarta(carta2,fundacion);
        //preguntamos si podemos agregar una carta que no puede estar ahi

        //assert
        assertFalse(valorObtenido);
    }
    @Test
    public void puedoAgregarCarta3() {
        //arrange
        Fundacion fundacion = new Fundacion();
        Reglas reglas = new Reglas();
        Carta carta1 = new Carta(1,Palos.CORAZONES);
        Carta carta2 = new Carta(2,Palos.CORAZONES);
        fundacion.agregarCarta(carta1);

        //act
        boolean valorObtenido = reglas.PuedoAgregarCarta(carta2,fundacion);
        //preguntamos si puedo agregarle una carta correcta a la fundacion

        //assert
        assertTrue(valorObtenido);
    }
    @Test
    public void puedoAgregarCarta4() {
        //arrange
        Fundacion fundacion = new Fundacion();
        Reglas reglas = new Reglas();
        Carta carta = new Carta(6,Palos.CORAZONES);

        //act
        boolean valorObtenido = reglas.PuedoAgregarCarta(carta,fundacion);
        //preguntamos si puedo agregarle una carta incorrecta a la fundacion

        //assert
        assertFalse(valorObtenido);
    }
}