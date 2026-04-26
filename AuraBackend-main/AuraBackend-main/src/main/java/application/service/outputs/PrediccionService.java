package application.service.outputs;

import application.domain.Prediccion;

import java.util.List;

public interface PrediccionService {

    Prediccion createPrediccion(Prediccion prediccion);

    Prediccion updatePrediccion(Prediccion prediccion);

    void getPrediccionById(int id, Prediccion prediccion);

    void getAllPredicciones(List<Prediccion> predicciones, Prediccion prediccion);

    void deletePrediccion(int id);

}
