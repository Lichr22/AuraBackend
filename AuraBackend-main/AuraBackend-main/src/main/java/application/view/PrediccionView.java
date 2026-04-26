package application.view;

import application.domain.Prediccion;
import application.service.PrediccionServiceImplementation;
import application.util.FormValidationUtil;

import java.util.ArrayList;

public class PrediccionView {

    private final PrediccionServiceImplementation service;
    private final Prediccion prediccion;

    public PrediccionView(PrediccionServiceImplementation service, Prediccion prediccion) {
        this.service = service;
        this.prediccion = prediccion;
    }

    public void createPrediccion() {
        service.createPrediccion(prediccion);
    }

    public void updatePrediccion() {
        service.updatePrediccion(prediccion);
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
