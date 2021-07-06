package com.example.enjoymath.Datos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewPropertyAnimatorListener;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.enjoymath.Datos.Firebase.ControlFireDB;
import com.example.enjoymath.Datos.Objetos.Locales.UsuarioLocal;
import com.example.enjoymath.Datos.Objetos.Usuario;
import com.example.enjoymath.MainActivity;
import com.example.enjoymath.Negocio.AccesoMaestro;
import com.example.enjoymath.R;
import com.example.enjoymath.Splash;

import java.util.Date;

public class RegistrarUsuario extends AppCompatActivity {

    private EditText txtNombre,txtApellidos,txtNombreUsuario;
    private Button btnRegistrar;
    private AccesoMaestro am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        this.txtNombre = findViewById(R.id.txtNombre);
        this.txtApellidos = findViewById(R.id.txtApellidos);
        this.txtNombreUsuario = findViewById(R.id.txtUsuario);
        this.btnRegistrar = findViewById(R.id.btnRegistrarUser);
        this.inicializarEventos();
        this.am = new AccesoMaestro(this);

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
        this.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarYGenerar()){
                    am.insertarDatos(new UsuarioLocal(txtNombre.getText().toString(),txtApellidos.getText().toString(),String.valueOf(0), new Date().toString()));
                    ventanita();
                }else{
                    Toast.makeText(RegistrarUsuario.this, "Falta un campo por llenar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean validarYGenerar(){
        if(this.txtNombre.getText().toString().length()>0){
            if(this.txtApellidos.getText().toString().length()>0) {
                this.txtNombreUsuario.setText(this.txtNombre.getText().toString().split(" ")[0].toLowerCase()+"_"+this.txtApellidos.getText().toString().split(" ")[0].toLowerCase());
                return true;
            }
        }
        return false;
    }
    private void ventanita(){
        AlertDialog.Builder cuadrito = new AlertDialog.Builder(this);
        cuadrito.setTitle("Bienvenido(a) amigito(a)!");
        cuadrito.setMessage("Ya puedes jugar");
        cuadrito.setPositiveButton("Aceptar", (dialog, which) -> {
            startActivity(new Intent(RegistrarUsuario.this, Splash.class));
            finish();
        });
        cuadrito.show();
    }
}