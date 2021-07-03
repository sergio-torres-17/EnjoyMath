package com.example.enjoymath.Datos.Objetos.Locales;

public class Historial {
    private int idUsuario, puntosAcumulados;
    private String nivel;
    private String ultimoAcceso;

    public Historial(int puntosAcumulados, String nivel, String ultimoAcceso) {
        this.puntosAcumulados = puntosAcumulados;
        this.nivel = nivel;
        this.ultimoAcceso = ultimoAcceso;
    }

    public Historial(int idUsuario, int puntosAcumulados, String nivel, String ultimoAcceso) {
        this.idUsuario = idUsuario;
        this.puntosAcumulados = puntosAcumulados;
        this.nivel = nivel;
        this.ultimoAcceso = ultimoAcceso;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(String ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
}
