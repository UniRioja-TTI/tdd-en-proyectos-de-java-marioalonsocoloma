package com.tt1.test;
import java.util.ArrayList;
import java.util.List;

public class DBStub {
    private List<ToDo> tareas = new ArrayList<>(); // Colección para CRUD 
    private List<String> agendaEmails = new ArrayList<>(); // Agenda de emails [cite: 35]

    public void crear(ToDo t) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public ToDo leer(String nombre) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public void actualizar(ToDo t) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public void borrar(String nombre) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public void añadirEmail(String email) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public List<String> obtenerEmails() { throw new UnsupportedOperationException("Clase aún no implementada."); }
}
