package GUI;
import Solitario.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;



public class Controlador {


    protected Vista vista;
    protected Solitario solitario;

    protected final int SININDICE = -1;

    final private String COLUMNA = "columna";
    final private String FUNDACION = "fundacion";
    final private String DESCARTE = "descarte";

    final private String MAZO = "mazo";

    final private String AUXILIAR = "auxiliar";

    protected Boolean esperandoDestino;

    protected String estructuraOrigen;
    protected int indiceEstructuraOrigen;
    protected String estructuraDestino;
    protected int indiceEstructuraDestino;

    protected int indiceCarta;


    public Controlador(Solitario solitario, Vista vistar){
        this.solitario = solitario;
        this.vista = vista;
        this.esperandoDestino = false;
    }

    public void iniciar(){

        vista.registrarListener(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button botonFuente = (Button) actionEvent.getSource();
                String estructura = (String) botonFuente.getProperties().get("estructura");
                int indiceEstructura = (int) botonFuente.getProperties().get("indiceEstructura");
                int indiceCarta = (int) botonFuente.getProperties().get("indiceCarta");
                if(esperandoDestino){
                    setDestino(estructura,indiceEstructura);
                }
                else{
                    setOrigen(estructura,indiceEstructura,indiceCarta);
                }



            }
        });
    }

    public void setOrigen(String estructuraOrigen, int indiceOrigen, int indiceCarta){
        this.esperandoDestino = true;
        this.estructuraOrigen = estructuraOrigen;
        this.indiceEstructuraOrigen = indiceOrigen;
        this.indiceCarta = indiceCarta;

    }


    public void setDestino(String estructuraDestino, int indiceEstructuraDestino){
        this.esperandoDestino = false;
        this.estructuraDestino = estructuraDestino;
        this.indiceEstructuraDestino= indiceEstructuraDestino;
        try {
            procesar(estructuraOrigen, indiceEstructuraOrigen, indiceCarta, this.estructuraDestino, this.indiceEstructuraDestino);
        }catch(Exception e){
            //aca deberiamos llamar a la vista y pasarle el error para que lo visualice
        }
    }

    public void procesar(String estructuraOrigen,int indiceEstructuraOrigen,int indiceCarta, String estructuraDestino, int indiceEstructuraDestino) throws Exception {

        switch(estructuraOrigen){
            case COLUMNA:
                procesarMovimientosColumna(indiceEstructuraOrigen,indiceCarta, estructuraDestino, indiceEstructuraDestino);
                break;

            case FUNDACION: // la fundacion solo puede mover a columna
                solitario.jugadaFundacionAColumna(indiceEstructuraDestino,indiceEstructuraOrigen);

            case DESCARTE:
                procesarMovimientosDescarte(estructuraDestino,indiceEstructuraDestino);
                break;

            case AUXILIAR:
                procesarMovimientosAuxiliar(indiceEstructuraOrigen,estructuraDestino,indiceEstructuraDestino);

        }

    }


    private void procesarMovimientosColumna(int indiceEstructuraOrigen,int indiceCarta, String estructuraDestino, int indiceEstructuraDestino) throws Exception {
        switch(estructuraDestino){
            case COLUMNA:
                solitario.jugadaColumnaAColumna(indiceEstructuraDestino,indiceEstructuraOrigen,indiceCarta);
                break;

            case FUNDACION:
                solitario.jugadaColumnaAFundacion(indiceEstructuraOrigen,indiceEstructuraDestino);
                break;

            case AUXILIAR:
                solitario.jugadaColumnaAAuxiliar(indiceEstructuraOrigen,indiceEstructuraDestino);
                break;


        }
    }

    private void procesarMovimientosDescarte(String estructuraDestino, int indiceEstructuraDestino) throws Exception {
        switch(estructuraDestino){
            case COLUMNA:
                solitario.jugadaDescarteColumna(indiceEstructuraDestino);
                break;
            case FUNDACION:
                solitario.jugadaDescarteFundacion(indiceEstructuraDestino);
        }
    }

    private void procesarMovimientosAuxiliar(int indiceEstructuraOrigen, String estructuraDestino, int indiceEstructuraDestino) throws Exception {
        switch(estructuraDestino){
            case COLUMNA:
                solitario.jugadaAuxiliarAColumna(indiceEstructuraOrigen,indiceEstructuraDestino);
                break;

            case FUNDACION:
                solitario.jugadaAuxiliarAFundacion(indiceEstructuraOrigen,indiceEstructuraDestino);
        }
    }


}
