package application.domain;

import application.util.FormValidationUtil;

import java.time.LocalDate;
import java.util.List;

public class RegistroDiario {

    private int idRegistro;
    private Usuario usuario;
    private Ciclo ciclo;
    private LocalDate fecha;
    private double temperaturaBasal;
    private double peso;
    private String calidadSueno;
    private String notasLibres;

    // Constructors

    public RegistroDiario() {

    }

    public RegistroDiario(int idRegistro, Usuario usuario, Ciclo ciclo, LocalDate fecha,
                          double temperaturaBasal, double peso,
                          String calidadSueno, String notasLibres) {
        this.idRegistro = idRegistro;
        this.usuario = usuario;
        this.ciclo = ciclo;
        this.fecha = fecha;
        this.temperaturaBasal = temperaturaBasal;
        this.peso = peso;
        this.calidadSueno = calidadSueno;
        this.notasLibres = notasLibres;
    }

    public RegistroDiario(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    // Getters and Setters

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTemperaturaBasal() {
        return temperaturaBasal;
    }

    public void setTemperaturaBasal(double temperaturaBasal) {
        this.temperaturaBasal = temperaturaBasal;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCalidadSueno() {
        return calidadSueno;
    }

    public void setCalidadSueno(String calidadSueno) {
        this.calidadSueno = calidadSueno;
    }

    public String getNotasLibres() {
        return notasLibres;
    }

    public void setNotasLibres(String notasLibres) {
        this.notasLibres = notasLibres;
    }

    // Methods

    public RegistroDiario createRegistro(RegistroDiario registro) {
        try {
            registro.idRegistro = FormValidationUtil.validateInt("Ingrese el id del registro:");
            registro.fecha = FormValidationUtil.validateLocalDate("Ingrese la fecha");
            registro.temperaturaBasal = FormValidationUtil.validateDouble("Ingrese la temperatura basal:");
            registro.peso = FormValidationUtil.validateDouble("Ingrese el peso:");
            registro.calidadSueno = FormValidationUtil.validateString("Ingrese la calidad del sueño:");
            registro.notasLibres = FormValidationUtil.validateString("Ingrese notas libres:");
            System.out.println("Registro diario creado exitosamente.");
            return registro;
        } catch (Exception e) {
            System.out.println("Error al registrar el registro diario: " + e.getMessage());
            return null;
        }
    }

    public RegistroDiario updateRegistro(RegistroDiario registro) {
        try {
            registro.fecha = FormValidationUtil.validateLocalDate("Ingrese la nueva fecha");
            registro.temperaturaBasal = FormValidationUtil.validateDouble("Ingrese la nueva temperatura basal:");
            registro.peso = FormValidationUtil.validateDouble("Ingrese el nuevo peso:");
            registro.calidadSueno = FormValidationUtil.validateString("Ingrese la nueva calidad del sueño:");
            registro.notasLibres = FormValidationUtil.validateString("Ingrese las nuevas notas libres:");
            System.out.println("Registro diario actualizado exitosamente.");
            return registro;
        } catch (Exception e) {
            System.out.println("Error al actualizar el registro diario: " + e.getMessage());
            return null;
        }
    }

    public void getRegistroById(int id) {
        if (this.idRegistro == id) {
            System.out.println("Id Registro: " + this.idRegistro +
                    "\nFecha: " + this.fecha +
                    "\nTemperatura Basal: " + this.temperaturaBasal +
                    "\nPeso: " + this.peso +
                    "\nCalidad Sueño: " + this.calidadSueno +
                    "\nNotas: " + this.notasLibres + "\n");
        } else {
            System.out.println("Registro con id " + id + " no encontrado.");
        }
    }

    public void getAllRegistros(List<RegistroDiario> registros) {
        if (registros == null || registros.isEmpty()) {
            System.out.println("No hay registros diarios registrados.");
            return;
        }
        registros.forEach(r -> System.out.println("[" + r.idRegistro + "] " + r.fecha + " | Temp: " + r.temperaturaBasal + " | Peso: " + r.peso));
    }

    public void deleteRegistro(int id) {
        System.out.println("Registro con id " + id + " eliminado.");
    }

}
