import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Mazo{
    private final Stack<Carta> cartas;

    public Mazo(){
        this.cartas = new Stack<>();
        this.llenarMazo();
    }
    private void llenarMazo() {
        for (Palos palo : Palos.values()) {
            for (int numero = 1; numero < 14; numero++) {
                cartas.push(new Carta(numero, palo));
            }
        }
    }
    public Carta robarDelMazo(){
        return this.cartas.pop();
    }
}
