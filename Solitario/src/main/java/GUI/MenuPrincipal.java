package GUI;

import Solitario.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;



public class MenuPrincipal extends Application {


    public void iniciarSolitario(String nombreSolitario, Stage stage) throws FileNotFoundException{

        FabricaDeSolitarios fabricaDeSolitarios;
        FabricaDeVistas fabricaDeVistas;
        Solitario solitario;
        Vista vista;

        var label = new Label();
        if(nombreSolitario.equals("Klondike")){
            fabricaDeSolitarios = new FabricaDeSolitariosKlondike();
            fabricaDeVistas = new FabricaDeVistasKlondike();

        }else{
            label.setText(nombreSolitario);
            fabricaDeSolitarios = new FabricaDeSolitariosFreeCell();
            fabricaDeVistas = new FabricaDeVistasFreeCell();
        }

        solitario = fabricaDeSolitarios.crearSolitario();

        vista = fabricaDeVistas.crearVista(solitario);

        stage.setScene(new Scene(pane,1000,1000));
        stage.setFullScreen(true);





    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Menu Principal");
        var stackPane = new StackPane();




        var opcionKlondike = new MenuItem("Klondike");
        var opcionFreeCell = new MenuItem("FreeCell");


        var menuDesplegable = new MenuButton("Seleccione un solitario");
        menuDesplegable.getItems().addAll(opcionKlondike, opcionFreeCell);

        stackPane.getChildren().add(menuDesplegable);
        stackPane.setAlignment(menuDesplegable, Pos.CENTER);


        var scene = new Scene(stackPane, 640, 500);

        EventHandler<ActionEvent> pulsarBoton = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evento){
                String opcionElegida = ((MenuItem)evento.getSource()).getText();
                menuDesplegable.setText(opcionElegida);
                try {
                    iniciarSolitario(opcionElegida,stage);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }


            }
        };

        opcionKlondike.setOnAction(pulsarBoton);
        opcionFreeCell.setOnAction(pulsarBoton);
        stage.setScene(scene);
        stage.show();
    }
}