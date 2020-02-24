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
        colocarCuadrante();
        // lineas Verticales
        for(int i=0; i<8; i++) {
           // Line line = new Line(Cuadrante.TAM_CUADRANTE, Cuadrante.TAM_CUADRANTE*i, Cuadrante.TAM_CUADRANTE*7, Cuadrante.TAM_CUADRANTE*i);
            Line line = new Line(Cuadrante.TAM_CUADRANTE*i, Cuadrante.TAM_CUADRANTE, Cuadrante.TAM_CUADRANTE*i, Cuadrante.TAM_CUADRANTE*7);
           // this.getChildren().add(line);
            this.getChildren().add(line);
            
    
        }
        // lineas Horizontales
      for(int i=0; i<8; i++) {
            Line line = new Line(Cuadrante.TAM_CUADRANTE, Cuadrante.TAM_CUADRANTE*i, Cuadrante.TAM_CUADRANTE*7, Cuadrante.TAM_CUADRANTE*i);
            this.getChildren().add(line);
    
        }
    
    }
        
    
    private void colocarCuadrante(){
        for(int i=0; i<6; i++) {
            for(int e=0; e<6; e++) {
                                               
                Cuadrante cuadrante = new Cuadrante();
                cuadrante.setLayoutX(Cuadrante.TAM_CUADRANTE*e+ Cuadrante.TAM_CUADRANTE);
                cuadrante.setLayoutY(Cuadrante.TAM_CUADRANTE*i+ Cuadrante.TAM_CUADRANTE);
                this.getChildren().add(cuadrante);
            }
        }    
    }
        
}


