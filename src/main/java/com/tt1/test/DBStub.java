package com.tt1.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBStub {
    private Map<String, ToDo> tareas = new HashMap<>();
    private List<String> agendaEmails = new ArrayList<>();

    public void crear(ToDo t) {
        tareas.put(t.getNombre(), t);
    }

    public ToDo leer(String nombre) {
        return tareas.get(nombre);
    }

    public void actualizar(ToDo t) {
        tareas.put(t.getNombre(), t);
    }

    public void borrar(String nombre) {
        tareas.remove(nombre);
    }

    public void anadirEmail(String email) {
        agendaEmails.add(email);
    }

    public List<String> obtenerEmails() {
        return agendaEmails;
    }
    
    public List<ToDo> obtenerTodasLasTareas() {
        return new ArrayList<>(tareas.values());
    }
}
