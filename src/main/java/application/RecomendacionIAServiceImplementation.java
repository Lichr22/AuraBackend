package application;

import application.inputs.RecomendacionIAService;
import application.ports.RecomendacionIARepositoryPort;
import domain.RecomendacionIA;

import java.util.List;

public class RecomendacionIAServiceImplementation implements RecomendacionIAService {

    private final RecomendacionIARepositoryPort repository;

    public RecomendacionIAServiceImplementation(RecomendacionIARepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public RecomendacionIA createRecomendacion(RecomendacionIA recomendacion) {
        RecomendacionIA filled = recomendacion.createRecomendacion(recomendacion);
        return filled != null ? repository.saveRecomendacion(filled) : null;
    }

    @Override
    public RecomendacionIA updateRecomendacion(RecomendacionIA recomendacion) {
        RecomendacionIA filled = recomendacion.updateRecomendacion(recomendacion);
        return filled != null ? repository.updateRecomendacion(filled.getIdRecomendacion(), filled) : null;
    }

    @Override
    public void getRecomendacionById(Long id, RecomendacionIA recomendacion) {
        repository.findRecomendacionById(id)
                .ifPresentOrElse(
                        r -> System.out.println("Id: " + r.getIdRecomendacion() + " | Titulo: " + r.getTitulo() + " | Fecha: " + r.getFechaCreacion()),
                        () -> System.out.println("Recomendación con id " + id + " no encontrada.")
                );
    }

    @Override
    public void getAllRecomendaciones(List<RecomendacionIA> recomendaciones, RecomendacionIA recomendacion) {
        List<RecomendacionIA> result = repository.findAllRecomendaciones();
        if (result.isEmpty()) {
            System.out.println("No hay recomendaciones registradas.");
        } else {
            result.forEach(r -> System.out.println("[" + r.getIdRecomendacion() + "] " + r.getTitulo() + " - " + r.getFechaCreacion()));
        }
    }

    @Override
    public void deleteRecomendacion(Long id) {
        repository.deleteRecomendacionById(id);
        System.out.println("Recomendación con id " + id + " eliminada.");
    }
}
