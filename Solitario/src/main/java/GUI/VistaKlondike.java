package GUI;

import Solitario.*;


public class VistaKlondike extends Vista {

    public VistaKlondike(Solitario klondike){
        super(klondike);
    }

    public void mostrar(){
        mostrarMazo(this.solitario.obtenerMazo(), pane,50,50);
        mostrarDescarte(this.solitario.obtenerDescarte(), pane,125,50);
        mostrarFundaciones(this.solitario.obtenerFundaciones(), pane,700,50);
        mostrarColumnas(this.solitario.obtenerTablero(), pane,50, 200);


    }
}
