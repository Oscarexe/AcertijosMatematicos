/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acertijosmatematicos;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Tablero extends Pane {
    int fila;
    int columna;
    
    public Tablero(){
        colocarCarta();
        // lineas Verticales
         
        for(int i=0; i<anchoTablero+ 2; i++) {
           // Line line = new Line(Cuadrante.TAM_CUADRANTE, Cuadrante.TAM_CUADRANTE*i, Cuadrante.TAM_CUADRANTE*7, Cuadrante.TAM_CUADRANTE*i);
            Line line = new Line(Carta.TAM_CUADRANTE*i, Carta.TAM_CUADRANTE, Carta.TAM_CUADRANTE*i, Carta.TAM_CUADRANTE*(altoTablero+1));
           // this.getChildren().add(line);
            this.getChildren().add(line);                           
        }
        int my;
        this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            System.out.println("Mouse clicked X,Y: " +
                    mouseEvent.getX() + " : " + mouseEvent.getY());
            int clicX = (int)mouseEvent.getX();
            columna = clicX / Carta.TAM_CUADRANTE;
            int clicY = (int)mouseEvent.getY();
            fila = clicY / Carta.TAM_CUADRANTE;
            System.out.println("Columna: " + columna);
            System.out.println("Fila: " + fila);
            //mostrar al ususario una pantalla que muestre la operacion que tiene que realizar cuando pinche en una casilla
            //gracias a las variables fila/columna cuadricula[fila][columna] TENGO QUE ARREGLAR ESTO
           System.out.println(Logica.cuadricula[fila][columna]);

        });
        // lineas Horizontales
      for(int i=1; i<altoTablero+ 2; i++) {
            Line line = new Line(Carta.TAM_CUADRANTE, Carta.TAM_CUADRANTE*i, Carta.TAM_CUADRANTE*(anchoTablero+1), Carta.TAM_CUADRANTE*i);
            this.getChildren().add(line);
    
        }
    
    }
        
// Metodo para dibujar el tablero     
    private void colocarCarta(){
        for(int i=0; i<altoTablero; i++) {
            for(int e=0; e<anchoTablero; e++) {
                                               
                Carta carta = new Carta();
                carta.setLayoutX(Carta.TAM_CUADRANTE*e+ Carta.TAM_CUADRANTE);
                carta.setLayoutY(Carta.TAM_CUADRANTE*i+ Carta.TAM_CUADRANTE);
                this.getChildren().add(carta);
                
            }
        }    
    }
    static int anchoTablero= 5;
    static int altoTablero = 5;
        
}


