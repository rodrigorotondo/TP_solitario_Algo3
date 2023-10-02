package Reglas;

import Carta.*;
import Columna.*;
import Reglas.*;
import StackDeCartas.*;
import Solitario.*;

public abstract class Reglas {

    //-----------------------------------------------------Atributos---------------------------------------------------//
    final protected int REY = 13;
    final protected int AS = 1;

    //-----------------------------------------------------Métodos----------------------------------------------------//
    public abstract boolean puedoExtraerDeColumna(ColumnaDeJuego columna);
    public abstract boolean esCartaVisible(ColumnaDeJuego columaOrigen, int indiceCartaOrigen);
    public abstract boolean puedoSacarCartaDelMazo(Mazo mazo);
    public abstract boolean puedoSacarCartaDelDescarte(Descarte descarte);
    public abstract boolean puedoAgregarCartasAColumna(ColumnaDeJuego columnaExtraer, ColumnaDeJuego columnaDepositar);
    public abstract boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, Fundacion fundacion);
    public abstract boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, ColumnaDeJuego columna);
    public abstract boolean juegoGanado(Fundacion[] fundaciones);

}

