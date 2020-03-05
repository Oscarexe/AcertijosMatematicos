package com.mycompany.acertijosmatematicos;

import java.util.Random;

public class Logica {
    
    String [][] cuadricula = new String[Tablero.anchoTablero][Tablero.altoTablero]; 
    // llenar todo de ecuaciones
    // dos matrices una para las preguntas y otra para las respuestas
    //SUMA: CONCATENAR UN ALEATORIO CON OTRO
    public Logica() {
        // MATRIZ PREGUNTAS
        Random random = new Random();

        
        for(int f=0; f<Tablero.anchoTablero; f++) {
            for(int c=0; c<Tablero.altoTablero; c++) {
                int numero1 = random.nextInt(4);
                int numero2 = random.nextInt(4);
                cuadricula[f][c] = ("SUMA:" +numero1+ ", "+numero2);
            }
        }

    }
        public void mostrarConsola() {
            for(int f=0; f<Tablero.anchoTablero; f++) {
                for(int c=0; c<Tablero.altoTablero; c++) {
                    System.out.print(cuadricula[f][c]);
                }
                System.out.println("");
            }        
        }
}

