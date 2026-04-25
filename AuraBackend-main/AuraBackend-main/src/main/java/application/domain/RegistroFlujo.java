package application.domain;

import application.util.FormValidationUtil;

import java.util.Scanner;

public class RegistroFlujo {

    static Scanner sc = new Scanner(System.in);

    private int idFlujo;
    private RegistroDiario registro;
    private String tipoTextura;
    private String color;
    private String cantidad;

    //CONSTRUCTORES
//Vacio
    public RegistroFlujo() {
    }

    //Con los atributos
    public RegistroFlujo(int idFlujo, RegistroDiario registro, String tipoTextura, String color, String cantidad) {
        this.idFlujo = idFlujo;
        this.registro = registro;
        this.tipoTextura = tipoTextura;
        this.color = color;
        this.cantidad = cantidad;
    }

    //Solo ID
    public RegistroFlujo(int idFlujo) {
        this.idFlujo = idFlujo;
    }

// GETTERS Y SETTERS

    public int getIdFlujo() { return idFlujo; }

    public void setIdFlujo(int idFlujo) { this.idFlujo = idFlujo; }

    public RegistroDiario getRegistro() { return registro; }

    public void setRegistro(RegistroDiario registro) { this.registro = registro; }

    public String getTipoTextura() { return tipoTextura; }

    public void setTipoTextura(String tipoTextura) { this.tipoTextura = tipoTextura; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public String getCantidad() {  return cantidad; }

    public void setCantidad(String cantidad) { this.cantidad = cantidad; }

// METODOS

    public static RegistroFlujo createRegistroFlujo(RegistroFlujo flujo){

        try {
            flujo.idFlujo = FormValidationUtil.validateInt("Ingrese el id del flujo:");
            flujo.tipoTextura = FormValidationUtil.validateString("Ingrese el tipo de textura del flujo:");
            flujo.color = FormValidationUtil.validateString("Ingrese el color del flujo:");
            flujo.cantidad = FormValidationUtil.validateString("Ingrese la cantidad del flujo:");
            return flujo;
        } catch (Exception e) {
            System.out.println("Error al registrar el flujo: " + e.getMessage());
            return null;
        }
    }

//Get

    public void getRegistroFlujo(int id){

        if(this.idFlujo == id){

            System.out.println("Id Flujo: " + this.idFlujo + "\n" +
                    "Tipo de textura: " + this.tipoTextura + "\n" +
                    "Color: " + this.color + "\n" +
                    "Cantidad: " + this.cantidad + "\n");

        } else {

            System.out.println("Valide el id del flujo que está consultando");

        }

    }

}

