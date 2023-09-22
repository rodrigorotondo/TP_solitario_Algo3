import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;

public class Mazo{
    private final Stack<Carta> cartas;

    public Mazo(){
        this.cartas = new Stack<>();
        this.llenarMazo();
    }
    private void llenarMazo() {
        for (Palos palo : Palos.values()) {
            for (int numero = 1; numero < 14; numero++) {
                this.agregarCarta(numero,palo);
            }
        }
    }
    public Carta robarDelMazo(){
        return this.cartas.pop();
    }
    public void mezclarMazo(){
        //mezcla completamente al azar el mazo
        Collections.shuffle(this.cartas);
    }
    private void agregarCarta(int numero, Palos palo){
        this.cartas.push(new Carta(numero, palo));
    }
}
