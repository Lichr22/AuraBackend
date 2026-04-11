package application.repository;

import application.domain.RegistroDiario;

import java.util.Scanner;

public class ActividadSexualRepository {

    Scanner sc = new Scanner(System.in);

    private int idActividad;
    private RegistroDiario registroDiario;
    private Boolean usoPreservativo;
    private Boolean orgasmo;
    private String metodoAdicional;

    // CONSTRUCTORES
    //Vacio
    public ActividadSexualRepository() {
    }

    // Constructor con todos los atributos
    public ActividadSexualRepository(int idActividad, RegistroDiario registroDiario, Boolean usoPreservativo, Boolean orgasmo, String metodoAdicional) {
        this.idActividad = idActividad;
        this.registroDiario = registroDiario;
        this.usoPreservativo = usoPreservativo;
        this.orgasmo = orgasmo;
        this.metodoAdicional = metodoAdicional;
    }

    // Constructor con solo ID
    public ActividadSexualRepository(int idActividad) {
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

    public ActividadSexualRepository createActividadSexual(ActividadSexualRepository actividad){

        System.out.println("Ingrese el id de la actividad sexual");
        int idActividad = sc.nextInt();
        actividad.idActividad = idActividad;
        sc.nextLine();

        System.out.println("¿Se usó preservativo? (true/false)");
        boolean usoPreservativo = sc.nextBoolean();
        actividad.usoPreservativo = usoPreservativo;
        sc.nextLine();

        System.out.println("¿Hubo orgasmo? (true/false)");
        boolean orgasmo = sc.nextBoolean();
        actividad.orgasmo = orgasmo;
        sc.nextLine();

        System.out.println("Ingrese método anticonceptivo adicional");
        String metodoAdicional = sc.nextLine();
        actividad.metodoAdicional = metodoAdicional;

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