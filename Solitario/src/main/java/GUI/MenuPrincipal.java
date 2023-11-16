package GUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class MenuPrincipal extends Application {

    public String obtenerCarpetaAssets(){
        Path directorioActualPath = FileSystems.getDefault().getPath("");
        return directorioActualPath.toAbsolutePath() + "/src/assets/";
    }
    public void iniciarSolitario(String nombreSolitario, Stage stage) throws FileNotFoundException{
        var pane = new Pane();

        var label = new Label();
        if(nombreSolitario.equals("Klondike")){
            label.setText(nombreSolitario);
            stage.setTitle("Solitario " + nombreSolitario);

        }else if(nombreSolitario.equals("FreeCell")){
            label.setText(nombreSolitario);
            stage.setTitle("Solitario " + nombreSolitario);
        }

        pane.getChildren().add(label);
        label.setLayoutX(100);
        label.setLayoutY(100);
        stage.setScene(new Scene(pane,1000,1000));



        mostrarCarta(stage,pane);

    }

    public void mostrarCarta(Stage stage, Pane pane) throws FileNotFoundException {
        Button carta = new Button();



        Image imagenCarta = new Image("file:" + obtenerCarpetaAssets() + "cartas/espadas/1.png" );
        ImageView imagen = new ImageView();

        imagen.setImage(imagenCarta);

        imagen.setFitWidth(50);
        imagen.setFitHeight(100);
        imagen.setPreserveRatio(true);

        imagen.setPreserveRatio(true);



        carta.setGraphic(imagen);

        pane.getChildren().add(carta);

        carta.setLayoutX(200);
        carta.setLayoutY(100);

        Button carta2 = new Button();

        Image imagenCarta2 = new Image("file:" + obtenerCarpetaAssets() + "cartas/corazones/2.png");
        ImageView imagen2 = new ImageView();

        imagen2.setImage(imagenCarta2);

        imagen2.setFitWidth(50);
        imagen2.setFitHeight(100);
        imagen2.setPreserveRatio(true);

        imagen2.setPreserveRatio(true);

        carta2.setGraphic(imagen2);
        pane.getChildren().add(carta2);

        carta2.setLayoutX(100);
        carta2.setLayoutY(133);



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