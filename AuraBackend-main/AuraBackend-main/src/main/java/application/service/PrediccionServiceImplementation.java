package application.service;

import application.domain.Prediccion;
import application.service.outputs.PrediccionService;

import java.util.List;

public class PrediccionServiceImplementation implements PrediccionService {

    @Override
    public Prediccion createPrediccion(Prediccion prediccion) {
        return prediccion.createPrediccion(prediccion);
    }

    @Override
    public Prediccion updatePrediccion(Prediccion prediccion) {
        return prediccion.updatePrediccion(prediccion);
    }

    @Override
    public void getPrediccionById(int id, Prediccion prediccion) {
        prediccion.getPrediccionById(id);
    }

    @Override
    public void getAllPredicciones(List<Prediccion> predicciones, Prediccion prediccion) {
        prediccion.getAllPredicciones(predicciones);
    }

    @Override
    public void deletePrediccion(int id) {
        new Prediccion().deletePrediccion(id);
    }

}
