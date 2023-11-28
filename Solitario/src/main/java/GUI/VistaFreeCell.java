package GUI;

import Solitario.Solitario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VistaFreeCell extends Vista{

    public VistaFreeCell(Solitario FreeCell, Stage stage){

        super(FreeCell, stage);
        stage.setScene(new Scene(pane,1000,1000));
    }

    @Override
    public void  mostrar(EventHandler<ActionEvent> pulsarCarta, EventHandler<ActionEvent> pulsarMazo){
        limpiarPantalla();
        mostrarAuxiliares(this.solitario.obtenerAuxiliares(), pane,100,100, pulsarCarta);
        mostrarFundaciones(this.solitario.obtenerFundaciones(), pane,700,50, pulsarCarta);
        mostrarColumnas(this.solitario.obtenerTablero(), pane,50, 200, pulsarCarta);
        stage.show();

    }
}
