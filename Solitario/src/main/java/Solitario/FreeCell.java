package Solitario;
import Carta.*;
import Columna.*;
import Reglas.*;
import StackDeCartas.*;

import java.io.IOException;

public class FreeCell extends Solitario {
    final private int CANTIDADDEAUXILIARES = 4;
    private StackDeCartas[] auxiliares;

    private ReglasFreeCell reglas = new ReglasFreeCell();
    public FreeCell(){
        CANTIDADDEFUNDACIONES = 4;
        CANTIDADDECOLUMNAS = 8;
        this.mazo = new Mazo();
        this.fundaciones = new Fundacion[CANTIDADDEFUNDACIONES];
        this.iniciarFundaciones();
        this.tablero = new ColumnaDeJuego[CANTIDADDECOLUMNAS];
        this.iniciarColumnas();
        this.auxiliares = new StackDeCartas[CANTIDADDEAUXILIARES];
        this.iniciarAuxiliares();
        this.reglas = new ReglasFreeCell();
    }
    protected void iniciarAuxiliares(){
        for (int i = 0; i < CANTIDADDEAUXILIARES; i++){
            auxiliares[i] = new StackDeCartas();
        }
    }
    private void repartirCartas(){
        while(!this.mazo.estaVacia()){
            for(int i = 0; i < CANTIDADDECOLUMNAS; i++){
                Carta cartaAAgregar = this.mazo.robarUltimaCarta();
                this.tablero[i].agregarCarta(cartaAAgregar);
                this.tablero[i].verUltimaCarta().cambiarVisibilidad();
            }
        }
    }
    @Override
    protected void iniciarMesa() {
        this.mazo.mezclarMazo();
        this.repartirCartas();
    }
    public void jugadaColumnaAColumna(int indiceColumnaDestino, int indiceColumnaOrigen, int indiceCartaOrigen) throws Exception{
        ColumnaDeJuego columnaDestino = this.tablero[indiceColumnaDestino];
        ColumnaDeJuego columnaOrigen = this.tablero[indiceColumnaOrigen];
        int espaciosVacios = cantidadEspaciosVacios();
        if(this.reglas.puedoAgregarCartasAColumna(columnaOrigen, columnaDestino, espaciosVacios)){
            columnaOrigen.cambiarDeColumna(columnaDestino, indiceCartaOrigen);
        }
    }


    public void jugadaAuxiliarAColumna(int indiceAuxiliar, int indiceColumnaDestino){
        if (this.reglas.puedoSacarCartaDelAuxiliar(auxiliares[indiceAuxiliar])) {
            Carta cartaAuxiliar = this.auxiliares[indiceAuxiliar].verUltimaCarta();
            Palo paloCarta = cartaAuxiliar.obtenerPalo();
            int numeroCarta = cartaAuxiliar.obtenerNumero();
            if (reglas.puedoAgregarCarta(numeroCarta, paloCarta, this.tablero[indiceColumnaDestino])) {
                this.auxiliares[indiceAuxiliar].cambiarAColumna(this.tablero[indiceColumnaDestino]);
            }
        }
    }
    public void jugadaColumnaAAuxiliar(int indiceColumnaOrigen, int indiceAuxiliar){
        Carta cartaAuxiliar = this.tablero[indiceColumnaOrigen].verUltimaCarta();
        Palo paloCarta = cartaAuxiliar.obtenerPalo();
        int numeroCarta = cartaAuxiliar.obtenerNumero();
        if (reglas.puedoAgregarCartaDelAuxiliar(auxiliares[indiceAuxiliar])) {
            this.tablero[indiceColumnaOrigen].cambiarAStackDeCartas(auxiliares[indiceAuxiliar]);
        }
    }
    public void jugadaAuxiliarAFundacion(int indiceAuxiliar, int indiceFundacion) {
        if (this.reglas.puedoSacarCartaDelAuxiliar(auxiliares[indiceAuxiliar])) {
            Fundacion fundacionDestino = this.fundaciones[indiceFundacion];
            Carta carta = auxiliares[indiceAuxiliar].verUltimaCarta();
            int numeroCartaAAgregar = this.auxiliares[indiceAuxiliar].verUltimaCarta().obtenerNumero();
            Palo paloCartaAAgregar = this.auxiliares[indiceAuxiliar].verUltimaCarta().obtenerPalo();
            if (this.reglas.puedoAgregarCarta(numeroCartaAAgregar, paloCartaAAgregar, fundacionDestino)) {
                this.auxiliares[indiceAuxiliar].cambiarAStack(fundacionDestino);
            }
        }
    }

    private int cantidadEspaciosVacios(){
        int espaciosVacios = 0;
        for(int i = 0; i < this.CANTIDADDEAUXILIARES; i++){
            if(auxiliares[i].estaVacia()){
                espaciosVacios++;
            }
        }
        for(int i = 0; i < this.CANTIDADDECOLUMNAS; i++){
            if(tablero[i].estaVacia()){
                espaciosVacios++;
            }
        }

        return espaciosVacios;

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
    public void jugadaColumnaAFundacion(int indiceColumnaOrigen, int indiceFundacionDestino) {
        Fundacion fundacionDestino = this.fundaciones[indiceFundacionDestino];
        if (this.reglas.puedoExtraerDeColumna(tablero[indiceColumnaOrigen])) {
            int numeroCartaAAgregar = this.tablero[indiceColumnaOrigen].verUltimaCarta().obtenerNumero();
            Palo paloCartaAAgregar = this.tablero[indiceColumnaOrigen].verUltimaCarta().obtenerPalo();

            if (this.reglas.puedoAgregarCarta(numeroCartaAAgregar, paloCartaAAgregar, fundacionDestino)) {
                this.tablero[indiceColumnaOrigen].cambiarAStackDeCartas(fundacionDestino);
            }
        }

    }

    public void juegoAPuntoDeGanarConCartaEnAuxiliar() {
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
        this.auxiliares[0].agregarCarta(ultimaCarta);
    }

    public void juegoCasiGanado() {
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
        for (int numero = 1; numero < 12; numero++) {//en la fundacion 3 tenemos 11 y solamente falta reina y rey
            Carta carta = new Carta(numero, Palo.PICAS);
            this.fundaciones[3].agregarCarta(carta);
        }
        Carta anteUltimaCarta = new Carta(12, Palo.PICAS);
        anteUltimaCarta.cambiarVisibilidad();
        Carta ultimaCarta = new Carta(13, Palo.PICAS);
        ultimaCarta.cambiarVisibilidad();
        this.tablero[0].agregarCarta(anteUltimaCarta);
        this.tablero[0].agregarCarta(ultimaCarta);
    }
    @Override
    public boolean juegoTerminado() {
        return this.reglas.juegoGanado(this.fundaciones);
    }

    public static FreeCell cargarEstado(String nombreArchivo, VisitorSerializador visitorSerializador) throws IOException, ClassNotFoundException {
        return visitorSerializador.cargarEstadoFreeCell(nombreArchivo);
    }
}
