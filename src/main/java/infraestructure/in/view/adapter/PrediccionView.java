package infraestructure.in.view.adapter;

import application.exceptions.ValidacionException;
import domain.Prediccion;
import application.PrediccionServiceImplementation;
import infraestructure.util.FormValidationUtil;

import java.util.ArrayList;

public class PrediccionView {

    private final PrediccionServiceImplementation service;
    private final Prediccion prediccion;

    public PrediccionView(PrediccionServiceImplementation service, Prediccion prediccion) {
        this.service = service;
        this.prediccion = prediccion;
    }

    public void createPrediccion() {
        try {
            service.createPrediccion(prediccion);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void updatePrediccion() {
        try {
            service.updatePrediccion(prediccion);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void getPrediccionById() {
        int id = FormValidationUtil.validateInt("Ingrese el id de la predicción a consultar:");
        service.getPrediccionById(id, prediccion);
    }

    public void getAllPredicciones() {
        service.getAllPredicciones(new ArrayList<>(), prediccion);
    }

    public void deletePrediccion() {
        int id = FormValidationUtil.validateInt("Ingrese el id de la predicción a eliminar:");
        service.deletePrediccion(id);
    }

}
