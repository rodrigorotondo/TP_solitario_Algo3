package Reglas;

import Carta.Palo;
import Columna.ColumnaDeJuego;
import StackDeCartas.Descarte;
import StackDeCartas.Fundacion;
import StackDeCartas.Mazo;

public class ReglasFreeCell extends Reglas{
    @Override
    public boolean puedoExtraerDeColumna(ColumnaDeJuego columna) {
        return false;
    }

    @Override
    public boolean esCartaVisible(ColumnaDeJuego columaOrigen, int indiceCartaOrigen) {
        return false;
    }

    @Override
    public boolean puedoSacarCartaDelMazo(Mazo mazo) {
        return false;
    }

    @Override
    public boolean puedoSacarCartaDelDescarte(Descarte descarte) {
        return false;
    }

    @Override
    public boolean puedoAgregarCartasAColumna(ColumnaDeJuego columnaExtraer, ColumnaDeJuego columnaDepositar) {
        return false;
    }
    
    @Override
    public boolean puedoAgregarCarta(int numeroCarta, Palo paloCarta, ColumnaDeJuego columna) {
        return false;
    }

    @Override
    public boolean juegoGanado(Fundacion[] fundaciones) {
        return false;
    }
}
