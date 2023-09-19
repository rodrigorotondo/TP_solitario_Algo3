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
                cartas.push(new Carta(numero, palo));
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

    public void mezclarMazo(long semilla){
        //mezcla al azar, pero usando una semilla, lo que permite replicar el mazo mezclado
        Collections.shuffle(this.cartas, new Random(semilla));
    }

}
