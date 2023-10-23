package Solitario;

import Carta.*;
import Columna.*;
import Reglas.*;
import StackDeCartas.*;
public class FreeCell extends Solitario {

    final private int CANTIDADDEAUXILIARES = 4;
    private StackDeCartas[] auxiliares;

    public FreeCell(){
        CANTIDADDEFUNDACIONES = 4;
        CANTIDADDECOLUMNAS = 8;
        this.mazo = new Mazo();
        this.fundaciones = new Fundacion[CANTIDADDEFUNDACIONES];
        this.iniciarFundaciones();
        this.tablero = new ColumnaDeJuego[CANTIDADDECOLUMNAS];
        this.iniciarColumnas();
        this.auxiliares = new StackDeCartas[CANTIDADDEAUXILIARES];
        this.reglas = new ReglasFreeCell();

    }

    protected void iniciarAuxiliares(){
        for (int i = 0; i < CANTIDADDEAUXILIARES; i++){
            auxiliares[i] = new StackDeCartas();
        }
    }

    private void repartirCartas(){
        while(!this.mazo.estaVacia()){
            for(int i = 0; i < CANTIDADDEAUXILIARES; i++){
                Carta cartaAAgregar = this.mazo.robarUltimaCarta();
                this.auxiliares[i].agregarCarta(cartaAAgregar);
            }
        }
    }


    @Override
    protected void iniciarMesa() {
        this.mazo.mezclarMazo();
        this.repartirCartas();

    }

    @Override
    public void juegoAPuntoDeGanarConCartaEnColumna() {

    }

    @Override
    public void juegoAPuntoDeGanarConCartaEnDescarte() {

    }



    @Override
    public boolean juegoTerminado() {
        return false;
    }


}
