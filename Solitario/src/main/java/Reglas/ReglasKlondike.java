package Reglas;

import Carta.*;
import Columna.*;
import Reglas.*;
import StackDeCartas.*;
import Solitario.*;

public class ReglasKlondike extends Reglas {

    //-----------------------------------------------------Métodos----------------------------------------------------//
    public boolean esCartaVisible(ColumnaDeJuego columnaOrigen, int indiceCartaOrigen){
        return columnaOrigen.esCartaVisible(indiceCartaOrigen);
    }
    public boolean puedoExtraerDeColumna(ColumnaDeJuego columna){
        return !columna.estaVacia();
    }
    public boolean puedoSacarCartaDelMazo(Mazo mazo){return !mazo.estaVacia();}
    public boolean puedoSacarCartaDelDescarte(Descarte descarte){return !descarte.estaVacia();}
    public boolean puedoAgregarCartasAColumna(ColumnaDeJuego columnaExtraer, ColumnaDeJuego columnaDepositar){
        if(columnaDepositar.estaVacia()){
            return columnaExtraer.obtenerNumeroPrimeraCarta() == REY;
        } else {
            return(columnaExtraer.obtenerNumeroPrimeraCarta() < columnaDepositar.obtenerNumeroUltimaCarta()) &&
                    columnaExtraer.obtenerColorPrimeraCarta() != columnaDepositar.obtenerColorUltimaCarta();
        }
    }
    public boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, Fundacion fundacion){
        if(fundacion.estaVacia()){
            return numeroCarta == AS; // si la carta es igual a 1 devuelve true
        } else {
            return(fundacion.verUltimaCarta().esAnterior(numeroCarta) && fundacion.verUltimaCarta().esMismoPalo(paloCarta));
        }
    }
    public boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, ColumnaDeJuego columna){//columna a columna
        if(columna.estaVacia()){
            return numeroCarta == REY; // si la carta es igual a 13 devuelve true
        } else {
            return(numeroCarta < columna.obtenerNumeroUltimaCarta() && (paloCarta.obtenerColor() != columna.obtenerColorUltimaCarta()));
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
}
