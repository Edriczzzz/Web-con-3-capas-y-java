package mx.upiita.ingweb.war.controllers;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value="horaController")
@ViewScoped

// el objeto se crea mientra la vista este disponible
// si estan dos pestañas abiertas, cada una tiene su tipo
public class HoraController implements Serializable {
    private static final Logger logger= Logger.getLogger(HoraController.class.getName());
    //sirve para ver las trazas en el servidor
    private String hora;

    @PostConstruct
    public void init(){
        logger.log(Level.INFO,"Iniciando HORACONTROLLER");
        hora=new GregorianCalendar().getTime().toString();
    }
    public String getHora() {
        return new GregorianCalendar().getTime().toString();
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
