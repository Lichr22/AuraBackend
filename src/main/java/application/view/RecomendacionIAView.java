package application.view;

import application.domain.RecomendacionIA;
import application.service.RecomendacionIAServiceImplementation;

public class RecomendacionIAView {

    private final RecomendacionIAServiceImplementation recomendacionIAServiceImplementation;
    private final RecomendacionIA recomendacionIA;

    public RecomendacionIAView(RecomendacionIAServiceImplementation recomendacionIAServiceImplementation, RecomendacionIA recomendacionIA) {
        this.recomendacionIAServiceImplementation = recomendacionIAServiceImplementation;
        this.recomendacionIA = recomendacionIA;
    }

    public void createRecomendacion() {
        recomendacionIAServiceImplementation.createRecomendacion(recomendacionIA);
    }

    public void updateRecomendacion() {
        recomendacionIAServiceImplementation.updateRecomendacion(recomendacionIA);
    }

}
