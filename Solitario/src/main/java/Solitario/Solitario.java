package Solitario;

import Columna.ColumnaDeJuego;
import StackDeCartas.*;
import Reglas.*;

import java.io.*;


public abstract class Solitario implements Serializable {


    //-----------------------------------------------------Atributos---------------------------------------------------//
    protected Reglas reglas;
    protected Mazo mazo;
    protected Fundacion[] fundaciones;
    protected Descarte descarte;
    protected ColumnaDeJuego[] tablero;

    //-----------------------------------------------------Métodos----------------------------------------------------//
    public abstract void juegoAPuntoDeGanarConCartaEnColumna();

    public abstract void juegoAPuntoDeGanarConCartaEnDescarte();

    public void guardarEstado(String nombreArchivo) throws IOException {

        ObjectOutputStream solitarioSalida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nombreArchivo)));
        solitarioSalida.writeObject(this);
        solitarioSalida.close();

    }

    public static Solitario cargarEstado(String nombreArchivo) throws IOException, ClassNotFoundException{
        ObjectInputStream solitarioEntrada = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nombreArchivo)));
        Solitario solitario = (Solitario) solitarioEntrada.readObject();
        solitarioEntrada.close();
        return solitario;
    }


    public abstract void jugadaColumnaAFundacion(int indiceColumnaOrigen, int indiceFundacionDestino);

    public abstract boolean juegoTerminado();

}
