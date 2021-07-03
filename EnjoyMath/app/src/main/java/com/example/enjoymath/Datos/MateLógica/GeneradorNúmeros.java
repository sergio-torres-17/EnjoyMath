package com.example.enjoymath.Datos.MateLógica;

public class GeneradorNúmeros {
    public int númeroAleatorio(int inicioRango, int finRango){
        return (int)Math.floor(Math.random()*(inicioRango-finRango+1)+finRango);
    }
   public float raizCuadrada(float número){
        return (float)Math.sqrt(número);
   }
}
