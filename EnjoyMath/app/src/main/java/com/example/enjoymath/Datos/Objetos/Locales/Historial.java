package com.example.enjoymath.Datos.Objetos.Locales;

public class Historial {
    private int idUsuario, puntosAcumulados;
    private int nivel;
    private String ultimoAcceso;

    public Historial(int puntosAcumulados, int nivel, String ultimoAcceso) {
        this.puntosAcumulados = puntosAcumulados;
        this.nivel = nivel;
        this.ultimoAcceso = ultimoAcceso;
    }

    public Historial(int idUsuario, int puntosAcumulados, int nivel, String ultimoAcceso) {
        this.idUsuario = idUsuario;
        this.puntosAcumulados = puntosAcumulados;
        this.nivel = nivel;
        this.ultimoAcceso = ultimoAcceso;
    }
    public Historial(String[] infoComillada) {
        this.idUsuario =  Integer.parseInt(infoComillada[0]);
        this.puntosAcumulados = Integer.parseInt(infoComillada[1]);
        this.nivel = Integer.parseInt(infoComillada[2]);
        this.ultimoAcceso = infoComillada[3];
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(String ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
}
