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
        
        // alert para parametrizar tablero
        Tablero tablero = new Tablero();
        root.getChildren().add(tablero);
        
        //Logica logica = new Logica();
        Logica.mostrarConsola();
    }

    public static void main(String[] args) {
        launch();
    }

}

/* cosas por hacer 
rellenar el tablero de interrogaciones HECHO
plantear el click sobre los grupos HECHO
pruebecitas que se presenten  HECHO
cronometro para ver quien gana 
parametrizar el tamaño del tablero para poder modificarlo HECHO
hacer que no pueda pincharse fuera del tablero haciendo que, ClicY <= tamañoficha * numfilas y ClicX <= tamañoficha * numcolumnas
cuando se pincha una carta que no pueda pincharse mas 
hacer que el usuario pueda parametrizar el tablero desde el principio
cambiar las cartas cuando se usan
cambiar el texto de la cuadricula cuando se responde
hacer una clase para parametrizar el tablero antes de empezar a jugar
*/