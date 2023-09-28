import java.util.Stack;
import java.util.*;

public class Mazo extends StackDeCartas {
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
}