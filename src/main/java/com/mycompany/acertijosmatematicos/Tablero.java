/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acertijosmatematicos;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Tablero extends Pane {
    
    public Tablero(){
        colocarCarta();
        // lineas Verticales
        //int 
        for(int i=0; i<anchoTablero+ 2; i++) {
           // Line line = new Line(Cuadrante.TAM_CUADRANTE, Cuadrante.TAM_CUADRANTE*i, Cuadrante.TAM_CUADRANTE*7, Cuadrante.TAM_CUADRANTE*i);
            Line line = new Line(Carta.TAM_CUADRANTE*i, Carta.TAM_CUADRANTE, Carta.TAM_CUADRANTE*i, Carta.TAM_CUADRANTE*(altoTablero+1));
           // this.getChildren().add(line);
            this.getChildren().add(line);
            
    
        }
        // lineas Horizontales
      for(int i=0; i<altoTablero+ 2; i++) {
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
    int anchoTablero= 6;
    int altoTablero = 6;
        
}


