import java.util.Stack;

public class Fundacion extends StackDeCartas{
    public Fundacion(){
        this.cartas = new Stack<>();
    }

    public void cambiarAColumna(ColumnaDeJuego columnaDestino){
        Carta cartaCopia = this.robarUltimaCarta();
        columnaDestino.agregarCarta(cartaCopia);
    }
}
