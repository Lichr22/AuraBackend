package application.service;

import application.domain.RecomendacionIA;
import application.service.outputs.RecomendacionIAService;
import application.service.port.RecomendacionIARepositoryPort;

import java.util.List;

public class RecomendacionIAServiceImplementation implements RecomendacionIAService {

    public RecomendacionIAServiceImplementation(RecomendacionIARepositoryPort recomendacionRepo) {
    }

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
