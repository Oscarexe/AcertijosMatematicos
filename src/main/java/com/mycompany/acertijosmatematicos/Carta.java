/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acertijosmatematicos;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Oscar
 */
public class Carta extends Group {
    static final short TAM_CUADRANTE= 40;
    Image interrogacion = new Image(getClass().getResourceAsStream("/Images/interrogacion.jpg"));
    ImageView imgInterrogacion  = new ImageView (interrogacion);
    
    //Metodo Constructor
    public Carta(){
        // Cambiar tamaño img interrogacion
        imgInterrogacion.setFitWidth (TAM_CUADRANTE);
        imgInterrogacion.setFitHeight(TAM_CUADRANTE);
        Rectangle rectangle = new Rectangle(TAM_CUADRANTE, TAM_CUADRANTE); 

        // esta clase esta definida como grupo asi que ponemos this.getChildren() para 
        // añadir directamente al grupo
        this.getChildren().add(rectangle);
        this.getChildren().add(imgInterrogacion);
    }
    
}
