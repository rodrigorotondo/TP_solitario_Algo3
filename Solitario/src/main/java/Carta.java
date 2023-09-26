import java.util.Objects;

public class Carta {

    //-----------------------------------------------------Atributos---------------------------------------------------
    private final int numero;
    private final Palos palo;
    private boolean bocaArriba;

    //-----------------------------------------------------Metodos---------------------------------------------------
    public Carta(int numero, Palos palo){
        this.numero = numero;
        this.palo = palo;
        this.bocaArriba = false;
    }
    public boolean esVisible(){
        return bocaArriba;
    }
    public void descubrirCarta(){
        bocaArriba = !bocaArriba;
    }
    public Color obtenerColor(){
        return switch (palo) {
            case CORAZONES, PICAS -> Color.NEGRO;
            case TREBOLES, DIAMANTES -> Color.ROJO;
        };
    }
    public Palos obtenerPalo(){
        return this.palo;
    }
    public int obtenerNumero(){
        return this.numero;
    }
    public boolean EsMismoColorConOtraCarta(Carta carta){
        return Objects.equals(this.obtenerColor(), carta.obtenerColor());
    }
    public boolean esPosterior(Carta carta){
        return this.numero == (carta.numero + 1);
    }
    public boolean esAnterior(Carta carta){
        return (this.numero) == (carta.numero - 1);
    }
    public boolean esMismoPalo(Carta carta){
        return this.palo == carta.palo;
    }
}
