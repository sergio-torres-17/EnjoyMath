package com.example.enjoymath.Datos.Firebase;

import android.content.Context;

import com.example.enjoymath.Datos.Objetos.Usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class ControlFireDB {
    private final String rutaPartidas  = "/partidas/";
    private final String rutaavancesPersonales = "/avancesPersonales/";
    private final String rutaUsuarios = "/usuarios/";
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private Context context;

    public ControlFireDB(Context context) {
        this.context = context;
        this.database = FirebaseDatabase.getInstance();
    }

    public void crearNuevoUsuario(Usuario usuario){
        escribir(rutaUsuarios+usuario.getUsuario()+"/nombre/", usuario.getNombre());
        escribir(rutaUsuarios+usuario.getUsuario()+"/apellidos/", usuario.getApellidos());
        escribir(rutaUsuarios+usuario.getUsuario()+"/pwd/", usuario.getPass());
        escribir(rutaUsuarios+usuario.getUsuario()+"/online/", "false");
    }
    public void crearNuevoJuegoEnLinea(Usuario usuarioAnfitrión, Usuario usuarioInvitado){
        //Crear puntaje anfitrión
        escribir(rutaPartidas+"/"+usuarioAnfitrión.getUsuario()+"_"+usuarioInvitado.getUsuario()+"/"+new Date().toString()+"/puntaje"+usuarioAnfitrión.getUsuario(), "0");
        //crear puntaje invitado
        escribir(rutaPartidas+"/"+usuarioAnfitrión.getUsuario()+"_"+usuarioInvitado.getUsuario()+"/"+new Date().toString()+"/puntaje"+usuarioAnfitrión.getUsuario(), "0");
        //partida finalizada
        escribir(rutaPartidas+"/"+usuarioAnfitrión.getUsuario()+"_"+usuarioInvitado.getUsuario()+"/"+new Date().toString()+"/partidaFinalizada/", "false");


    }

    public void escribir(String ruta, String valor){
        myRef = database.getReference(ruta);
        myRef.setValue(valor);
    }
}
