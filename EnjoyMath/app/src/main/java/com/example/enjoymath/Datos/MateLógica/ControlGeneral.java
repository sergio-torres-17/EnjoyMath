package com.example.enjoymath.Datos.MateLógica;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.enjoymath.Datos.Objetos.Locales.Historial;
import com.example.enjoymath.Negocio.AccesoMaestro;
import com.example.enjoymath.R;

public class ControlGeneral {
    private Historial historial;
    private Context context;
    private GeneradorNúmeros genNum;

    public ControlGeneral(Historial historial, Context context) {
        this.historial = historial;
        this.context = context;
        this.genNum = new GeneradorNúmeros();
    }
    public void métodoMaestro(TextView txtPregunta, ImageButton btnR1, ImageButton btnR2, ImageButton btnR3, int contadorJuegos, View.OnClickListener listenerCorrecto){
        int cantidad1, cantidad2, respCorrecta, respInc1,respInc2;
        boolean btn1Usado = false,btn2Usado=false, btn3Usado=false;
                 cantidad1 = num1Preg();
                 cantidad2 = num2Preg();
                 respCorrecta = respCorrecta(contadorJuegos,cantidad1,cantidad2);
                 respInc1 = respIncorrect(respCorrecta);
                 respInc2 = respIncorrect(respCorrecta);
                txtPregunta.setText("¿Cuánto es "+cantidad1+" más "+cantidad2+"?");
        System.out.println("Respuesta correcta: "+respCorrecta+
                "\nRespuesta incorrecta 1: "+respInc1+"\n" +
                "Respuesta correcta 2: "+respInc2);
                int valorSort = Integer.parseInt(genNum.númeroAleatorio(0,3));
                if(valorSort == 1){
                    btnR1.setImageDrawable(this.parseadorNum(respCorrecta));
                    btnR1.setOnClickListener(listenerCorrecto);
                    btn1Usado = true;
                }else if(valorSort == 2){
                    btnR2.setImageDrawable(this.parseadorNum(respCorrecta));
                    btn2Usado = true;
                }else if(valorSort == 3){
                    btnR3.setImageDrawable(this.parseadorNum(respCorrecta));
                    btn3Usado = true;
                }
                if(!btn1Usado){
                    btnR1.setImageDrawable(this.parseadorNum(respInc1));
                    if(!btn2Usado)
                        btnR1.setImageDrawable(this.parseadorNum(respInc2));
                    if(!btn3Usado)
                        btnR3.setImageDrawable(this.parseadorNum(respInc2));
                }else if(!btn2Usado){
                    btnR2.setImageDrawable(this.parseadorNum(respInc1));
                    if(!btn3Usado)
                        btnR3.setImageDrawable(this.parseadorNum(respInc2));
                    if(!btn3Usado)
                        btnR3.setImageDrawable(this.parseadorNum(respInc2));
                }else if(!btn3Usado){
                    btnR2.setImageDrawable(this.parseadorNum(respInc1));
                    if(!btn1Usado)
                        btnR1.setImageDrawable(this.parseadorNum(respInc2));
                    if(!btn2Usado)
                        btnR2.setImageDrawable(this.parseadorNum(respInc2));
                }
    }
    private int num1Preg(){
        return Integer.parseInt(genNum.númeroAleatorio(0,20));
    }
    private int num2Preg(){
        return Integer.parseInt(genNum.númeroAleatorio(0,20));
    }
    private int respCorrecta(int contador,int num1,int num2){

        System.out.println("Contador: "+contador+"\nhistorial.geNivel(): "+historial.getNivel());
        System.err.println(num1+"+"+num2);
        if((contador>0&&contador<3)&&(historial.getNivel()>=1&&historial.getNivel()<=3))
            return num1+num2;
        if((contador>2&&contador<5)&&(historial.getNivel()>=1&&historial.getNivel()<=3))
            return num1-num2;
        if((contador>0&&contador<3)&&(historial.getNivel()>3&&historial.getNivel()<=6))
            return num1*num2;
        if((contador>2&&contador<5)&&(historial.getNivel()>3&&historial.getNivel()<=6))
            return num1/num2;
        if((contador>0&&contador<3)&&(historial.getNivel()>6&&historial.getNivel()<=9))
            return (num1/num2)+(num2/num1);
        else
            return Integer.parseInt(String.valueOf(this.genNum.raizCuadrada((num1+num2))));

    }
    private int respIncorrect(int respCorrect){
        int dev = Integer.parseInt(genNum.númeroAleatorio(0,9));
        while (dev==respCorrect){
            dev = Integer.parseInt(genNum.númeroAleatorio(0,9));
        }
        return dev;
    }
    private Drawable parseadorNum(int num){
        System.out.println("Cantidad dentro del parseador "+num);
        Drawable dev = null;
        switch (num){
            case 1:{
                dev = context.getResources().getDrawable(R.drawable.uno);
                break;
            }
            case 2:{
                dev = context.getResources().getDrawable(R.drawable.dos);
                break;
            }
            case 3:{
                dev = context.getResources().getDrawable(R.drawable.tres);
                break;
            }
            case 4:{
                dev = context.getResources().getDrawable(R.drawable.cuatro);
                break;
            }
            case 5:{
                dev = context.getResources().getDrawable(R.drawable.cinco);
                break;
            }
            case 6:{
                dev = context.getResources().getDrawable(R.drawable.sesi);
                break;
            }
            case 7:{
                dev = context.getResources().getDrawable(R.drawable.siete);
                break;
            }
            case 8:{
                dev =context.getResources().getDrawable(R.drawable.ocho);
                break;
            }
            case 9:{
                dev = context.getResources().getDrawable(R.drawable.nueve);
                break;
            }
            case 10:{
                dev =  context.getResources().getDrawable(R.drawable.diez);
                break;
            }
            case 11:{
                dev = context.getResources().getDrawable(R.drawable.once);
                break;
            }
            case 12:{
                dev = context.getResources().getDrawable(R.drawable.doce);
                break;
            }
            case 13:{
                dev = context.getResources().getDrawable(R.drawable.trece);
                break;
            }
            case 14:{
                dev = context.getResources().getDrawable(R.drawable.catorce);
                break;
            }
            case 15:{
                dev = context.getResources().getDrawable(R.drawable.quince);
                break;
            }
            case 16:{
                dev = context.getResources().getDrawable(R.drawable.dieciseis);
                break;
            }
            case 17:{
                dev = context.getResources().getDrawable(R.drawable.diecisiete);
                break;
            }
            case 18:{
                dev = context.getResources().getDrawable(R.drawable.dieciocho);
                break;
            }
            case 19:{
                dev =context.getResources().getDrawable(R.drawable.diecinueve);
                break;
            }
            case 20:{
                dev =  context.getResources().getDrawable(R.drawable.veinte);
                break;
            }

        }
        return dev;
    }

}
