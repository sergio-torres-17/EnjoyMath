package com.example.enjoymath.Datos.LocalDB;

public class Consultas {
    public static final String NOMBRE_DB = "DB_ENJOY";
    public static String[] NOMBRES_TABLAS = new String[]{"HISTORIAL","USUARIOS","LOGROS","USUARIOS_LOGROS","DIFICULTADES","JUEGOS_NIVELES"},
            INSERCIÓN_NIVELES = new String[] {
                    "INSERT INTO "+NOMBRES_TABLAS[5]+"(ID_NIVEL,DIFICULTAD,PUNTOS) VALUES(1, 'Fácil',10)",
                    "INSERT INTO "+NOMBRES_TABLAS[5]+"(ID_NIVEL,DIFICULTAD,PUNTOS) VALUES(2, 'Fácil',10)",
                    "INSERT INTO "+NOMBRES_TABLAS[5]+"(ID_NIVEL,DIFICULTAD,PUNTOS) VALUES(1, 'Fácil',10)"};
    public static final String
            CREACIÓN_HISTORIAL = "CREATE TABLE "+NOMBRES_TABLAS[0]+"(" +
                    "ID_USUARIO INTEGER," +
                    "NIVEL TEXT," +
                    "PUNTOS_ACUULADOS INTEGER" +
                    "ULTIMO_ACCESO DATETIME)",
            CREACIÓN_USUARIOS_LOCALES = "CREATE TABLE "+NOMBRES_TABLAS[1]+"(" +
                    "ID_USUARIO INTEGER AUTOINCREMENT PRIMARY KEY," +
                    "NOMBRE TEXT," +
                    "APELLIDOS TEXT," +
                    "USUARIO TEXT," +
                    "REGISTRO DATE)",
            CREACIÓN_LOGROS = "CREATE TABLE "+NOMBRES_TABLAS[2]+" (" +
                    "ID_LOGRO INTEGER AUTOINCREMENT PRIMARY KEY," +
                    "NOMBRE_LOGRO TEXT," +
                    "PUNTOS_EQUIVALENTES INTEGER)",
            CREACIÓN_USUARIOS_LOGROS = "CREATE TABLE "+NOMBRES_TABLAS[3]+" (" +
                    "ID_USUARIO INTEGER," +
                    "ID_LOGRO INTEGER," +
                    "FECHA DATETIME)",
            CREACIÓN_JUEGOS_NIVELES = "CREATE TABLE "+NOMBRES_TABLAS[5]+"(" +
                    "ID_JUEGO INTEGER," +
                    "DIFICULTAD TEXT," +
                    "PUNTOS INTEGER)",
            CREACIÓN_VISTA_LOGROS_GENERAL = "CREATE VIEW VISTA_GENERAL" +
                    "AS" +
                    "(SELECT * FROM USUARIOS_LOGROS UL" +
                    "INNER JOIN LOGROS LG " +
                    "ON UL.ID_LOGRO = LG.ID_LOGRO" +
                    "WHERE UL.ID_USUARIO = ?)"
            ;

}
