package Carta;

import java.io.Serializable;
import java.util.Objects;
public class Carta implements Serializable {

    //-----------------------------------------------------Atributos---------------------------------------------------//
    private final int numero;
    private final Palo palo;
    private boolean bocaArriba;

    //-----------------------------------------------------Metodos---------------------------------------------------//
    public Carta(int numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
        this.bocaArriba = false;
    }
    public boolean esVisible(){
        return bocaArriba;
    }
    public void cambiarVisibilidad(){
        bocaArriba = !bocaArriba;
    }
    public Color obtenerColor(){
        return this.palo.obtenerColor();

    }
    public Palo obtenerPalo(){
        return this.palo;
    }
    public int obtenerNumero(){
        return this.numero;
    }

    public boolean esPosterior(int numeroCarta){
        return this.numero == (numeroCarta + 1);
    }
    public boolean esAnterior(int numeroCarta){
        return (this.numero) == (numeroCarta - 1);
    }
    public boolean esMismoPalo(Palo paloCarta){
        return this.palo == paloCarta;
    }
}
