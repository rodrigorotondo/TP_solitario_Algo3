package Solitario;
import Carta.*;
import Columna.*;
import Reglas.*;
import StackDeCartas.*;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class FreeCell extends Solitario {

    //-----------------------------------------------------Atributos---------------------------------------------------//
    final protected int CANTIDADDEAUXILIARES = 4;
    protected final StackDeCartas[] auxiliares;
    protected ReglasFreeCell reglas;

    //-----------------------------------------------------Métodos----------------------------------------------------//
    public FreeCell() {
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
        this.iniciarMesa();
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
        this.iniciarMesa();
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
        int i = 0;
        while(!this.mazo.estaVacia()){
            Carta cartaAAgregar = this.mazo.robarUltimaCarta();
            cartaAAgregar.cambiarVisibilidad();
            this.tablero[i].agregarCarta(cartaAAgregar);

            i++;
            if(i == CANTIDADDECOLUMNAS){
                i = 0;
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

    protected void mostrarAuxiliares(Pane pane, double coordenadaX, double coordenadaY){
        for(int auxiliar = 0; auxiliar < this.CANTIDADDEAUXILIARES; auxiliar++){
            this.auxiliares[auxiliar].mostrar(pane,coordenadaX,coordenadaY);
            coordenadaX = coordenadaX + 75;
        }
    }
    public void  mostrar(Pane pane){

        mostrarAuxiliares(pane,100,100);
        mostrarFundaciones(pane,700,50);
        mostrarColumnas(pane,50, 200);

    }


    @Override
    public boolean juegoTerminado() {
        return this.reglas.juegoGanado(this.fundaciones);
    }
    public static FreeCell cargarEstado(String nombreArchivo, VisitorSerializador visitorSerializador) throws IOException, ClassNotFoundException {
        return visitorSerializador.cargarEstadoFreeCell(nombreArchivo);
    }
}
