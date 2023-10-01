import java.util.Stack;

public class Fundacion extends StackDeCartas{
    private final int FUNDACIONCOMPLETA = 13;
    public Fundacion(){
        this.cartas = new Stack<>();
    }

    public boolean estaCompleta(){
        return this.cartas.size() == FUNDACIONCOMPLETA;
    }
}
