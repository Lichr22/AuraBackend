package application;

import application.exceptions.BaseDatosException;
import application.exceptions.EntidadNoEncontradaException;
import application.exceptions.ValidacionException;
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
    public RecomendacionIA createRecomendacion(RecomendacionIA recomendacion) throws ValidacionException {
        RecomendacionIA filled = recomendacion.createRecomendacion(recomendacion);
        if (filled == null) throw new ValidacionException("Datos de recomendación inválidos.");
        try {
            return repository.saveRecomendacion(filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar recomendación.", e);
        }
    }

    @Override
    public RecomendacionIA updateRecomendacion(RecomendacionIA recomendacion) throws ValidacionException {
        RecomendacionIA filled = recomendacion.updateRecomendacion(recomendacion);
        if (filled == null) throw new ValidacionException("Datos de recomendación inválidos para actualizar.");
        try {
            return repository.updateRecomendacion(filled.getIdRecomendacion(), filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar recomendación.", e);
        }
    }

    @Override
    public void getRecomendacionById(Long id, RecomendacionIA recomendacion) {
        try {
            RecomendacionIA r = repository.findRecomendacionById(id)
                    .orElseThrow(() -> new EntidadNoEncontradaException("RecomendacionIA", id));
            System.out.println("Id: " + r.getIdRecomendacion() + " | Titulo: " + r.getTitulo() + " | Fecha: " + r.getFechaCreacion());
        } catch (EntidadNoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new BaseDatosException("Error al buscar recomendación con id " + id, e);
        }
    }

    @Override
    public void getAllRecomendaciones(List<RecomendacionIA> recomendaciones, RecomendacionIA recomendacion) {
        try {
            List<RecomendacionIA> result = repository.findAllRecomendaciones();
            if (result.isEmpty()) {
                System.out.println("No hay recomendaciones registradas.");
            } else {
                result.forEach(r -> System.out.println("[" + r.getIdRecomendacion() + "] " + r.getTitulo() + " - " + r.getFechaCreacion()));
            }
        } catch (Exception e) {
            throw new BaseDatosException("Error al obtener recomendaciones.", e);
        }
    }

    @Override
    public void deleteRecomendacion(Long id) {
        try {
            repository.deleteRecomendacionById(id);
            System.out.println("Recomendación con id " + id + " eliminada.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar recomendación con id " + id, e);
        }
    }
}
