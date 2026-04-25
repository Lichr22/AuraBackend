package application.domain;

import application.util.FormValidationUtil;

import java.time.LocalDate;
import java.util.Scanner;

public class Ciclo {

    Scanner sc = new Scanner(System.in);

    private int idCiclo;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int duracionTotal;
    private boolean esRegular;

    // Constructors

    public Ciclo(){

    }

    public Ciclo(int idCiclo, Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin,
                 int duracionTotal, boolean esRegular) {
        this.idCiclo = idCiclo;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.duracionTotal = duracionTotal;
        this.esRegular = esRegular;
    }

    public Ciclo(int idCiclo){
        this.idCiclo = idCiclo;
    }

    // Getters and Setters

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(int duracionTotal) {
        this.duracionTotal = duracionTotal;
    }

    public boolean isEsRegular() {
        return esRegular;
    }

    public void setEsRegular(boolean esRegular) {
        this.esRegular = esRegular;
    }

    // Methods

    public Ciclo createCiclo(Ciclo ciclo){

        try {
            ciclo.idCiclo = FormValidationUtil.validateInt("Ingrese el id del ciclo:");
            ciclo.fechaInicio = FormValidationUtil.validateLocalDate("Ingrese la fecha de inicio");
            ciclo.fechaFin = FormValidationUtil.validateLocalDate("Ingrese la fecha de fin");
            ciclo.duracionTotal = FormValidationUtil.validateInt("Ingrese la duración total del ciclo:");
            ciclo.esRegular = FormValidationUtil.validateBoolean("¿El ciclo es regular? (true/false):");
            return ciclo;
        } catch (Exception e) {
            System.out.println("Error al registrar el ciclo: " + e.getMessage());
            return null;
        }
    }

    public void getCicloById(int id , Ciclo ciclo){

        if(this.idCiclo == id){

            System.out.println("Id Ciclo: " + ciclo.idCiclo + "\n" +
                    "Fecha Inicio: " + ciclo.fechaInicio + "\n" +
                    "Fecha Fin: " + ciclo.fechaFin + "\n" +
                    "Duracion: " + ciclo.duracionTotal + "\n" +
                    "Regular: " + ciclo.esRegular + "\n");

        } else {

            System.out.println("Valide el id del ciclo que está consultando");

        }

    }

}
