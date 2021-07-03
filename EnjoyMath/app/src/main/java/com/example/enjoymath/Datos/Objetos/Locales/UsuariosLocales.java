package com.example.enjoymath.Datos.Objetos.Locales;

public class UsuariosLocales {
    private int idUsuario;
    private String nombre, apellidos, usuario, registro;

    public UsuariosLocales(String nombre, String apellidos, String usuario, String registro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.registro = registro;
    }

    public UsuariosLocales(int idUsuario, String nombre, String apellidos, String usuario, String registro) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.registro = registro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}
