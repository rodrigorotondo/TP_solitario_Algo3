import java.util.LinkedList;
import java.util.Stack;

public class Descarte{
    private Stack<Carta> cartas;


    public Descarte(){
        this.cartas = new Stack<>();
    }

    public void robarCarta(Mazo mazo){
        Carta cartaRobada = mazo.robarDelMazo();
        this.cartas.push(cartaRobada);
    }

    public Carta verUltimaCarta(){
        return this.cartas.peek();
    }
}
