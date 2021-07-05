package com.example.enjoymath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.enjoymath.Datos.MateLógica.ControlGeneral;
import com.example.enjoymath.Datos.Objetos.Locales.Historial;
import com.example.enjoymath.Negocio.AccesoMaestro;

public class Facil extends AppCompatActivity {

    private int idUser, idJuego;
    private String dificultad;
    private Historial miHistorial;
    private AccesoMaestro am;
    private TextView pregunta;
    private ImageButton r1,r2,r3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);
        this.idUser = getIntent().getExtras().getInt("idUsuario");
        this.am = new AccesoMaestro(Facil.this);
        this.miHistorial = this.am.devolverHistorial(this.idUser);
        this.idJuego = this.miHistorial.getNivel();
        this.pregunta= findViewById(R.id.txtPregunta);
        this.r1 = findViewById(R.id.btnRespuesta1);
        this.r2 = findViewById(R.id.btnRespuesta2);
        this.r3 = findViewById(R.id.btnRespuesta3);
        new ControlGeneral(this.miHistorial, Facil.this).métodoMaestro(pregunta, r1,r2,r3, this.miHistorial.getNivel());
    }
}