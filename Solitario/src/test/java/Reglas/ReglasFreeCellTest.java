package Reglas;
import Carta.*;
import StackDeCartas.StackDeCartas;
import org.junit.Test;
import Columna.ColumnaDeJuego;

import static org.junit.Assert.*;

public class ReglasFreeCellTest {

    @Test
    public void puedoExtraerDeColumnaConCartas() {
        ColumnaDeJuego columnaAExtraer = new ColumnaDeJuego();
        ReglasFreeCell reglas = new ReglasFreeCell();
        Carta carta1 = new Carta(13, Palo.CORAZONES);
        columnaAExtraer.agregarCarta(carta1);
        //act
        boolean valorObtenido = reglas.puedoExtraerDeColumna(columnaAExtraer);
        //assert
        assertTrue(valorObtenido);
    }
    @Test
    public void puedoExtraerDeColumnaVacia() {
        ColumnaDeJuego columnaAExtraer = new ColumnaDeJuego();
        ReglasFreeCell reglas = new ReglasFreeCell();

        //act
        boolean valorObtenido = reglas.puedoExtraerDeColumna(columnaAExtraer);
        //assert
        assertFalse(valorObtenido);
    }
    @Test
    public void puedoAgregarCartaAColVacia() {
        ColumnaDeJuego columnaAAgregar = new ColumnaDeJuego();
        ReglasFreeCell reglas = new ReglasFreeCell();
        Carta carta1 = new Carta(13, Palo.CORAZONES);
        //act
        boolean valorObtenido = reglas.puedoAgregarCarta(carta1.obtenerNumero(),carta1.obtenerPalo(),columnaAAgregar);
        //assert
        assertTrue(valorObtenido);
    }
    @Test
    public void puedoAgregarCartaAColConCartas() {
        ColumnaDeJuego columnaAAgregar = new ColumnaDeJuego();
        ReglasFreeCell reglas = new ReglasFreeCell();
        Carta carta1 = new Carta(13, Palo.CORAZONES);
        columnaAAgregar.agregarCarta(carta1);

        Carta carta2 = new Carta(12, Palo.PICAS);
        //act
        boolean valorObtenido = reglas.puedoAgregarCarta(carta2.obtenerNumero(),carta2.obtenerPalo(),columnaAAgregar);
        //assert
        assertTrue(valorObtenido);
    }
    @Test
    public void NopuedoAgregarCartaAColConCartas() {
        ColumnaDeJuego columnaAAgregar = new ColumnaDeJuego();
        ReglasFreeCell reglas = new ReglasFreeCell();
        Carta carta1 = new Carta(13, Palo.CORAZONES);
        columnaAAgregar.agregarCarta(carta1);

        Carta carta2 = new Carta(12, Palo.CORAZONES);
        //act
        boolean valorObtenido = reglas.puedoAgregarCarta(carta2.obtenerNumero(),carta2.obtenerPalo(),columnaAAgregar);
        //assert
        assertFalse(valorObtenido);
    }

    @Test
    public void puedoAgregarCartaDelAuxiliar() {

        ReglasFreeCell reglas = new ReglasFreeCell();
        StackDeCartas auxiliar = new StackDeCartas();
        //act
        boolean valorObtenido = reglas.puedoAgregarCartaDelAuxiliar(auxiliar);
        //assert
        assertTrue(valorObtenido);
    }

    @Test
    public void NopuedoAgregarCartaDelAuxiliar() {

        ReglasFreeCell reglas = new ReglasFreeCell();
        StackDeCartas auxiliar = new StackDeCartas();
        Carta carta1 = new Carta(13, Palo.CORAZONES);
        auxiliar.agregarCarta(carta1);
        //act
        boolean valorObtenido = reglas.puedoAgregarCartaDelAuxiliar(auxiliar);
        //assert
        assertFalse(valorObtenido);
    }
    @Test
    public void puedoSacarCartaDelAuxiliar() {

        ReglasFreeCell reglas = new ReglasFreeCell();
        StackDeCartas auxiliar = new StackDeCartas();
        Carta carta1 = new Carta(13, Palo.CORAZONES);
        auxiliar.agregarCarta(carta1);
        //act
        boolean valorObtenido = reglas.puedoSacarCartaDelAuxiliar(auxiliar);
        //assert
        assertTrue(valorObtenido);
    }
    @Test
    public void NoPuedoSacarCartaDelAuxiliar() {

        ReglasFreeCell reglas = new ReglasFreeCell();
        StackDeCartas auxiliar = new StackDeCartas();
        //act
        boolean valorObtenido = reglas.puedoSacarCartaDelAuxiliar(auxiliar);
        //assert
        assertFalse(valorObtenido);
    }
}