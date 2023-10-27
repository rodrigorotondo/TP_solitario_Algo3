package Reglas;

import Carta.*;
import Columna.*;
import StackDeCartas.*;

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
            return columnaExtraer.verPrimeraCarta().obtenerNumero() == REY;
        } else {
            Carta primeraCartaExtraer = columnaExtraer.verPrimeraCarta();
            Carta ultimaCartaDepositar = columnaDepositar.verUltimaCarta();
            return(primeraCartaExtraer.obtenerNumero() < ultimaCartaDepositar.obtenerNumero()) &&
                    primeraCartaExtraer.obtenerColor() != ultimaCartaDepositar.obtenerColor();
        }
    }
    public boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, ColumnaDeJuego columna){//columna a columna
        if(columna.estaVacia()){
            return numeroCarta == REY; // si la carta es igual a 13 devuelve true
        } else {
            return(numeroCarta < columna.verUltimaCarta().obtenerNumero() &&
                    (paloCarta.obtenerColor() != columna.verUltimaCarta().obtenerColor()));
        }
    }
}
