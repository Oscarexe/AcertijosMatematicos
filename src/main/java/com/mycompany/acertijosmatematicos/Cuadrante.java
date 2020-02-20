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
public class Cuadrante extends Group {
    static final short TAM_CUADRANTE= 40;
    Image interrogacion = new Image(getClass().getResourceAsStream("/Images/interrogacion.png"));
    ImageView ImgViewInterrogacion  = new ImageView (interrogacion);
    
    
    // r.setarcwidth();
    
    //Metodo Constructor
    public Cuadrante(){
    Rectangle rectangle = new Rectangle(TAM_CUADRANTE, TAM_CUADRANTE); 
    
    this.getChildren().add(rectangle);
    this.getChildren().add(ImgViewInterrogacion);
    }
    
}
