package StackDeCartas;

import Carta.Carta;
import Carta.Palo;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;
public class Mazo extends StackDeCartas {
    //-----------------------------------------------------Métodos----------------------------------------------------//
    public Mazo() {
        this.cartas = new Stack<>();
        this.llenarMazo();
    }
    private void llenarMazo() {
        for (Palo palo : Palo.values()) {
            for (int numero = 1; numero < 14; numero++) {
                Carta carta = new Carta(numero, palo);
                this.agregarCarta(carta);
            }
        }
    }
    public void mezclarMazo() {
        //mezcla completamente al azar el mazo
        Collections.shuffle(this.cartas);
    }
    public void mezclarMazo(long semilla) {
        //mezcla al azar, pero usando una semilla, lo que permite replicar el mazo mezclado
        Collections.shuffle(this.cartas, new Random(semilla));
    }
    public void pasarCartaADescarte(Descarte descarte){
        descarte.agregarCarta(this.robarUltimaCarta());
    }
}