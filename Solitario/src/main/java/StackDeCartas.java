import java.util.Stack;

public class StackDeCartas{
    protected Stack<Carta> cartas;
    public StackDeCartas(){
        this.cartas = new Stack<>();
    }
    public void agregarCarta(Carta carta){
        this.cartas.push(carta);
    }
    public Carta robarUltimaCarta(){
        return this.cartas.pop();
    }
    public Carta verUltimaCarta(){
       return this.cartas.peek();
    }
    public boolean estaVacia(){
        return this.cartas.empty();
    }
    public int tamanioPila(){
        return this.cartas.size();
    }

    public void agregarPilaDeCartas(StackDeCartas stack){
        for (int i=0; i < stack.tamanioPila(); i++){
            this.cartas.add(stack.robarUltimaCarta());
        }
    }
    public Carta verUltimaCarta(){
        return this.cartas.peek();
    }
}
