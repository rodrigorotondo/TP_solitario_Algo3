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

    public String ObtenerColor(){
        return switch (palo) {
            case CORAZONES, PICAS -> "rojo";
            case TREBOLES, DIAMANTES -> "negro";
        };
    }
    public int ObtenerNumero(){
        return this.numero;
    }

    //algo parecido al strcmp, si es menor me devuelve negativo, si son iguales 0 y
    //si es mayor positivo :3
    //IMPORTANTE SI QUIERO VER QUE LAS CARTAS SEAN CONSECUTIVAS ESTE METODO ME DEVUELVE 1 c;
    // public int CompararConOtraCarta(Carta carta){
    //    return numero - carta.ObtenerNumero();
    //}
    public boolean EsMismoColorConOtraCarta(Carta carta){
        return Objects.equals(this.ObtenerColor(), carta.ObtenerColor());
    }

    public boolean esPosterior(Carta carta){
        return this.numero == (carta.numero + 1);
    }

    public boolean esAnterior(Carta carta){
        return this.numero == (carta.numero - 1);
    }

    public boolean esMismoPalo(Carta carta){
        return this.palo == carta.palo;
    }
    public boolean esUnAs(){
        return this.numero == 1;
    }
    public boolean esUnRey(){
        return this.numero == 13;
    }

}
