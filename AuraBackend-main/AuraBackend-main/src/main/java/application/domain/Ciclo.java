package application.domain;

import application.util.FormValidationUtil;

import java.time.LocalDate;
import java.util.List;

public class Ciclo {

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

    public Ciclo createCiclo(Ciclo ciclo) {
        try {
            ciclo.idCiclo = FormValidationUtil.validateInt("Ingrese el id del ciclo:");
            ciclo.fechaInicio = FormValidationUtil.validateLocalDate("Ingrese la fecha de inicio");
            ciclo.fechaFin = FormValidationUtil.validateLocalDate("Ingrese la fecha de fin");
            ciclo.duracionTotal = FormValidationUtil.validateInt("Ingrese la duración total del ciclo:");
            ciclo.esRegular = FormValidationUtil.validateBoolean("¿El ciclo es regular? (true/false):");
            System.out.println("Ciclo creado exitosamente.");
            return ciclo;
        } catch (Exception e) {
            System.out.println("Error al registrar el ciclo: " + e.getMessage());
            return null;
        }
    }

    public Ciclo updateCiclo(Ciclo ciclo) {
        try {
            ciclo.fechaInicio = FormValidationUtil.validateLocalDate("Ingrese la nueva fecha de inicio");
            ciclo.fechaFin = FormValidationUtil.validateLocalDate("Ingrese la nueva fecha de fin");
            ciclo.duracionTotal = FormValidationUtil.validateInt("Ingrese la nueva duración total:");
            ciclo.esRegular = FormValidationUtil.validateBoolean("¿El ciclo es regular? (true/false):");
            System.out.println("Ciclo actualizado exitosamente.");
            return ciclo;
        } catch (Exception e) {
            System.out.println("Error al actualizar el ciclo: " + e.getMessage());
            return null;
        }
    }

    public void getCicloById(int id) {
        if (this.idCiclo == id) {
            System.out.println("Id Ciclo: " + this.idCiclo +
                    "\nFecha Inicio: " + this.fechaInicio +
                    "\nFecha Fin: " + this.fechaFin +
                    "\nDuracion: " + this.duracionTotal +
                    "\nRegular: " + this.esRegular + "\n");
        } else {
            System.out.println("Ciclo con id " + id + " no encontrado.");
        }
    }

    public void getAllCiclos(List<Ciclo> ciclos) {
        if (ciclos == null || ciclos.isEmpty()) {
            System.out.println("No hay ciclos registrados.");
            return;
        }
        ciclos.forEach(c -> System.out.println("[" + c.idCiclo + "] " + c.fechaInicio + " - " + c.fechaFin + " | Regular: " + c.esRegular));
    }

    public void deleteCiclo(int id) {
        System.out.println("Ciclo con id " + id + " eliminado.");
    }

}
