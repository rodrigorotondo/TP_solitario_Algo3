import org.junit.Test;

import static org.junit.Assert.*;

public class ReglasTest02PuedoAgregarEnColumna {

    @Test
    public void agregarCartaOPilaDeCartaAColumnaVacia() {
        ColumnaDeJuego columna = new ColumnaDeJuego();
        Reglas reglas = new Reglas();
        ColumnaDeJuego cartasAAgregar= new ColumnaDeJuego();
        Carta carta1 = new Carta(13,Palos.CORAZONES);
        Carta carta2 = new Carta(12,Palos.TREBOLES);
        Carta carta3 = new Carta(11,Palos.CORAZONES);

        cartasAAgregar.agregarCarta(carta1);
        cartasAAgregar.agregarCarta(carta2);
        cartasAAgregar.agregarCarta(carta3);
        //act
        boolean valorObtenido = reglas.PuedoAgregarCartasAColumna(cartasAAgregar,columna);
        //assert
        assertTrue(valorObtenido);
    }
    @Test
    public void agregarCartaOPilaDeCartaAColumnaQueCorresponde() {
        ColumnaDeJuego columna = new ColumnaDeJuego();
        Reglas reglas = new Reglas();
        ColumnaDeJuego cartasAAgregar= new ColumnaDeJuego();
        Carta carta1 = new Carta(13,Palos.CORAZONES);
        Carta carta2 = new Carta(12,Palos.TREBOLES);
        Carta carta3 = new Carta(11,Palos.CORAZONES);
        Carta carta4 = new Carta(10,Palos.TREBOLES);
        Carta carta5 = new Carta(9,Palos.CORAZONES);
        Carta carta6 = new Carta(8,Palos.TREBOLES);

        columna.agregarCarta(carta1);
        columna.agregarCarta(carta2);
        columna.agregarCarta(carta3);

        cartasAAgregar.agregarCarta(carta4);
        cartasAAgregar.agregarCarta(carta5);
        cartasAAgregar.agregarCarta(carta6);
        //act
        boolean valorObtenido = reglas.PuedoAgregarCartasAColumna(cartasAAgregar,columna);
        //assert
        assertTrue(valorObtenido);
    }
    @Test
    public void agregarCartaOPilaDeCartaAColumnaQueNOCorresponde() {
        ColumnaDeJuego columna = new ColumnaDeJuego();
        Reglas reglas = new Reglas();
        ColumnaDeJuego cartasAAgregar= new ColumnaDeJuego();
        Carta carta1 = new Carta(13,Palos.CORAZONES);
        Carta carta2 = new Carta(12,Palos.TREBOLES);
        Carta carta3 = new Carta(11,Palos.CORAZONES);
        Carta carta4 = new Carta(10,Palos.TREBOLES);
        Carta carta5 = new Carta(9,Palos.CORAZONES);
        Carta carta6 = new Carta(8,Palos.TREBOLES);

        columna.agregarCarta(carta1);
        columna.agregarCarta(carta2);
        columna.agregarCarta(carta3);

        cartasAAgregar.agregarCarta(carta5);
        cartasAAgregar.agregarCarta(carta6);
        //act
        boolean valorObtenido = reglas.PuedoAgregarCartasAColumna(cartasAAgregar,columna);
        //assert
        assertFalse(valorObtenido);
    }
}