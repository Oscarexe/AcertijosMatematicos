package com.mycompany.acertijosmatematicos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root= new StackPane();
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Carta carta = new Carta();
        Tablero tablero = new Tablero();
        root.getChildren().add(tablero);        
    }

    public static void main(String[] args) {
        launch();
    }

}

/* cosas por hacer 
rellenar el tablero de interrogaciones
plantear el click sobre los grupos 
pruebecitas que se presenten 
cronometro para ver quien gana 
hacer dos tableros
parametrizar el tamaño del tablero para poder modificarlo
*/