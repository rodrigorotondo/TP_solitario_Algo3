public class Klondike extends Solitario{
    final private int CANTIDADDEFUNDACIONES = 4;
    final private int CANTIDADDECOLUMNAS = 7;
    final private int PUNTOSINICIALES = 0;
    public Klondike() {
        this.mazo = new Mazo();
        this.fundaciones = new Fundacion[CANTIDADDEFUNDACIONES];
        this.tablero = new ColumnaDeJuego[CANTIDADDECOLUMNAS];
        this.descarte = new Descarte();
        this.reglas = new ReglasKlondike();
        this.puntos = PUNTOSINICIALES;
    }
    private void iniciarTablero(int[] CantidadDeCartasPorColumna, StackDeCartas mazo){
        for (int i = 0; i < CANTIDADDECOLUMNAS; i++){
            for (int j = 0; j < CantidadDeCartasPorColumna[i]; j++){
                tablero[i].agregarCarta(mazo.robarUltimaCarta());
            }
            tablero[i].DarVueltaUltimaCarta();
        }
    }
    protected void iniciarMesa(){
        mazo = new Mazo();
        mazo.mezclarMazo();
        iniciarTablero(new int[]{1, 2, 3, 4, 5, 6, 7}, mazo);
    }
}
