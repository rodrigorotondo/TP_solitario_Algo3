public class Carta {
    private enum Palo {CORAZONES,PICAS,TREBOLES,DIAMANTES}
    private final int numero;
    private final Palo palo;
    public boolean dadaVuelta; //lo pongo publico para poder preguntar por el

    //puse el atributo dadaVuelta porque despues de jugar un rato largo
    //me di cuenta que si abstraemos a un mazo real, empiezan todas las cartas dadas vuelta
    //es decir que somos incapaces de ver su valor
    //si este atributo es false, no podremos ver su num y palo, caso contrario si podremos
    public Carta(int numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
        this.dadaVuelta = false;
    }

    public boolean esVisible(){
        return dadaVuelta;
    }

    public void DescubrirCarta(){
        dadaVuelta = !dadaVuelta;
    }

    public String ObtenerColor(){
        return switch (palo) {
            case CORAZONES, PICAS -> "rojo";
            case TREBOLES, DIAMANTES -> "negro";
        };
    }

    //metodos para comparar una carta con otra

   public static void main(String[] args) {
        Carta carta = new Carta(3, Palo.TREBOLES);
        System.out.println(carta.numero + " - " + carta.palo + " color: " + carta.ObtenerColor());
    }

}
