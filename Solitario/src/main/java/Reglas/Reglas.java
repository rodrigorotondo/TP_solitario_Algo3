package Reglas;

import Carta.*;
import Columna.*;
import Reglas.*;
import StackDeCartas.*;
import Solitario.*;

import java.io.Serializable;

public abstract class Reglas implements Serializable {

    //-----------------------------------------------------Atributos---------------------------------------------------//
    final protected int REY = 13;
    final protected int AS = 1;

    //-----------------------------------------------------Métodos----------------------------------------------------//
    public abstract boolean puedoExtraerDeColumna(ColumnaDeJuego columna);
    public abstract boolean puedoAgregarCartasAColumna(ColumnaDeJuego columnaExtraer, ColumnaDeJuego columnaDepositar);
    public boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, Fundacion fundacion){
        if(fundacion.estaVacia()){
            return numeroCarta == AS; // si la carta es igual a 1 devuelve true
        } else {
            return(fundacion.verUltimaCarta().esAnterior(numeroCarta) && fundacion.verUltimaCarta().esMismoPalo(paloCarta));
        }
    }

    public boolean juegoGanado(Fundacion[] fundaciones) {
        for (Fundacion i : fundaciones) {
            if (!i.estaCompleta()){
                return false;
            }
        }
        return true;
    }
    public abstract boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, ColumnaDeJuego columna);

}

