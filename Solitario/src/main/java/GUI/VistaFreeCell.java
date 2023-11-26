package GUI;

import Solitario.Solitario;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VistaFreeCell extends Vista{

    public VistaFreeCell(Solitario FreeCell, Stage stage){
        super(FreeCell, stage);
    }

    public void  mostrar(){

        mostrarAuxiliares(this.solitario.obtenerAuxiliares(), pane,100,100);
        mostrarFundaciones(this.solitario.obtenerFundaciones(), pane,700,50);
        mostrarColumnas(this.solitario.obtenerTablero(), pane,50, 200);
        stage.setScene(new Scene(pane,1000,1000));

    }
}
