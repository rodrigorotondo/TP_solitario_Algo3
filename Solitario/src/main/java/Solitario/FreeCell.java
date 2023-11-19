package Solitario;
import Carta.*;
import Columna.*;
import Reglas.*;
import StackDeCartas.*;

import java.io.IOException;
import java.io.InputStream;

public class FreeCell extends Solitario {

    //-----------------------------------------------------Atributos---------------------------------------------------//
    final protected int CANTIDADDEAUXILIARES = 4;
    protected final StackDeCartas[] auxiliares;
    protected ReglasFreeCell reglas;

    //-----------------------------------------------------Métodos----------------------------------------------------//
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
    public FreeCell(Mazo mazo, ReglasFreeCell reglas, int CANTIDADDEFUNDACIONES, int CANTIDADDECOLUMNAS){
        this.CANTIDADDECOLUMNAS = CANTIDADDECOLUMNAS;
        this.CANTIDADDEFUNDACIONES = CANTIDADDEFUNDACIONES;
        asignarMazo(mazo);
        this.fundaciones = new Fundacion[CANTIDADDEFUNDACIONES];
        this.iniciarFundaciones();
        this.tablero = new ColumnaDeJuego[CANTIDADDECOLUMNAS];
        this.iniciarColumnas();
        this.auxiliares = new StackDeCartas[CANTIDADDEAUXILIARES];
        this.iniciarAuxiliares();
        asignarReglas(reglas);
    }
    public void asignarReglas(ReglasFreeCell reglas){
        this.reglas = reglas;
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
    public void jugadaFundacionAColumna(int indiceColumnaDestino, int indiceFundacionOrigen) throws Exception {
        throw new Exception("No se puede mover una carta de una fundacion en una partida FreeCell");
    }
    @Override
    public void jugadaDescarteColumna(int indiceColumnaDestino) throws Exception {
        throw new Exception("No existen descartes en una partida FreeCell");
    }
    @Override
    public void jugadaDescarteFundacion(int indiceFundacion) throws Exception {
        throw new Exception("No existen descartes en una partida FreeCell");
    }
    @Override
    protected void iniciarMesa() {
        this.mazo.mezclarMazo();
        this.repartirCartas();
    }
    public void jugadaColumnaAColumna(int indiceColumnaDestino, int indiceColumnaOrigen, int indiceCartaOrigen) throws Exception {
        ColumnaDeJuego columnaDestino = this.tablero[indiceColumnaDestino];
        ColumnaDeJuego columnaOrigen = this.tablero[indiceColumnaOrigen];
        int espaciosVacios = cantidadEspaciosVacios();
        if(this.reglas.puedoAgregarCartasAColumna(columnaOrigen, columnaDestino, espaciosVacios)){
            columnaOrigen.cambiarDeColumna(columnaDestino, indiceCartaOrigen);
        }
    }
    @Override
    public void jugadaSacarCartaDelMazo() throws Exception {
        throw new Exception("Las cartas ya fueron repartidas");
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
        if (reglas.puedoAgregarCartaAlAuxiliar(auxiliares[indiceAuxiliar])) {
            this.tablero[indiceColumnaOrigen].cambiarAStackDeCartas(auxiliares[indiceAuxiliar]);
        }
    }
    public void jugadaAuxiliarAFundacion(int indiceAuxiliar, int indiceFundacion) {
        if (this.reglas.puedoSacarCartaDelAuxiliar(auxiliares[indiceAuxiliar])) {
            Fundacion fundacionDestino = this.fundaciones[indiceFundacion];
            Carta carta = auxiliares[indiceAuxiliar].verUltimaCarta();
            int numeroCartaAAgregar = carta.obtenerNumero();
            Palo paloCartaAAgregar = carta.obtenerPalo();
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


    @Override
    public boolean juegoTerminado() {
        return this.reglas.juegoGanado(this.fundaciones);
    }
    public static FreeCell cargarEstado(VisitorSerializador visitorSerializador, InputStream in) throws IOException, ClassNotFoundException {
        return visitorSerializador.cargarEstadoFreeCell(in);
    }
}
