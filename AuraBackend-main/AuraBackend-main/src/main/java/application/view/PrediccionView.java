package application.view;

import application.domain.Prediccion;
import application.service.PrediccionServiceImplementation;

public class PrediccionView {

    private final PrediccionServiceImplementation prediccionServiceImplementation;
    private final Prediccion prediccion;

    public PrediccionView(PrediccionServiceImplementation prediccionServiceImplementation, Prediccion prediccion) {
        this.prediccionServiceImplementation = prediccionServiceImplementation;
        this.prediccion = prediccion;
    }

    public void createPrediccion() {
        prediccionServiceImplementation.createPrediccion(prediccion);
    }

}
