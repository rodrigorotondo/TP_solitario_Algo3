package Reglas;

import Carta.Palo;
import Columna.ColumnaDeJuego;
import StackDeCartas.StackDeCartas;

public class ReglasFreeCell extends Reglas{
    @Override
    public boolean puedoExtraerDeColumna(ColumnaDeJuego columna) {
        return !columna.estaVacia();
    }

    @Override
    public boolean puedoAgregarCartasAColumna(ColumnaDeJuego columnaExtraer, ColumnaDeJuego columnaDepositar) {
        return true; //provisoriamente dejamos que siempre se pasen las cartas
    }
    
    @Override //si la columna no esta vacia se agregan de forma descendente y alternada en color
    public boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, ColumnaDeJuego columna) {
        if(columna.estaVacia()){
            return true; // cualquier carta puede ubicarse en una columna vacia
        } else {
            return(numeroCarta < columna.verUltimaCarta().obtenerNumero() &&
                    (paloCarta.obtenerColor() != columna.verUltimaCarta().obtenerColor()));
        }
    }

    public boolean puedoAgregarCartaDelAuxiliar(StackDeCartas auxiliar) {
        return auxiliar.estaVacia();
    }

    public boolean puedoSacarCartaDelAuxiliar(StackDeCartas auxiliar){
        return !auxiliar.estaVacia();
    }
}
