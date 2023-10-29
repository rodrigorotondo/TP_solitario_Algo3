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
    protected abstract void iniciarMesa();
    public abstract void juegoAPuntoDeGanarConCartaEnColumna();
    public void guardarEstado(String nombreArchivo, VisitorSerializador visitorSerializador) throws IOException {
        visitorSerializador.guardarEstado(this, nombreArchivo);
    }
    public abstract void jugadaColumnaAFundacion(int indiceColumnaOrigen, int indiceFundacionDestino);
    public abstract boolean juegoTerminado();

}
