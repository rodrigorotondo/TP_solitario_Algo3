package GUI;

import Columna.ColumnaDeJuego;
import ManejoDeArchivos.ManejoDeArchivos;
import StackDeCartas.Descarte;
import StackDeCartas.Fundacion;
import Carta.*;
import StackDeCartas.Mazo;
import StackDeCartas.StackDeCartas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

public class Vista {

    final private int ESPACIADOENTRECARTAS = 27;

    private Pane pane;


    public Vista(){
        this.pane = new Pane();
    }
    public void registrarListener(EventHandler<ActionEvent> eventEventHandler){
        for(javafx.scene.Node nodo: this.pane.getChildren()){
            Button boton = (Button) nodo;
            boton.setOnAction(eventEventHandler);
        }
    }



    public void moostrarColumnas(ColumnaDeJuego[] tablero, Pane pane, int coordenadaX, int coordenadaY){
        for(int columna = 0; columna < tablero.length; columna++){
            mostrarColumna(tablero[columna], pane,coordenadaX,coordenadaY);
            coordenadaX = coordenadaX + 75;
        }

    }

    public void mostrarColumna(ColumnaDeJuego columna, Pane pane, int coordenadaX, int coordenadaY){
        for(int i = 0; i < columna.obtenerTamanio(); i++){
            mostrarCarta(columna.verCarta(i),pane, coordenadaX, coordenadaY);
            coordenadaY = coordenadaY + ESPACIADOENTRECARTAS;
        }
    }

    public void mostrarFundaciones(Fundacion[] fundaciones, Pane pane, int coordenadaX, int coordenadaY){
        for(int fundacion = 0; fundacion < fundaciones.length; fundacion++){
            mostrarFundacion(fundaciones[fundacion], pane,coordenadaX,coordenadaY);
            coordenadaX = coordenadaX + 75;
        }
    }

    public void mostrarFundacion(Fundacion fundacion,Pane pane, int coordenadaX,int coordenadaY){
        if(!fundacion.estaVacia()) {
            mostrarCarta(fundacion.verUltimaCarta(), pane, coordenadaX, coordenadaY);
        }else{
            Button botonFundacion = new Button();
            pane.getChildren().add(botonFundacion);
            botonFundacion.setLayoutX(coordenadaX);
            botonFundacion.setLayoutY(coordenadaY);
        }
    }

    public void mostrarCarta(Carta carta, Pane pane, double coordenadaX, double coordenadaY){
        ImageView imagenCarta = new ImageView();
        if(carta.esVisible()){

            imagenCarta.setImage(devolverImagenCarta(carta.obtenerNumero(),carta.obtenerPalo()));
        }else{
            imagenCarta.setImage(new Image("file:" + ManejoDeArchivos.obtenerCarpetaAssets() + "cartas/dorso/card_back.png"));

        }


        Button botonCarta = new Button();
        imagenCarta.setFitWidth(50);
        imagenCarta.setFitHeight(100);
        imagenCarta.setPreserveRatio(true);

        imagenCarta.setPreserveRatio(true);

        botonCarta.setGraphic(imagenCarta);

        pane.getChildren().add(botonCarta);

        botonCarta.setLayoutX(coordenadaX);
        botonCarta.setLayoutY(coordenadaY);

    }
    private Image devolverImagenCarta(int numero, Palo palo){
        return switch (palo) {
            case PICAS ->
                    new Image("file:" + ManejoDeArchivos.obtenerCarpetaAssets() + "cartas/picas/" + numero + ".png");
            case CORAZONES ->
                    new Image("file:" + ManejoDeArchivos.obtenerCarpetaAssets() + "cartas/corazones/" + numero + ".png");
            case DIAMANTES ->
                    new Image("file:" + ManejoDeArchivos.obtenerCarpetaAssets() + "cartas/diamantes/" + numero + ".png");
            default ->
                    new Image("file:" + ManejoDeArchivos.obtenerCarpetaAssets() + "cartas/treboles/" + numero + ".png");
        };
    }


    public void mostrarMazo(Mazo mazo, Pane pane, double coordenadaX, double coordenadaY){
        if(!mazo.estaVacia()) {
            mostrarCarta(mazo.verUltimaCarta(), pane, coordenadaX, coordenadaY);
        }else{
            Button botonPedirCarta = new Button();
            pane.getChildren().add(botonPedirCarta);
            botonPedirCarta.setLayoutX(coordenadaX);
            botonPedirCarta.setLayoutY(coordenadaY);
        }
    }

    public void mostrarDescarte(Descarte descarte, Pane pane, int coordenadaX, int coordenadaY){
        if(!descarte.estaVacia()) {
            mostrarCarta(descarte.verUltimaCarta(),pane, coordenadaX, coordenadaY);
        }
    }

    public void mostrarStackGenerico(StackDeCartas stack, Pane pane, int coordenadaX, int coordenadaY){
        if(!stack.estaVacia()) {
            mostrarCarta(stack.verUltimaCarta(), pane, coordenadaX, coordenadaY);
        }else{
            Button botonStack = new Button();
            pane.getChildren().add(botonStack);
            botonStack.setLayoutX(coordenadaX);
            botonStack.setLayoutY(coordenadaY);
        }
    }
}
