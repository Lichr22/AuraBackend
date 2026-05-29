package application.service;

import application.domain.RecomendacionIA;
import application.service.outputs.RecomendacionIAService;

import java.util.List;

public class RecomendacionIAServiceImplementation implements RecomendacionIAService {

    @Override
    public RecomendacionIA createRecomendacion(RecomendacionIA recomendacion) {
        return recomendacion.createRecomendacion(recomendacion);
    }

    @Override
    public RecomendacionIA updateRecomendacion(RecomendacionIA recomendacion) {
        return recomendacion.updateRecomendacion(recomendacion);
    }

    @Override
    public void getRecomendacionById(Long id, RecomendacionIA recomendacion) {
        recomendacion.getRecomendacionById(id);
    }

    @Override
    public void getAllRecomendaciones(List<RecomendacionIA> recomendaciones, RecomendacionIA recomendacion) {
        recomendacion.getAllRecomendaciones(recomendaciones);
    }

    @Override
    public void deleteRecomendacion(Long id) {
        new RecomendacionIA().deleteRecomendacion(id);
    }

}
