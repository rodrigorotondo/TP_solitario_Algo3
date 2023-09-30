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
    public void jugadaColumnaAFundacion(int indiceColumna, int indiceFundacion){

        Fundacion fundacionDestino = this.fundaciones[indiceFundacion];
        int numeroCartaAAgregar = this.tablero[indiceColumna].obtenerNumeroUltimaCarta();
        Palo paloCartaAAgregar = this.tablero[indiceColumna].obtenerPaloUltimaCarta();

        if (this.reglas.PuedoAgregarCarta(numeroCartaAAgregar,paloCartaAAgregar,fundacionDestino )){
            this.tablero[indiceColumna].cambiarAFundacion(fundacionDestino);
        }
    }
    public void jugadaFundacionAColumna(int indiceColumna, int indiceFundacion){

        ColumnaDeJuego columnaDestino = this.tablero[indiceColumna];
        int numeroCartaAAgregar = this.fundaciones[indiceFundacion].verUltimaCarta().obtenerNumero();
        Palo paloCartaAAgregar = this.fundaciones[indiceFundacion].verUltimaCarta().obtenerPalo();

        if (this.reglas.PuedoAgregarCarta(numeroCartaAAgregar,paloCartaAAgregar,columnaDestino)){
            this.fundaciones[indiceFundacion].cambiarAColumna(columnaDestino);
        }
    }
    public void jugadaDescarteFundacion(int indiceFundacion){

        Fundacion fundacionDestino = this.fundaciones[indiceFundacion];
        int numeroCartaAAgregar = this.descarte.verUltimaCarta().obtenerNumero();
        Palo paloCartaAAgregar = this.descarte.verUltimaCarta().obtenerPalo();

        if (this.reglas.PuedoAgregarCarta(numeroCartaAAgregar,paloCartaAAgregar,fundacionDestino)){
            this.descarte.cambiarAStack(fundacionDestino);
        }
    }

    public void jugadaColumnaAColumna(int indiceColumnaDestino, int indiceColumnaOrigen, int indiceCartaOrigen){
        ColumnaDeJuego columnaDestino = this.tablero[indiceColumnaDestino];
        ColumnaDeJuego columnaOrigen = this.tablero[indiceColumnaOrigen];

        if (this.reglas.PuedoAgregarCartasAColumna(columnaOrigen, columnaDestino)){
            columnaOrigen.cambiarDeColumna(columnaDestino, indiceCartaOrigen);
        }
    }
}
