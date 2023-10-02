package Solitario;

import Columna.ColumnaDeJuego;
import StackDeCartas.*;
import Reglas.*;


public abstract class Solitario{


    //-----------------------------------------------------Atributos---------------------------------------------------//
    protected Reglas reglas;
    protected Mazo mazo;
    protected Fundacion[] fundaciones;
    protected Descarte descarte;
    protected ColumnaDeJuego[] tablero;

    //-----------------------------------------------------Métodos----------------------------------------------------//
    public abstract void juegoAPuntoDeGanarConCartaEnColumna();

    public abstract void juegoAPuntoDeGanarConCartaEnDescarte();



}
