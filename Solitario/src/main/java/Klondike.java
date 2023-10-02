public class Klondike extends Solitario {
    final private int CANTIDADDEFUNDACIONES = 4;
    final private int CANTIDADDECOLUMNAS = 7;


    public Klondike() {
        this.mazo = new Mazo();
        this.fundaciones = new Fundacion[CANTIDADDEFUNDACIONES];
        this.iniciarFundaciones();
        this.tablero = new ColumnaDeJuego[CANTIDADDECOLUMNAS];
        this.iniciarColumnas();
        this.descarte = new Descarte();
        this.reglas = new ReglasKlondike();

    }
    private void iniciarFundaciones(){
        for (int i = 0; i < CANTIDADDEFUNDACIONES; i++){
            fundaciones[i] = new Fundacion();
        }
    }
    private void iniciarColumnas(){
        for (int i = 0; i < CANTIDADDECOLUMNAS; i++){
            tablero[i] = new ColumnaDeJuego();
        }
    }
    private void iniciarTablero(int[] CantidadDeCartasPorColumna, StackDeCartas mazo) {
        for (int i = 0; i < CANTIDADDECOLUMNAS; i++) {
            for (int j = 0; j < CantidadDeCartasPorColumna[i]; j++) {
                tablero[i].agregarCarta(mazo.robarUltimaCarta());
            }
            tablero[i].darVueltaUltimaCarta();
        }
    }

    protected void iniciarMesa() {
        mazo = new Mazo();
        mazo.mezclarMazo();
        iniciarTablero(new int[]{1, 2, 3, 4, 5, 6, 7}, mazo);
    }

    public void jugadaColumnaAFundacion(int indiceColumna, int indiceFundacion) {

        Fundacion fundacionDestino = this.fundaciones[indiceFundacion];
        if (this.reglas.puedoExtraerDeColumna(tablero[indiceColumna])) {
            int numeroCartaAAgregar = this.tablero[indiceColumna].obtenerNumeroUltimaCarta();
            Palo paloCartaAAgregar = this.tablero[indiceColumna].obtenerPaloUltimaCarta();

            if (this.reglas.puedoAgregarCarta(numeroCartaAAgregar, paloCartaAAgregar, fundacionDestino)) {
                this.tablero[indiceColumna].cambiarAFundacion(fundacionDestino);
            }
        }
    }

    public void jugadaFundacionAColumna(int indiceColumna, int indiceFundacion) {

        ColumnaDeJuego columnaDestino = this.tablero[indiceColumna];
        int numeroCartaAAgregar = this.fundaciones[indiceFundacion].verUltimaCarta().obtenerNumero();
        Palo paloCartaAAgregar = this.fundaciones[indiceFundacion].verUltimaCarta().obtenerPalo();

        if (this.reglas.puedoAgregarCarta(numeroCartaAAgregar, paloCartaAAgregar, columnaDestino)) {
            this.fundaciones[indiceFundacion].cambiarAColumna(columnaDestino);
        }
    }

    public void jugadaDescarteColumna(int indiceColumna){
        if(reglas.puedoSacarCartaDelDescarte(descarte)) {

            Carta cartaDescarte = this.descarte.verUltimaCarta();
            Palo paloCartaDescarte = cartaDescarte.obtenerPalo();
            int numeroCartaDescarte = cartaDescarte.obtenerNumero();

            if (reglas.puedoAgregarCarta(numeroCartaDescarte, paloCartaDescarte, this.tablero[indiceColumna])) {
                this.descarte.cambiarAColumna(this.tablero[indiceColumna]);
            }

        }
    }

    public void jugadaDescarteFundacion(int indiceFundacion) {
        Fundacion fundacionDestino = this.fundaciones[indiceFundacion];
        if (this.reglas.puedoSacarCartaDelDescarte(this.descarte)) {
            int numeroCartaAAgregar = this.descarte.verUltimaCarta().obtenerNumero();
            Palo paloCartaAAgregar = this.descarte.verUltimaCarta().obtenerPalo();

            if (this.reglas.puedoAgregarCarta(numeroCartaAAgregar, paloCartaAAgregar, fundacionDestino)) {
                this.descarte.cambiarAStack(fundacionDestino);
            }
        }
    }

        public void jugadaColumnaAColumna (int indiceColumnaDestino, int indiceColumnaOrigen, int indiceCartaOrigen){
            ColumnaDeJuego columnaDestino = this.tablero[indiceColumnaDestino];
            ColumnaDeJuego columnaOrigen = this.tablero[indiceColumnaOrigen];

            if (this.reglas.esCartaVisible(columnaOrigen, indiceCartaOrigen) && this.reglas.puedoAgregarCartasAColumna(columnaOrigen, columnaDestino)) {
                columnaOrigen.cambiarDeColumna(columnaDestino, indiceCartaOrigen);
            }
        }
        public void jugadaSacarCartaDelMazo() {
            if (this.reglas.puedoSacarCartaDelMazo(this.mazo)) {
                this.mazo.pasarCartaADescarte(this.descarte);
            }
            this.descarte.vaciarDescarte(this.mazo);
        }

        public boolean juegoTerminado(){
            return this.reglas.juegoGanado(this.fundaciones);
        }
    @Override
    public void juegoAPuntoDeGanarConCartaEnColumna() {
        while (!mazo.estaVacia()) {//tener mazo vacio
            mazo.robarUltimaCarta();
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 0 llena
            Carta carta = new Carta(numero, Palo.CORAZONES);
            this.fundaciones[0].agregarCarta(carta);
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 1 llebna
            Carta carta = new Carta(numero, Palo.DIAMANTES);
            this.fundaciones[1].agregarCarta(carta);
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 2 llena
            Carta carta = new Carta(numero, Palo.TREBOLES);
            this.fundaciones[2].agregarCarta(carta);
        }
        for (int numero = 1; numero < 13; numero++) {//en la fundacion 3 tenemos 12 y solamente falta el rey
            Carta carta = new Carta(numero, Palo.PICAS);
            this.fundaciones[3].agregarCarta(carta);
        }
        Carta ultimaCarta = new Carta(13, Palo.PICAS);
        ultimaCarta.cambiarVisibilidad();
        this.tablero[0].agregarCarta(ultimaCarta);
        }

    @Override
    public void juegoAPuntoDeGanarConCartaEnDescarte() {
        while (!mazo.estaVacia()) {//tener mazo vacio
            mazo.robarUltimaCarta();
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 0 llena
            Carta carta = new Carta(numero, Palo.CORAZONES);
            this.fundaciones[0].agregarCarta(carta);
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 1 llebna
            Carta carta = new Carta(numero, Palo.DIAMANTES);
            this.fundaciones[1].agregarCarta(carta);
        }
        for (int numero = 1; numero < 14; numero++) {//tener fundacion 2 llena
            Carta carta = new Carta(numero, Palo.TREBOLES);
            this.fundaciones[2].agregarCarta(carta);
        }
        for (int numero = 1; numero < 13; numero++) {//en la fundacion 3 tenemos 12 y solamente falta el rey
            Carta carta = new Carta(numero, Palo.PICAS);
            this.fundaciones[3].agregarCarta(carta);
        }
        Carta ultimaCarta = new Carta(13, Palo.PICAS);
        ultimaCarta.cambiarVisibilidad();
        this.descarte.agregarCarta(ultimaCarta);
    }



}

