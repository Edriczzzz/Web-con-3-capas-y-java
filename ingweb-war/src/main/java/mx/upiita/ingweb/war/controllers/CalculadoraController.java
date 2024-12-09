package mx.upiita.ingweb.war.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value="calculadoraController")
@SessionScoped
public class CalculadoraController implements Serializable {
    private static final Logger logger = Logger.getLogger(CalculadoraController.class.getName());

    private int numero1;
    private int numero2;
    private int resultado;
    private String tipoOperacion;
    private static final String SUMA="Suma";
    private static final String RESTA="Resta";
    private static final String MULTIPLICACION="Muktiplicar";
    private static final String DIVISION="Dividir";

    private List<SelectItem> listaOperaciones;

    @PostConstruct
    public void init() {
        setNumero1(0);
        setNumero2(0);
        setResultado(0);
        setTipoOperacion(null);
        llenarListaOperaciones();
        logger.log(Level.INFO, "Valores iniciados");
    }

    private void llenarListaOperaciones() {
        listaOperaciones = new ArrayList<>();
        listaOperaciones.add(new SelectItem(SUMA));
        listaOperaciones.add(new SelectItem(RESTA));
        listaOperaciones.add(new SelectItem(MULTIPLICACION));
        listaOperaciones.add(new SelectItem(DIVISION));
    }
    public void realizaOperacion() {
        switch (tipoOperacion) {
            case SUMA -> setResultado(numero1 + numero2);
            case RESTA -> setResultado(numero1 - numero2);
            case MULTIPLICACION -> setResultado(numero1 * numero2);
            case DIVISION ->{
              try{
                  setResultado(numero1 / numero2);
              }  catch(Exception e){
                  FacesMessage fcMensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar operacion", e.getMessage());
                  FacesContext.getCurrentInstance().addMessage(null, fcMensaje);
                  logger.log(Level.SEVERE, "Error al realizar operacion", e.getCause());
              }
            }

        }
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public List<SelectItem> getListaOperaciones() {
        return listaOperaciones;
    }

    public void setListaOperaciones(List<SelectItem> listaOperaciones) {
        this.listaOperaciones = listaOperaciones;
    }
}
