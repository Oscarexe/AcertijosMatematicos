package com.mycompany.acertijosmatematicos;

import java.util.Random;
import javafx.scene.control.Alert;

public class Logica {
    
    static String [][] cuadricula = new String[Tablero.anchoTablero][Tablero.altoTablero];
    static double [][] cuadriculaResp = new double[Tablero.anchoTablero][Tablero.altoTablero];
    
    static char turnoJugador = '1';
    final char JUGADOR_1 = '1';
    final char JUGADOR_2 = '2';
    static int puntuacionJ1= 0;
    static int puntuacionJ2= 0;
    static boolean variableResp;
    // llenar todo de ecuaciones
    // dos matrices una para las preguntas y otra para las respuestas
    //SUMA: CONCATENAR UN ALEATORIO CON OTRO
    public Logica() {
        // MATRIZ PREGUNTAS
        Random random = new Random();

        
        for(int f=0; f<Tablero.anchoTablero; f++) {
            for(int c=0; c<Tablero.altoTablero; c++) {
                int numero1 = random.nextInt(4)+1;
                int numero2 = random.nextInt(4)+1;
                int numeroAleat = random.nextInt(4);
                switch(numeroAleat){
                
                
                    case 0:
                        cuadricula[f][c] = (numero1+ " + "+numero2); 
                        cuadriculaResp [f][c]= (numero1 + numero2);
                        break;

                    case 1:
                        cuadricula[f][c] = (numero1+ " - "+numero2); 
                        cuadriculaResp [f][c]= (numero1 - numero2);
                        break;

                    case 2:
                        cuadricula[f][c] = (numero1+ " * "+numero2); 
                        cuadriculaResp [f][c]= (numero1 * numero2);
                        break;

                    case 3:
                        cuadricula[f][c] = (numero1+ " / "+numero2); 
                        cuadriculaResp [f][c]= (numero1 / numero2);
                        break;
                }
                
                
            }
        }
        //cuadricula respuestas

    }
        public static void mostrarConsola() {
            for(int f=0; f<Tablero.anchoTablero; f++) {
                for(int c=0; c<Tablero.altoTablero; c++) {
                    System.out.print(cuadricula[f][c]+ "\t"); // eso es para meterle el espacio de una tabulación
                    System.out.print(cuadriculaResp[f][c]+ "\t");

                }
                System.out.println(""); // esto es para que haya saltos de linea 
            }            
        }
        
        public void cambiarJugador() {
            if(turnoJugador == JUGADOR_1) {
                turnoJugador = JUGADOR_2;
               // Tablero.turnoJugadorPane.setText (String.valueOf(turnoJugador));
                
            } else {
                    turnoJugador = JUGADOR_1;
                   // Tablero.turnoJugadorPane.setText (String.valueOf(turnoJugador));

                }
        }

        public void aumentarScore() {
            if (turnoJugador== JUGADOR_1 && variableResp == true ){
                puntuacionJ1+=1;
                Tablero.textScore.setText(String.valueOf(puntuacionJ1));
            }
        }
        public void aumentarScore2() {
            if (turnoJugador== JUGADOR_2 && variableResp == true ){
                 puntuacionJ2+=1;
                Tablero.textScore2.setText(String.valueOf(puntuacionJ2));
            }
        }                                                                                   
}

