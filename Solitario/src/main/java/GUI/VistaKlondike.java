package GUI;

import Solitario.*;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VistaKlondike extends Vista {

    public VistaKlondike(Solitario klondike, Stage stage){
        super(klondike, stage);
    }

    public void mostrar(){
        mostrarMazo(this.solitario.obtenerMazo(), pane,50,50);
        mostrarDescarte(this.solitario.obtenerDescarte(), pane,125,50);
        mostrarFundaciones(this.solitario.obtenerFundaciones(), pane,700,50);
        mostrarColumnas(this.solitario.obtenerTablero(), pane,50, 200);
        stage.setScene(new Scene(pane,1000,1000));

    }
}
