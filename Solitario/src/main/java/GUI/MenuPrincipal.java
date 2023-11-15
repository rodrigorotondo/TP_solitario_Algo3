package GUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;




public class MenuPrincipal extends Application {

    public void iniciarSolitario(String nombreSolitario, Stage stage){
        var stackPane = new StackPane();

        var label = new Label();
        if(nombreSolitario.equals("Klondike")){
            label.setText(nombreSolitario);
            stage.setTitle("Solitario " + nombreSolitario);

        }else if(nombreSolitario.equals("FreeCell")){
            label.setText(nombreSolitario);
            stage.setTitle("Solitario " + nombreSolitario);
        }

        stackPane.getChildren().add(label);
        stage.setScene(new Scene(stackPane,300,300));

        stage.show();

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
                iniciarSolitario(opcionElegida,stage);



            }
        };

        opcionKlondike.setOnAction(pulsarBoton);
        opcionFreeCell.setOnAction(pulsarBoton);
        stage.setScene(scene);
        stage.show();
    }
}