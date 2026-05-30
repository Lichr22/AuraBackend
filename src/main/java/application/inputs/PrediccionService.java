package application.inputs;

import application.exceptions.ValidacionException;
import domain.Prediccion;

import java.util.List;

public interface PrediccionService {

    Prediccion createPrediccion(Prediccion prediccion) throws ValidacionException;

    Prediccion updatePrediccion(Prediccion prediccion) throws ValidacionException;

    void getPrediccionById(int id, Prediccion prediccion);

    void getAllPredicciones(List<Prediccion> predicciones, Prediccion prediccion);

    void deletePrediccion(int id);

}
