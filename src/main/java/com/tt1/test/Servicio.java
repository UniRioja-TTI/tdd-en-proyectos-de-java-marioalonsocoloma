package com.tt1.test;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Servicio {
    private Repositorio repositorio;
    private IMailer mailer;

    public Servicio() {
        this.repositorio = new Repositorio();
        this.mailer = new MailerStub();
    }
    
    public Servicio(Repositorio repo, IMailer mailer) {
        this.repositorio = repo;
        this.mailer = mailer;
    }

    public void crearNuevaTarea(String nombre, LocalDate fecha) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        
        ToDo t = new ToDo();
        t.setNombre(nombre);
        t.setFechaLimite(fecha);
        t.setCompletado(false);
        
        repositorio.guardarToDo(t);
        comprobarAlertas();
    }

    public void registrarEmail(String email) {
        repositorio.guardarEmail(email);
        comprobarAlertas();
    }

    public void finalizarTarea(String nombre) {
        repositorio.marcarCompletado(nombre);
        comprobarAlertas();
    }

    public List<ToDo> listarTareasPendientes() {
        List<ToDo> todas = repositorio.obtenerTodas();
        List<ToDo> pendientes = new ArrayList<>();
        
        for (ToDo t : todas) {
            if (!t.isCompletado()) {
                pendientes.add(t);
            }
        }
        
        comprobarAlertas();
        return pendientes;
    }
    
    private void comprobarAlertas() {
        List<ToDo> tareas = repositorio.obtenerTodas();
        List<String> emails = repositorio.obtenerEmails();
        LocalDate hoy = LocalDate.now();
        
        for (ToDo t : tareas) {
            if (!t.isCompletado() && t.getFechaLimite().isBefore(hoy)) {
                for (String email : emails) {
                    mailer.enviarCorreo(email, "ALERTA: Tarea caducada " + t.getNombre());
                }
            }
        }
    }
}