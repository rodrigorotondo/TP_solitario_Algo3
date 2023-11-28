package GUI;

import Solitario.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VistaKlondike extends Vista {

    public VistaKlondike(Solitario klondike, Stage stage){
        super(klondike, stage);
        stage.setScene(new Scene(pane,1000,1000));
    }

    public void mostrar(EventHandler<ActionEvent> pulsarCarta, EventHandler<ActionEvent> pulsarMazo){
        limpiarPantalla();
        mostrarMazo(this.solitario.obtenerMazo(), pane,50,50,pulsarMazo);
        mostrarDescarte(this.solitario.obtenerDescarte(), pane,125,50,pulsarCarta);
        mostrarFundaciones(this.solitario.obtenerFundaciones(), pane,700,50,pulsarCarta);
        mostrarColumnas(this.solitario.obtenerTablero(), pane,50, 200,pulsarCarta);
        stage.show();

    }


}
