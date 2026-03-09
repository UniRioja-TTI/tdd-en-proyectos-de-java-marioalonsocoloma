package com.tt1.test.mock;

import com.tt1.test.IMailer;

public class MackMailer implements IMailer {
    
    public boolean haSidoLlamado = false;
    public String direccionDestino = "";
    public String mensajeContenido = "";

    @Override
    public boolean enviarCorreo(String direccion, String mensaje) {
        this.haSidoLlamado = true;
        this.direccionDestino = direccion;
        this.mensajeContenido = mensaje;
        return true;
    }
}
