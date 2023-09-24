import java.util.Stack;

public class Deposito extends StackDeCartas{
    public Deposito(){
        this.cartas = new Stack<>();
    }

    public void llenarDeposito(StackDeCartas cartas){
    }
    //tiene sentido la clase deposito? si es el restante del mazo mismo,
    //el mazo podria darse vuelta, etc, podriamos prescindir de ella.
}
