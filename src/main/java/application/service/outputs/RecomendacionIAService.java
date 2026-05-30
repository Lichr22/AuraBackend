package application.service.outputs;

import application.domain.RecomendacionIA;

import java.util.List;

public interface RecomendacionIAService {

    RecomendacionIA createRecomendacion(RecomendacionIA recomendacion);

    RecomendacionIA updateRecomendacion(RecomendacionIA recomendacion);

    void getRecomendacionById(Long id, RecomendacionIA recomendacion);

    void getAllRecomendaciones(List<RecomendacionIA> recomendaciones, RecomendacionIA recomendacion);

    void deleteRecomendacion(Long id);

}
