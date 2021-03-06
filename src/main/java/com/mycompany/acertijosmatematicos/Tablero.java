/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acertijosmatematicos;

import java.util.Optional;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;

public class Tablero extends Pane {
    int fila;
    int columna;
    int contador1;
    int contador2;
    static int anchoTablero= 6;
    static int altoTablero = 6;
    static int contadorRondas=0;
    int TEXT_SIZE = 30;
    String textoRespondida= "Esta pregunta ya se ha respondido, elige otra";
        
    static Text textScore;
    static Text textScore2;
    static Text turnoJugadorPane;
    Logica logica = new Logica();
    
    public Tablero(){        
        colocarCarta();

        // lineas Verticales
         
        for(int i=0; i<altoTablero+ 2; i++) {
           // Line line = new Line(Cuadrante.TAM_CUADRANTE, Cuadrante.TAM_CUADRANTE*i, Cuadrante.TAM_CUADRANTE*7, Cuadrante.TAM_CUADRANTE*i);
            Line line = new Line(Carta.TAM_CUADRANTE*i, Carta.TAM_CUADRANTE, Carta.TAM_CUADRANTE*i, Carta.TAM_CUADRANTE*(anchoTablero+1));
           // this.getChildren().add(line);
            this.getChildren().add(line);                           
        }
        
        // lineas Horizontales
        for(int i=1; i<anchoTablero+ 2; i++) {
            Line line = new Line(Carta.TAM_CUADRANTE, Carta.TAM_CUADRANTE*i, Carta.TAM_CUADRANTE*(altoTablero+1), Carta.TAM_CUADRANTE*i);
            this.getChildren().add(line);
    
        }
        
       
        this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            // try catch para los errores de cuando no se pincha en la cuadricula, cuando no se inserta resultado,,,
            try{
            System.out.println("Mouse clicked X,Y: " +
                mouseEvent.getX() + " : " + mouseEvent.getY());

            int clicX = (int)mouseEvent.getX();
            columna = clicX / Carta.TAM_CUADRANTE;
            int clicY = (int)mouseEvent.getY();
            fila = clicY / Carta.TAM_CUADRANTE;
            System.out.println("Columna: " + columna);
            System.out.println("Fila: " + fila);
            
            //this.getChildren().remove(/*entre la fila y la columna se saca*/)
            
            if(Logica.cuadricula[fila][columna].equals(textoRespondida) ){                
                
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle(null);
                alert.setHeaderText("¡Esta pregunta ya se ha respondido, elige otra!");
            }
            
            //mostrar al ususario una pantalla que muestre la operacion que tiene que realizar cuando pinche en una casilla
            String textoPregunta= (Logica.cuadricula[fila-1][columna-1]); //le resto -1 pq empieza en 0
            System.out.println (textoPregunta);
            TextInputDialog textoPreguntaDialog = new TextInputDialog();
            textoPreguntaDialog.setTitle("¡Resuelve el problema!");
            textoPreguntaDialog.setHeaderText(textoPregunta);
            textoPreguntaDialog.initStyle(StageStyle.UTILITY);
            //guardar valor que mete el usuario 
            Optional <String> respuesta = textoPreguntaDialog.showAndWait();
            System.out.println(respuesta); 
            

            
            comprobarRespuesta(columna, fila, respuesta);



            logica.cambiarJugador();

            //cambiarturno
            mostrarTurnoPantalla();
            
            System.out.println("Turno del Jugador "+logica.turnoJugador);
            System.out.println("Ronda numero:" + contadorRondas);
            terminarJuego();
            
            }       catch (Exception e) {
            System.out.println("Something went wrong.");
        }

        });
    
      
        // Panel para mostrar textos (puntuaciones)
        HBox paneTextScore = new HBox();
        paneTextScore.setTranslateY(100);        
        paneTextScore.setTranslateX(400);                        
        paneTextScore.setMinWidth(logica.puntuacionJ1);
        paneTextScore.setAlignment(Pos.CENTER);
        this.getChildren().add(paneTextScore);

        // Texto de etiqueta para la puntuación
        Text textTitleScore = new Text("Score Player 1: ");
        textTitleScore.setFont(Font.font(TEXT_SIZE));
        textTitleScore.setFill(Color.BLACK);
        // Texto para la puntuación
        
        textScore = new Text(String.valueOf(logica.puntuacionJ1));
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.BLUE);

        // Añadir los textos al panel reservado para ellos 
        paneTextScore.setSpacing(10);
        paneTextScore.getChildren().add(textTitleScore);
        paneTextScore.getChildren().add(textScore);
        
        // Panel para mostrar textos (puntuaciones)
        HBox paneTextScore2 = new HBox();
        paneTextScore2.setTranslateY(180);        
        paneTextScore2.setTranslateX(400);                        
        paneTextScore2.setMinWidth(90);
        paneTextScore2.setAlignment(Pos.CENTER);
        this.getChildren().add(paneTextScore2);

        // Texto de etiqueta para la puntuación
        Text textTitleScore2 = new Text("Score Player 2: ");
        textTitleScore2.setFont(Font.font(TEXT_SIZE));
        textTitleScore2.setFill(Color.BLACK);
        // Texto para la puntuación
        
        textScore2 = new Text(String.valueOf(logica.puntuacionJ2));
        textScore2.setFont(Font.font(TEXT_SIZE));
        textScore2.setFill(Color.BLUE);

        // Añadir los textos al panel reservado para ellos 
        paneTextScore2.setSpacing(10);
        paneTextScore2.getChildren().add(textTitleScore2);
        paneTextScore2.getChildren().add(textScore2);
        
        //turno del jugador
        HBox paneTextScore3 = new HBox();
        paneTextScore3.setTranslateY(20);        
        paneTextScore3.setTranslateX(380);                        
        paneTextScore3.setMinWidth(logica.turnoJugador);
        paneTextScore3.setAlignment(Pos.CENTER);
        this.getChildren().add(paneTextScore3);

        // Texto de etiqueta para la puntuación
        Text textTitleScore3 = new Text("Turno del player: ");
        textTitleScore3.setFont(Font.font(TEXT_SIZE));
        textTitleScore3.setFill(Color.BLACK);
        
        //puntuacion
        turnoJugadorPane = new Text(String.valueOf(logica.turnoJugador));
        turnoJugadorPane.setFont(Font.font(TEXT_SIZE));
        turnoJugadorPane.setFill(Color.BLUE);
        
        // Añadir los textos al panel reservado para ellos 
        paneTextScore3.setSpacing(10);
        paneTextScore3.getChildren().add(textTitleScore3);
        paneTextScore3.getChildren().add(turnoJugadorPane);
        


     
    }
// Metodo para comprobar la respuesta    
    private void comprobarRespuesta(int columna, int fila, Optional <String> respuesta){ 
        //respuesta= Integer.parseInt(respuesta);
        if (respuesta.isPresent()){
                System.out.println("Respuesta del Usuario: " + respuesta.get());
            }
        //Meto en la variable respuestaStr el String de respuesta y luego comparo su int con cuadriculaResp
        String respuestaStr= respuesta.get();
        System.out.println(respuestaStr);
        System.out.println(String.valueOf(Logica.cuadriculaResp[fila-1][columna-1]));
        //convertir a doble
        if (Double.valueOf(respuestaStr) == Logica.cuadriculaResp[fila-1][columna-1]){ 
            System.out.println("acierto");
            Alert alert = new Alert(AlertType.INFORMATION);
            
            Logica.cuadricula [fila-1][columna-1]= textoRespondida;
            alert.setTitle("¡Muy bien!");
            alert.setHeaderText(null);
            alert.setContentText("!Has acertado!");
            Logica.variableResp = true;
            logica.aumentarScore();
            logica.aumentarScore2();
            alert.showAndWait();
            //si la pregunta es acertada, el contador de rondas aumentara uno, 
            //de lo contrario el contador no aumentara y la pregunta podrá volverse a contestar
            contadorRondas++;
        }
    };
    
// Metodo para dibujar el tablero     
    private void colocarCarta(){
        // Creamos un bucle dentro de otro para que genere un bucle de columnas
        for(int i=0; i<anchoTablero; i++) {
            for(int e=0; e<altoTablero; e++) {
                                               
                Carta carta = new Carta();
                carta.setLayoutX(Carta.TAM_CUADRANTE*e+ Carta.TAM_CUADRANTE);
                carta.setLayoutY(Carta.TAM_CUADRANTE*i+ Carta.TAM_CUADRANTE);
                this.getChildren().add(carta);
                
            }
        }    
    }
    public void mostrarTurnoPantalla(){
        turnoJugadorPane.setText (String.valueOf(Logica.turnoJugador));

    }
    
    public void terminarJuego(){
    // contador para cada vez que se acierta, cuando el contador llegue al total de huecos tablero se acaba el juego
        if(contadorRondas== altoTablero * anchoTablero){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            if (Logica.puntuacionJ1>Logica.puntuacionJ2){
            alert.setHeaderText("El juego ha acabado y gana el Player 1");
            System.out.println(contadorRondas);
            }
            if (Logica.puntuacionJ1>Logica.puntuacionJ2){
            alert.setHeaderText("El juego ha acabado y gana el Player 1");
            System.out.println(contadorRondas);
            }

        }

    }
}


