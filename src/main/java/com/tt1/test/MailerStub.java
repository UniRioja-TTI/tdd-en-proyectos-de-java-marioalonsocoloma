package com.tt1.test;

public class MailerStub implements IMailer {
    @Override
    public boolean enviarCorreo(String direccion, String mensaje) {
        System.out.println("Enviando a: " + direccion + " -> " + mensaje);
        return true;
    }
}