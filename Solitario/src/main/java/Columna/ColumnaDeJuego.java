package Columna;

import Carta.*;
import StackDeCartas.*;
import javafx.scene.layout.Pane;


import java.io.Serializable;
import java.util.ArrayList;
public class ColumnaDeJuego implements Serializable {

    //-----------------------------------------------------Atributos---------------------------------------------------//
    private ArrayList<Carta> cartas;
    final private int TOPE = 0;

    final private int ESPACIADOENTRECARTAS = 27;

    //-----------------------------------------------------Métodos----------------------------------------------------//
    public ColumnaDeJuego(){
        this.cartas = new ArrayList<>();
    }
    public boolean estaVacia(){
        return cartas.isEmpty();
    }
    public int obtenerTamanio(){
        return cartas.size();
    }
    public Carta verPrimeraCarta(){
        return cartas.get(TOPE);
    }
    public Carta verUltimaCarta(){
        return cartas.get(indiceUltimaCarta());
    }
    private int indiceUltimaCarta(){
        return (cartas.size()-1);
    }
    public void agregarCarta(Carta carta){
        this.cartas.add(carta);
    }
    private void eliminarCarta(Carta carta){
        this.cartas.remove(carta);
    }
    private void eliminarUltimaCarta(){
        int lastIndex = this.cartas.size() - 1;
        if (lastIndex >= 0) {
            this.cartas.remove(lastIndex);
        }
    }
    public void agregarCartas(ColumnaDeJuego cartasAAgregar){
        for(Carta carta: cartasAAgregar.cartas ){
            this.agregarCarta(carta);
        }
    }
    private void eliminarCartas(ColumnaDeJuego cartasAEliminar){
        for(Carta carta: cartasAEliminar.cartas ){
            this.eliminarCarta(carta);
        }
    }
    public void cambiarDeColumna(ColumnaDeJuego columnaDestino, int indiceCartaTopeQueMuevo){ //osea a partir de la cual quiero mover
        ColumnaDeJuego columnaAuxiliar = new ColumnaDeJuego();

        for(int nroCartaActual = indiceCartaTopeQueMuevo ; nroCartaActual < this.obtenerTamanio() ; nroCartaActual++){
            columnaAuxiliar.agregarCarta(this.cartas.get(nroCartaActual));
        }
        columnaDestino.agregarCartas(columnaAuxiliar);
        this.eliminarCartas(columnaAuxiliar);

        this.cambiarVisibilidadUltimaCarta();
    }
    private void cambiarVisibilidadUltimaCarta(){
        if(!this.estaVacia()){
            if(!this.verUltimaCarta().esVisible()){
                this.verUltimaCarta().cambiarVisibilidad();
            }
        }
    }
    public void cambiarAStackDeCartas(StackDeCartas stack){
        Carta cartaCopia = this.verUltimaCarta();
        stack.agregarCarta(cartaCopia);
        this.eliminarUltimaCarta();
    }
    public boolean esCartaVisible(int indiceCarta){
        return this.cartas.get(indiceCarta).esVisible();
    }

    public void mostrar(Pane pane, double coordenadaX, double coordenadaY){
        for(int i = 0; i < this.obtenerTamanio(); i++){
            this.cartas.get(i).mostrarCarta(pane, coordenadaX, coordenadaY);
            coordenadaY = coordenadaY + ESPACIADOENTRECARTAS;
        }

    }
}
