import java.util.Stack;

public class Fundacion extends StackUltimaVisible{
    private Stack<Carta> cartas;

    public Fundacion(){
        this.cartas = new Stack<>();
    }
//pregntita: no nos convendria que cada fundacion tenga asociada un palo|}{ay dios no encuentro l signo de interrogacion
    //porque asi podriamos comprobar que estamos poniendo cartas en la fundacion correcta
    //sino tendriamos que asignar el palo a la fundacion una vez puesto el as (igual mepa que puedo pensar algo O.o)
    //hay que probarlo ʕ•́ᴥ•̀ʔっ
    //otra cosita: para mi la fundacion puede extender Stack y podriamos hacerle Overrride al
    //push de la pila (en vez de UbicarCarta) xq la verdad no se me ocurre q otro metodo podria
    //tener fundacion ❤（っ＾▿＾）
    public void UbicarCarta(Carta carta){
        if (cartas.empty()){
            if (carta.ObtenerNumero() == 1){
                cartas.push(carta);
            }
        } else {
            if (carta.ObtenerPalos() == cartas.peek().ObtenerPalos() &&
                    carta.ObtenerNumero() == cartas.peek().ObtenerNumero() + 1){
                cartas.push(carta);
            }
        }
    }

    public Carta SacarCarta() {
        return this.cartas.pop();
    }
}
