package Solitario;

import Carta.Palo;
import Columna.ColumnaDeJuego;
import StackDeCartas.*;
import Reglas.*;

import java.io.*;


public abstract class Solitario implements Serializable {


    //-----------------------------------------------------Atributos---------------------------------------------------//
    protected int CANTIDADDEFUNDACIONES;

    protected int CANTIDADDECOLUMNAS;
    protected Reglas reglas;
    protected Mazo mazo;
    protected Fundacion[] fundaciones;


    protected ColumnaDeJuego[] tablero;

    //-----------------------------------------------------Métodos----------------------------------------------------//
    protected void iniciarFundaciones(){
        for (int i = 0; i < CANTIDADDEFUNDACIONES; i++){
            fundaciones[i] = new Fundacion();
        }
    }

    protected void iniciarColumnas(){
        for (int i = 0; i < CANTIDADDECOLUMNAS; i++){
            tablero[i] = new ColumnaDeJuego();
        }
    }

    protected abstract void iniciarMesa();

    public abstract void juegoAPuntoDeGanarConCartaEnColumna();

    public abstract void juegoAPuntoDeGanarConCartaEnDescarte();

    public void guardarEstado(String nombreArchivo, VisitorSerializador visitorSerializador) throws IOException {

        visitorSerializador.guardarEstado(this, nombreArchivo);

    }


    public void jugadaColumnaAFundacion(int indiceColumnaOrigen, int indiceFundacionDestino) {

        Fundacion fundacionDestino = this.fundaciones[indiceFundacionDestino];
        if (this.reglas.puedoExtraerDeColumna(tablero[indiceColumnaOrigen])) {
            int numeroCartaAAgregar = this.tablero[indiceColumnaOrigen].obtenerUltimaCarta().obtenerNumero();
            Palo paloCartaAAgregar = this.tablero[indiceColumnaOrigen].obtenerUltimaCarta().obtenerPalo();

            if (this.reglas.puedoAgregarCarta(numeroCartaAAgregar, paloCartaAAgregar, fundacionDestino)) {
                this.tablero[indiceColumnaOrigen].cambiarAFundacion(fundacionDestino);
            }
        }
    }

    public abstract boolean juegoTerminado();

}
