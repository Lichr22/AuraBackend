package application.ports;

import domain.RecomendacionIA;

import java.util.List;
import java.util.Optional;

public interface RecomendacionIARepositoryPort {

    RecomendacionIA saveRecomendacion(RecomendacionIA recomendacion);
    RecomendacionIA updateRecomendacion(Long id, RecomendacionIA recomendacion);
    Optional<RecomendacionIA> findRecomendacionById(Long id);
    List<RecomendacionIA> findAllRecomendaciones();
    void deleteRecomendacionById(Long id);
}
