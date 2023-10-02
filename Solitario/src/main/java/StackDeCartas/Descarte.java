package StackDeCartas;

import Carta.*;


import java.util.Stack;



public class Descarte extends StackDeCartas {


    //-----------------------------------------------------Métodos----------------------------------------------------//
    public Descarte(){
        this.cartas = new Stack<>();
    }

    public void vaciarDescarte(Mazo mazo) {
        while (!this.estaVacia()){
            mazo.agregarCarta(this.robarUltimaCarta());
        }
    }
    @Override
    public void agregarCarta(Carta carta){
        carta.cambiarVisibilidad();
        this.cartas.push(carta);
    }


}
