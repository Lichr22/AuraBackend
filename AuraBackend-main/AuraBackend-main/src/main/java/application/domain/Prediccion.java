package application.domain;


import application.util.FormValidationUtil;

import java.time.LocalDate;
import java.util.List;

public class Prediccion {

    private int idPrediccion;
    private Usuario usuario;
    private LocalDate fechaCalculo;
    private LocalDate proximaMenstruacionEstimada;
    private LocalDate inicioVentanaFertil;
    private LocalDate finVentanaFertil;
    private String probabilidadEmbarazo;

    // CONSTRUCTORES
//Vacio
    public Prediccion() {
    }

    //Con atributos
    public Prediccion(int idPrediccion, Usuario usuario, LocalDate fechaCalculo,
                      LocalDate proximaMenstruacionEstimada, LocalDate inicioVentanaFertil,
                      LocalDate finVentanaFertil, String probabilidadEmbarazo) {

        this.idPrediccion = idPrediccion;
        this.usuario = usuario;
        this.fechaCalculo = fechaCalculo;
        this.proximaMenstruacionEstimada = proximaMenstruacionEstimada;
        this.inicioVentanaFertil = inicioVentanaFertil;
        this.finVentanaFertil = finVentanaFertil;
        this.probabilidadEmbarazo = probabilidadEmbarazo;
    }

    //Solo ID
    public Prediccion(int idPrediccion) {
        this.idPrediccion = idPrediccion;
    }

// GETTERS Y SETTERS

    public int getIdPrediccion() {
        return idPrediccion;
    }

    public void setIdPrediccion(int idPrediccion) {
        this.idPrediccion = idPrediccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaCalculo() {
        return fechaCalculo;
    }

    public void setFechaCalculo(LocalDate fechaCalculo) {
        this.fechaCalculo = fechaCalculo;
    }

    public LocalDate getProximaMenstruacionEstimada() {
        return proximaMenstruacionEstimada;
    }

    public void setProximaMenstruacionEstimada(LocalDate proximaMenstruacionEstimada) {
        this.proximaMenstruacionEstimada = proximaMenstruacionEstimada;
    }

    public LocalDate getInicioVentanaFertil() {
        return inicioVentanaFertil;
    }

    public void setInicioVentanaFertil(LocalDate inicioVentanaFertil) {
        this.inicioVentanaFertil = inicioVentanaFertil;
    }

    public LocalDate getFinVentanaFertil() {
        return finVentanaFertil;
    }

    public void setFinVentanaFertil(LocalDate finVentanaFertil) {
        this.finVentanaFertil = finVentanaFertil;
    }

    public String getProbabilidadEmbarazo() {
        return probabilidadEmbarazo;
    }

    public void setProbabilidadEmbarazo(String probabilidadEmbarazo) {
        this.probabilidadEmbarazo = probabilidadEmbarazo;
    }

// METODOS

    public Prediccion createPrediccion(Prediccion prediccion) {
        try {
            prediccion.idPrediccion = FormValidationUtil.validateInt("Ingrese el id de la prediccion:");
            prediccion.fechaCalculo = FormValidationUtil.validateLocalDate("Ingrese la fecha de cálculo");
            prediccion.proximaMenstruacionEstimada = FormValidationUtil.validateLocalDate("Ingrese la próxima menstruación estimada");
            prediccion.inicioVentanaFertil = FormValidationUtil.validateLocalDate("Ingrese inicio de la ventana fértil");
            prediccion.finVentanaFertil = FormValidationUtil.validateLocalDate("Ingrese fin de la ventana fértil");
            prediccion.probabilidadEmbarazo = FormValidationUtil.validateString("Ingrese probabilidad de embarazo:");
            System.out.println("Predicción creada exitosamente.");
            return prediccion;
        } catch (Exception e) {
            System.out.println("Error al registrar la predicción: " + e.getMessage());
            return null;
        }
    }

    public Prediccion updatePrediccion(Prediccion prediccion) {
        try {
            prediccion.fechaCalculo = FormValidationUtil.validateLocalDate("Ingrese la nueva fecha de cálculo");
            prediccion.proximaMenstruacionEstimada = FormValidationUtil.validateLocalDate("Ingrese la nueva próxima menstruación estimada");
            prediccion.inicioVentanaFertil = FormValidationUtil.validateLocalDate("Ingrese el nuevo inicio de la ventana fértil");
            prediccion.finVentanaFertil = FormValidationUtil.validateLocalDate("Ingrese el nuevo fin de la ventana fértil");
            prediccion.probabilidadEmbarazo = FormValidationUtil.validateString("Ingrese la nueva probabilidad de embarazo:");
            System.out.println("Predicción actualizada exitosamente.");
            return prediccion;
        } catch (Exception e) {
            System.out.println("Error al actualizar la predicción: " + e.getMessage());
            return null;
        }
    }

    public void getPrediccionById(int id) {
        if (this.idPrediccion == id) {
            System.out.println("Id Prediccion: " + this.idPrediccion +
                    "\nFecha Calculo: " + this.fechaCalculo +
                    "\nProxima menstruacion estimada: " + this.proximaMenstruacionEstimada +
                    "\nInicio ventana fertil: " + this.inicioVentanaFertil +
                    "\nFin ventana fertil: " + this.finVentanaFertil +
                    "\nProbabilidad de embarazo: " + this.probabilidadEmbarazo + "\n");
        } else {
            System.out.println("Predicción con id " + id + " no encontrada.");
        }
    }

    public void getAllPredicciones(List<Prediccion> predicciones) {
        if (predicciones == null || predicciones.isEmpty()) {
            System.out.println("No hay predicciones registradas.");
            return;
        }
        predicciones.forEach(p -> System.out.println("[" + p.idPrediccion + "] Calculo: " + p.fechaCalculo + " | Prox. menstruacion: " + p.proximaMenstruacionEstimada));
    }

    public void deletePrediccion(int id) {
        System.out.println("Predicción con id " + id + " eliminada.");
    }

}