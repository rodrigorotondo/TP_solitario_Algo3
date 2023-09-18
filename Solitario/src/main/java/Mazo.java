import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Mazo{
    private final Stack<Carta> cartas;

    public Mazo(){
        this.cartas = new Stack<>();
    }
    private void llenarMazo(){
        //otra razon para que palo sea clase, no encuentro forma de llamar a los diferentes tipos de enum para rellenar las cartas
        for (int i = 1; i < 14; i++) {
            cartas.push(new Carta(i, Carta.Palo.CORAZONES));
        }
    }
    private void robarDelMazo(){
    }
}
