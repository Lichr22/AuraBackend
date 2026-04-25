package application.service;

import application.domain.Prediccion;
import application.service.outputs.PrediccionService;

import java.util.List;

public class PrediccionServiceImplementation implements PrediccionService {

    @Override
    public Prediccion createPrediccion(Prediccion prediccion) {
        prediccion.createPrediccion(prediccion);
        return prediccion;
    }

    @Override
    public void deletePrediccion(int id) {
    }

    @Override
    public List<Prediccion> getPrediccionById(int id) {
        return List.of();
    }

}
