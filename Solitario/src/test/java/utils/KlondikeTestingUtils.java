package utils;

import Carta.Carta;
import Solitario.Klondike;
import Carta.*;

public class KlondikeTestingUtils extends Klondike {

    public KlondikeTestingUtils(){
        super();
    }
    public void juegoAPuntoDeGanarConCartaEnDescarte() {
        while (!mazo.estaVacia()) {//tener mazo vacio
            mazo.robarUltimaCarta();
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 0 llena
            Carta carta = new Carta(numero, Palo.CORAZONES);
            this.fundaciones[0].agregarCarta(carta);
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 1 llebna
            Carta carta = new Carta(numero, Palo.DIAMANTES);
            this.fundaciones[1].agregarCarta(carta);
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 2 llena
            Carta carta = new Carta(numero, Palo.TREBOLES);
            this.fundaciones[2].agregarCarta(carta);
        }
        for (int numero = 1; numero < 13; numero++) {//en la fundacion 3 tenemos 12 y solamente falta el rey
            Carta carta = new Carta(numero, Palo.PICAS);
            this.fundaciones[3].agregarCarta(carta);
        }
        Carta ultimaCarta = new Carta(13, Palo.PICAS);
        ultimaCarta.cambiarVisibilidad();
        this.descarte.agregarCarta(ultimaCarta);
    }

    public void juegoAPuntoDeGanarConCartaEnColumna() {
        while (!mazo.estaVacia()) {//tener mazo vacio
            mazo.robarUltimaCarta();
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 0 llena
            Carta carta = new Carta(numero, Palo.CORAZONES);
            this.fundaciones[0].agregarCarta(carta);
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 1 llebna
            Carta carta = new Carta(numero, Palo.DIAMANTES);
            this.fundaciones[1].agregarCarta(carta);
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 2 llena
            Carta carta = new Carta(numero, Palo.TREBOLES);
            this.fundaciones[2].agregarCarta(carta);
        }
        for (int numero = 1; numero < 13; numero++) {//en la fundacion 3 tenemos 12 y solamente falta el rey
            Carta carta = new Carta(numero, Palo.PICAS);
            this.fundaciones[3].agregarCarta(carta);
        }
        Carta ultimaCarta = new Carta(13, Palo.PICAS);
        ultimaCarta.cambiarVisibilidad();
        this.tablero[0].agregarCarta(ultimaCarta);
    }
}