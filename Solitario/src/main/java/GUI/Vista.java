package GUI;

import Columna.ColumnaDeJuego;
import ManejoDeArchivos.ManejoDeArchivos;
import StackDeCartas.Descarte;
import StackDeCartas.Fundacion;
import Carta.*;
import Solitario.*;
import StackDeCartas.Mazo;
import StackDeCartas.StackDeCartas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public abstract class Vista {

    final private int ESPACIADOENTRECARTAS = 27;

    final private int SININDICE = -1;

    final private String COLUMNA = "columna";
    final private String FUNDACION = "fundacion";
    final private String DESCARTE = "descarte";

    final private String MAZO = "mazo";

    final private String AUXILIAR = "auxiliar";

    protected Pane pane;

    protected Solitario solitario;

    protected Stage stage;


    protected Vista(Solitario solitario, Stage stage){
        this.pane = new Pane();
        this.solitario = solitario;
        this.stage = stage;
        stage.setFullScreen(true);

    }
    protected void registrarListener(EventHandler<ActionEvent> eventEventHandler){
        for(javafx.scene.Node nodo: this.pane.getChildren()){
            Button boton = (Button) nodo;
            boton.setOnAction(eventEventHandler);
        }
    }



    protected void mostrarColumnas(ColumnaDeJuego[] tablero, Pane pane, int coordenadaX, int coordenadaY){
        for(int columna = 0; columna < tablero.length; columna++){
            mostrarColumna(tablero[columna], pane,columna, coordenadaX,coordenadaY);
            coordenadaX = coordenadaX + 75;
        }

    }

    protected void mostrarColumna(ColumnaDeJuego columna, Pane pane, int indiceEstructura, int coordenadaX, int coordenadaY){
        for(int i = 0; i < columna.obtenerTamanio(); i++){
            mostrarCarta(columna.verCarta(i),pane,COLUMNA,indiceEstructura,i, coordenadaX, coordenadaY);
            coordenadaY = coordenadaY + ESPACIADOENTRECARTAS;
        }
    }

    protected void mostrarFundaciones(Fundacion[] fundaciones, Pane pane, int coordenadaX, int coordenadaY){
        for(int fundacion = 0; fundacion < fundaciones.length; fundacion++){
            mostrarFundacion(fundaciones[fundacion], pane,fundacion, coordenadaX,coordenadaY);
            coordenadaX = coordenadaX + 75;
        }
    }

    protected void mostrarFundacion(Fundacion fundacion,Pane pane,int indiceEstructura, double coordenadaX,double coordenadaY){
        if(!fundacion.estaVacia()) {
            mostrarCarta(fundacion.verUltimaCarta(), pane,FUNDACION,indiceEstructura, SININDICE , coordenadaX, coordenadaY);
        }else{
            Button botonFundacion = new Button();
            pane.getChildren().add(botonFundacion);
            botonFundacion.setLayoutX(coordenadaX);
            botonFundacion.setLayoutY(coordenadaY);
        }
    }

    protected void mostrarCarta(Carta carta, Pane pane, String estructura,int indiceEstructura, int indiceCarta, double coordenadaX, double coordenadaY){
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
        botonCarta.getProperties().put("estructura",estructura );
        botonCarta.getProperties().put("indiceEstructura", indiceEstructura);
        botonCarta.getProperties().put("indiceCarta", indiceCarta);
        pane.getChildren().add(botonCarta);

        botonCarta.setLayoutX(coordenadaX);
        botonCarta.setLayoutY(coordenadaY);

    }
    protected Image devolverImagenCarta(int numero, Palo palo){
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


    protected void mostrarMazo(Mazo mazo, Pane pane, double coordenadaX, double coordenadaY){
        if(!mazo.estaVacia()) {
            mostrarCarta(mazo.verUltimaCarta(), pane,MAZO,SININDICE,SININDICE, coordenadaX, coordenadaY);
        }else{
            Button botonPedirCarta = new Button();
            pane.getChildren().add(botonPedirCarta);
            botonPedirCarta.setLayoutX(coordenadaX);
            botonPedirCarta.setLayoutY(coordenadaY);
        }
    }

    protected void mostrarDescarte(Descarte descarte, Pane pane, int coordenadaX, int coordenadaY){
        if(!descarte.estaVacia()) {
            mostrarCarta(descarte.verUltimaCarta(),pane, DESCARTE,SININDICE,SININDICE,coordenadaX, coordenadaY);
        }
    }

    protected void mostrarStackGenerico(StackDeCartas stack, Pane pane, String nombreEstructura, int indiceEstructura, double coordenadaX, double coordenadaY){
        if(!stack.estaVacia()) {
            mostrarCarta(stack.verUltimaCarta(), pane,nombreEstructura,indiceEstructura,SININDICE, coordenadaX, coordenadaY);
        }else{
            Button botonStack = new Button();
            pane.getChildren().add(botonStack);
            botonStack.setLayoutX(coordenadaX);
            botonStack.setLayoutY(coordenadaY);
        }
    }

    protected void mostrarAuxiliares(StackDeCartas[] auxiliares , Pane pane, double coordenadaX, double coordenadaY){
        for(int auxiliar = 0; auxiliar < auxiliares.length; auxiliar++){
            mostrarStackGenerico(auxiliares[auxiliar], pane,AUXILIAR,auxiliar, coordenadaX,coordenadaY);
            coordenadaX = coordenadaX + 75;
        }
    }

    public void limpiarPantalla(){
        pane.getChildren().clear();
    }

    public abstract void mostrar();
}