package com.example.enjoymath;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.enjoymath.Datos.Objetos.Locales.Historial;
import com.example.enjoymath.Negocio.AccesoMaestro;

public class MenuPrincipal extends AppCompatActivity {

    private AccesoMaestro am;
    private int id;
    private Historial miHistorial;
    private Button btnMiAprendizaje, btnJugarOnline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        this.am = new AccesoMaestro(this);
        this.id = getIntent().getExtras().getInt("idUsuario");
        this.miHistorial = this.am.devolverHistorial(this.id);
        this.btnMiAprendizaje = findViewById(R.id.btnMiAprendizaje);
        this.btnJugarOnline = findViewById(R.id.btnJuggarConUnAmigo);
        ventanita();
        this.inicializarEventos();
    }
    private void inicializarEventos(){
        this.btnMiAprendizaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirJuegoLocal();
            }
        });
        this.btnJugarOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void ventanita(){
        AlertDialog.Builder cuadrito = new AlertDialog.Builder(this);
        cuadrito.setTitle("Mi información");
        cuadrito.setMessage("Id: "+this.miHistorial.getIdUsuario()+"\n" +
                "Nivel:  "+miHistorial.getNivel()+"\n" +
                "Puntaje: "+miHistorial.getPuntosAcumulados());
        cuadrito.setPositiveButton("Ok", (dialog, which) -> {});
        cuadrito.show();
    }
    private void abrirJuegoLocal(){
        Intent intent = null;
        if(this.miHistorial.getNivel()<=3)
            intent = new Intent(MenuPrincipal.this, Facil.class);
        else if(this.miHistorial.getNivel()>3&&this.miHistorial.getNivel()<=6)
            intent = new Intent(MenuPrincipal.this, Intermedio.class);
        else if (this.miHistorial.getNivel()>6&&this.miHistorial.getNivel()<=9)
            intent = new Intent(MenuPrincipal.this, Dificil.class);
        intent.putExtra("idUsuario", this.id);
        startActivity(intent);
    }
    private void abrirOnline(){
        Intent intent= new Intent(MenuPrincipal.this, Facil.class);
        intent.putExtra("idUsuario", this.id);
        startActivity(intent);
    }
}