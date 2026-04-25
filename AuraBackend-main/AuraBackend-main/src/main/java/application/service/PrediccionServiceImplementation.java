package application.service;

import application.domain.Prediccion;

import java.util.List;

public class PrediccionServiceImplementation implements PrediccionService {

    @Override
    public Prediccion createPrediccion(Prediccion prediccion) {
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
