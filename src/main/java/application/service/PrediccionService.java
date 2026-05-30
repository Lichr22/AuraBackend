package application.service;

import application.domain.Prediccion;

import java.util.List;

public interface PrediccionService {

    Prediccion createPrediccion(Prediccion prediccion);

    void deletePrediccion(int id);

    List<Prediccion> getPrediccionById(int id);

}
