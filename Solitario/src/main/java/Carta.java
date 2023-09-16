public class Carta {
    private enum Palo {CORAZONES,PICAS,TREBOLES,DIAMANTES}
    private final int numero;
    private final Palo palo;

    public Carta(int numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
    }

    public String obtenerColor(){
        return switch (palo) {
            case CORAZONES, PICAS -> "rojo";
            case TREBOLES, DIAMANTES -> "negro";
        };
    }
   public static void main(String[] args) {
        Carta carta = new Carta(3, Palo.TREBOLES);
        System.out.println(carta.numero + " - " + carta.palo + " color: " + carta.obtenerColor());
    }

}
