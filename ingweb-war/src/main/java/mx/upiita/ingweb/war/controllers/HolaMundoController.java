package mx.upiita.ingweb.war.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named(value= "holaMundoController")
@RequestScoped
public class HolaMundoController {
    private String mensaje;
    private String nombreParam;

    @PostConstruct

    public void iniciacion() {
        mensaje = "Hola Mundo desde un managebean (controller)";
    }

    public void construyeMensaje(){
    mensaje = "Bienvenido al nuevo mundo " + nombreParam;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombreParam() {
        return nombreParam;
    }

    public void setNombreParam(String nombreParam) {
        this.nombreParam = nombreParam;
    }
}
