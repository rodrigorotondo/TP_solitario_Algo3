import java.util.Objects;

public class Carta {
    private final int numero;
    private final Palos palo;
    public boolean bocaArriba;
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
    public Palos ObtenerPalos(){
        return this.palo;
    }
    //algo parecido al strcmp, si es menor me devuelve negativo, si son iguales 0 y
    //si es mayor positivo :3
    //IMPORTANTE SI QUIERO VER QUE LAS CARTAS SEAN CONSECUTIVAS ESTE METODO ME DEVUELVE 1 c;
    public int CompararConOtraCarta(Carta carta){
        return numero - carta.ObtenerNumero();
    }
    public boolean MismoColorConOtraCarta(Carta carta){
        return Objects.equals(this.ObtenerColor(), carta.ObtenerColor());
    }
}
