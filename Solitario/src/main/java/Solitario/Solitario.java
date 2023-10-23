package Solitario;

import Columna.ColumnaDeJuego;
import StackDeCartas.*;
import Reglas.*;

import java.io.*;


public abstract class Solitario implements Serializable {


    //-----------------------------------------------------Atributos---------------------------------------------------//
    protected Reglas reglas;
    protected Mazo mazo;
    protected Fundacion[] fundaciones;
    protected Descarte descarte;
    protected ColumnaDeJuego[] tablero;

    //-----------------------------------------------------Métodos----------------------------------------------------//
    public abstract void juegoAPuntoDeGanarConCartaEnColumna();

    public abstract void juegoAPuntoDeGanarConCartaEnDescarte();

    public void guardarEstado(String nombreArchivo, VisitorSerializador visitorSerializador) throws IOException {

        visitorSerializador.guardarEstado(this, nombreArchivo);

    }




    public abstract void jugadaColumnaAFundacion(int indiceColumnaOrigen, int indiceFundacionDestino);

    public abstract boolean juegoTerminado();

}
