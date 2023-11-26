package GUI;
import Solitario.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;



public class Controlador {
    private final int SININDICE = -1;
    private Solitario solitario;
    private Vista vista;

    private Boolean esperandoDestino;

    private int origen;
    private int destino;
    private int indice;


    public Controlador(Solitario solitario, Vista vista){
        this.solitario = solitario;
        this.vista = vista;
        this.esperandoDestino = false;
    }

    public void iniciar(){

        vista.registrarListener(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button botonFuente = (Button) actionEvent.getSource();
                int coordenada = (int) botonFuente.getProperties().get("coordenada");
                int indice = (int) botonFuente.getProperties().get("indice");
                if(esperandoDestino){
                    setDestino(coordenada);
                }
                else{
                    if(indice != SININDICE ) {
                        setOrigen(coordenada);
                    }
                }



            }
        });
    }

    public void setOrigen(int origen){
        this.esperandoDestino = true;
        this.origen = origen;

    }
    public void setOrigen(int origen, int indice){
        this.esperandoDestino = true;
        this.origen = origen;
        this.indice = indice;

    }

    public void setDestino(int destino){
        this.esperandoDestino = false;
        this.destino = destino;

    }


}
