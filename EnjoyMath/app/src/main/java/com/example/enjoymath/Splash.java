package com.example.enjoymath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.enjoymath.Datos.RegistrarUsuario;
import com.example.enjoymath.Negocio.AccesoMaestro;

public class Splash extends AppCompatActivity {
    private AccesoMaestro am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.am = new AccesoMaestro(this);
        //this.deleteDatabase("DB_ENJOY");
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    if(am.validarPrimerArranque()){
                        am.insertarNiveles();
                        Intent intent= new Intent(Splash.this, RegistrarUsuario.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Intent intent= new Intent(Splash.this, MenuPrincipal.class);
                        intent.putExtra("idUsuario", am.devolverIdActivo());
                        startActivity(intent);
                        finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        hilo.start();

    }
}