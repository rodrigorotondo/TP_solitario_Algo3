package Carta;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.io.Serializable;
import ManejoDeArchivos.ManejoDeArchivos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Carta implements Serializable {

    //-----------------------------------------------------Atributos---------------------------------------------------//
    private final int numero;
    private final Palo palo;
    private boolean bocaArriba;

    private Image imagen;

    //-----------------------------------------------------Metodos---------------------------------------------------//
    public Carta(int numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
        this.bocaArriba = false;
        imagen = devolverImagen(numero,palo);
    }
    public boolean esVisible(){
        return bocaArriba;
    }
    public void cambiarVisibilidad(){
        this.bocaArriba = !this.bocaArriba;
    }
    public Color obtenerColor(){
        return this.palo.obtenerColor();
    }
    public Palo obtenerPalo(){
        return this.palo;
    }
    public int obtenerNumero(){
        return this.numero;
    }
    public boolean esPosterior(int numeroCarta){
        return this.numero == (numeroCarta + 1);
    }
    public boolean esAnterior(int numeroCarta){
        return (this.numero) == (numeroCarta - 1);
    }
    public boolean esMismoPalo(Palo paloCarta){
        return this.palo == paloCarta;
    }

    private Image devolverImagen(int numero, Palo palo){
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

    public void mostrarCarta(Pane pane, double coordenadaX, double coordenadaY){
        ImageView imagenCarta = new ImageView();
        if(this.bocaArriba){

            imagenCarta.setImage(this.imagen);
        }else{
            imagenCarta.setImage(new Image("file:" + ManejoDeArchivos.obtenerCarpetaAssets() + "cartas/dorso/card_back.png"));

        }


        Button carta = new Button();
        imagenCarta.setFitWidth(50);
        imagenCarta.setFitHeight(100);
        imagenCarta.setPreserveRatio(true);

        imagenCarta.setPreserveRatio(true);

        carta.setGraphic(imagenCarta);

        pane.getChildren().add(carta);

        carta.setLayoutX(coordenadaX);
        carta.setLayoutY(coordenadaY);

    }
}
