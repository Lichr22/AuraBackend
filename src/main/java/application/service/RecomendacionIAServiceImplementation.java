package application.service;

import application.domain.RecomendacionIA;

import java.util.List;

public class RecomendacionIAServiceImplementation implements RecomendacionIAService {

    @Override
    public RecomendacionIA createRecomendacion(RecomendacionIA recomendacion) {
        return recomendacion;
    }

    @Override
    public RecomendacionIA updateRecomendacion(RecomendacionIA recomendacion) {
        return recomendacion;
    }

    @Override
    public void deleteRecomendacion(Long id) {
    }

    @Override
    public List<RecomendacionIA> getRecomendacionById(Long id) {
        return List.of();
    }

}
