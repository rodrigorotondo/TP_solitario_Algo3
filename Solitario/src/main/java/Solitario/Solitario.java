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

    public abstract void jugadaFundacionAColumna(int indiceColumnaDestino, int indiceFundacionOrigen) throws Exception;
    public abstract void jugadaColumnaAFundacion(int indiceColumnaOrigen, int indiceFundacionDestino);
    public abstract void jugadaDescarteColumna(int indiceColumnaDestino) throws Exception;

    public abstract void jugadaDescarteFundacion(int indiceFundacion) throws Exception;

    public abstract void jugadaColumnaAColumna (int indiceColumnaDestino, int indiceColumnaOrigen, int indiceCartaOrigen) throws Exception;

    public abstract void jugadaSacarCartaDelMazo() throws Exception;

    public abstract void jugadaColumnaAAuxiliar(int indiceColumnaOrigen, int indiceAuxiliar) throws Exception;

    public abstract void jugadaAuxiliarAColumna(int indiceAuxiliar, int indiceColumnaDestino) throws Exception;

    public abstract void jugadaAuxiliarAFundacion(int indiceAuxiliar, int indiceFundacion) throws Exception;
    protected abstract void iniciarMesa();
    public abstract void juegoAPuntoDeGanarConCartaEnColumna();
    public void guardarEstado(String nombreArchivo, VisitorSerializador visitorSerializador) throws IOException {
        visitorSerializador.guardarEstado(this, nombreArchivo);
    }
    public abstract boolean juegoTerminado();

}
