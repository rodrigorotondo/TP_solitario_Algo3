package GUI;

import Solitario.Solitario;
import javafx.scene.layout.Pane;

public class VistaFreeCell extends Vista{

    public VistaFreeCell(Solitario FreeCell){
        super(FreeCell);
    }

    public void  mostrar(Pane pane){

        mostrarAuxiliares(this.solitario.obtenerAuxiliares(), pane,100,100);
        mostrarFundaciones(this.solitario.obtenerFundaciones(), pane,700,50);
        mostrarColumnas(this.solitario.obtenerTablero(), pane,50, 200);

    }
}
