package com.tt1.test;
import java.util.List;

public class Repositorio {
    private DBStub db;

    public Repositorio() {
        this.db = new DBStub();
    }
    
    public Repositorio(DBStub db) {
        this.db = db;
    }

    public ToDo encontrarToDo(String nombre) {
        return db.leer(nombre);
    }

    public void marcarCompletado(String nombre) {
        ToDo t = db.leer(nombre);
        if (t != null) {
            t.setCompletado(true);
            db.actualizar(t);
        }
    }

    public void guardarToDo(ToDo t) {
        if (db.leer(t.getNombre()) != null) {
            db.actualizar(t);
        } else {
            db.crear(t);
        }
    }

    public void guardarEmail(String email) {
        db.anadirEmail(email);
    }
    
    public List<String> obtenerEmails() {
        return db.obtenerEmails();
    }
    
    public List<ToDo> obtenerTodas() {
        return db.obtenerTodasLasTareas();
    }
}