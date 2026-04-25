package application.domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ActividadSexual {

    Scanner sc = new Scanner(System.in);

    private int idActividad;
    private RegistroDiario registroDiario;
    private Boolean usoPreservativo;
    private Boolean orgasmo;
    private String metodoAdicional;

    // CONSTRUCTORES
    //Vacio
    public ActividadSexual() {
    }

    // Constructor con todos los atributos
    public ActividadSexual(int idActividad, RegistroDiario registroDiario, Boolean usoPreservativo, Boolean orgasmo, String metodoAdicional) {
        this.idActividad = idActividad;
        this.registroDiario = registroDiario;
        this.usoPreservativo = usoPreservativo;
        this.orgasmo = orgasmo;
        this.metodoAdicional = metodoAdicional;
    }

    // Constructor con solo ID
    public ActividadSexual(int idActividad) {
        this.idActividad = idActividad;
    }

    // GETTERS Y SETTERS

    public int getIdActividad() { return idActividad; }

    public void setIdActividad(int idActividad) { this.idActividad = idActividad; }

    public RegistroDiario getRegistroDiario() { return registroDiario; }

    public void setRegistroDiario(RegistroDiario registroDiario) { this.registroDiario = registroDiario; }

    public Boolean getUsoPreservativo() { return usoPreservativo; }

    public void setUsoPreservativo(Boolean usoPreservativo) { this.usoPreservativo = usoPreservativo; }

    public Boolean getOrgasmo() { return orgasmo; }

    public void setOrgasmo(Boolean orgasmo) { this.orgasmo = orgasmo; }

    public String getMetodoAdicional() { return metodoAdicional; }

    public void setMetodoAdicional(String metodoAdicional) { this.metodoAdicional = metodoAdicional; }

    // METODOS
    //Create

    public ActividadSexual createActividadSexual(ActividadSexual actividad){

        System.out.println("Ingrese el id de la actividad sexual");
        try {
            int idActividad = sc.nextInt();
            actividad.idActividad = idActividad;
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: El id debe ser un número entero.");
            sc.nextLine();
            return null;
        }

        System.out.println("¿Se usó preservativo? (true/false)");
        try {
            boolean usoPreservativo = sc.nextBoolean();
            actividad.usoPreservativo = usoPreservativo;
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese 'true' o 'false'.");
            sc.nextLine();
            return null;
        }

        System.out.println("¿Hubo orgasmo? (true/false)");
        try {
            boolean orgasmo = sc.nextBoolean();
            actividad.orgasmo = orgasmo;
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese 'true' o 'false'.");
            sc.nextLine();
            return null;
        }

        System.out.println("Ingrese método anticonceptivo adicional");
        actividad.metodoAdicional = sc.nextLine();

        return actividad;
    }

    //Get

    public void getActividadSexual(int id){

        if(this.idActividad == id){

            System.out.println("Id Actividad: " + this.idActividad + "\n" +
                    "Uso preservativo: " + this.usoPreservativo + "\n" +
                    "Orgasmo: " + this.orgasmo + "\n" +
                    "Metodo adicional: " + this.metodoAdicional + "\n");

        } else {

            System.out.println("Valide el id de la actividad que está consultando");

        }

    }

}