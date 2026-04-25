package application.service;

import application.domain.RecomendacionIA;

import java.util.List;

public interface RecomendacionIAService {

    RecomendacionIA createRecomendacion(RecomendacionIA recomendacion);

    RecomendacionIA updateRecomendacion(RecomendacionIA recomendacion);

    void deleteRecomendacion(Long id);

    List<RecomendacionIA> getRecomendacionById(Long id);

}
