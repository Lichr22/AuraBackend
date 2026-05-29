package application.service.port;

import application.domain.Prediccion;

import java.util.List;
import java.util.Optional;

public interface PrediccionRepositoryPort {

    Prediccion savePrediccion(Prediccion prediccion);
    Prediccion updatePrediccion(int id, Prediccion prediccion);
    Optional<Prediccion> findPrediccionById(int id);
    List<Prediccion> findAllPredicciones();
    void deletePrediccionById(int id);
}