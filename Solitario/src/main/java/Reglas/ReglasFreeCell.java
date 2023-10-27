package Reglas;

import Carta.Palo;
import Columna.ColumnaDeJuego;
import StackDeCartas.Descarte;
import StackDeCartas.Mazo;
import StackDeCartas.StackDeCartas;

public class ReglasFreeCell extends Reglas{
    @Override
    public boolean puedoExtraerDeColumna(ColumnaDeJuego columna) {
        return !columna.estaVacia();
    }

    @Override //se descarta, todas las cartas son siempre visibles
    public boolean esCartaVisible(ColumnaDeJuego columaOrigen, int indiceCartaOrigen) {
        return false;
    }

    @Override //se descarta
    public boolean puedoSacarCartaDelDescarte(Descarte descarte) {
        return false;
    }

    @Override //se descarta
    public boolean puedoSacarCartaDelMazo(Mazo mazo) {
        return false;
    }

    @Override //se puede descartar si solo hace el movimiento 1 sola carta -> columna
    public boolean puedoAgregarCartasAColumna(ColumnaDeJuego columnaExtraer, ColumnaDeJuego columnaDepositar) {
        return false;
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

    public boolean puedoAgregarCartaAlAuxiliar(StackDeCartas auxiliar) {
        return auxiliar.estaVacia();
    }
}
