package com.example.enjoymath.Datos.MateLógica;

public class GeneradorNúmeros {
    public String númeroAleatorio(int inicioRango, int finRango){
        return String.valueOf(Math.round((Math.random()*(inicioRango-finRango+1)+finRango)*100)/100);
    }
   public float raizCuadrada(float número){
        return (float)Math.sqrt(número);
   }
}
