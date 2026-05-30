package application.inputs;

import application.exceptions.ValidacionException;
import domain.RecomendacionIA;

import java.util.List;

public interface RecomendacionIAService {

    RecomendacionIA createRecomendacion(RecomendacionIA recomendacion) throws ValidacionException;

    RecomendacionIA updateRecomendacion(RecomendacionIA recomendacion) throws ValidacionException;

    void getRecomendacionById(Long id, RecomendacionIA recomendacion);

    void getAllRecomendaciones(List<RecomendacionIA> recomendaciones, RecomendacionIA recomendacion);

    void deleteRecomendacion(Long id);

}
