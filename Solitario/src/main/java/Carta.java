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
    public void DescubrirCarta(){
        bocaArriba = !bocaArriba;
    }
    public Color ObtenerColor(){
        return switch (palo) {
            case CORAZONES, PICAS -> Color.NEGRO;
            case TREBOLES, DIAMANTES -> Color.ROJO;
        };
    }
    public int ObtenerNumero(){
        return this.numero;
    }
    public boolean EsMismoColorConOtraCarta(Carta carta){
        return Objects.equals(this.ObtenerColor(), carta.ObtenerColor());
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
