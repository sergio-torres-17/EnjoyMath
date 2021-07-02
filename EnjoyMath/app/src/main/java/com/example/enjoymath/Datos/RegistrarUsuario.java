package com.example.enjoymath.Datos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewPropertyAnimatorListener;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListAdapter;

import com.example.enjoymath.Datos.Firebase.ControlFireDB;
import com.example.enjoymath.Datos.Objetos.Usuario;
import com.example.enjoymath.MainActivity;
import com.example.enjoymath.R;

public class RegistrarUsuario extends AppCompatActivity {

    private EditText txtNombre,txtApellidos,txtNombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        this.txtNombre = findViewById(R.id.txtNombre);
        this.txtApellidos = findViewById(R.id.txtApellidos);
        this.txtNombreUsuario = findViewById(R.id.txtUsuario);
        this.inicializarEventos();
        new ControlFireDB(this).crearNuevoUsuario(new Usuario("Sergio Saúl","Torres Ibarra","sergio_torres", "12345"));
        new ControlFireDB(this).crearNuevoUsuario(new Usuario("Ana Cristina","Argote Gasca","ana_argote", "54321"));
    }
    private void inicializarEventos(){
        this.txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validarYGenerar();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        this.txtApellidos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validarYGenerar();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void validarYGenerar(){
        if(this.txtNombre.getText().toString().length()>0){
            if(this.txtApellidos.getText().toString().length()>0) {
                this.txtNombreUsuario.setText(this.txtNombre.getText().toString().split(" ")[0].toLowerCase()+"_"+this.txtApellidos.getText().toString().split(" ")[0].toLowerCase());
            }
        }
    }
}