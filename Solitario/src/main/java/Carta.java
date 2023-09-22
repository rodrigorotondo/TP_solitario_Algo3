public class Carta {
    private final int numero;
    private final Palos palo;
    public boolean bocaArriba; //lo pongo publico para poder preguntar por el
    //atributos bocaArriba

    //puse el atributo dadaVuelta porque despues de jugar un rato largo
    //me di cuenta que si abstraemos a un mazo real, empiezan todas las cartas dadas vuelta
    //es decir que somos incapaces de ver su valor
    //si este atributo es false, no podremos ver su num y palo, caso contrario si podremos
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

    public Palos ObtenerPalo(){

        return this.palo;
    }
}
