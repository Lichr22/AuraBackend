package application;

import application.exceptions.BaseDatosException;
import application.exceptions.EntidadNoEncontradaException;
import application.exceptions.ValidacionException;
import application.inputs.PrediccionService;
import application.ports.PrediccionRepositoryPort;
import domain.Prediccion;

import java.util.List;

public class PrediccionServiceImplementation implements PrediccionService {

    private final PrediccionRepositoryPort repository;

    public PrediccionServiceImplementation(PrediccionRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Prediccion createPrediccion(Prediccion prediccion) throws ValidacionException {
        Prediccion filled = prediccion.createPrediccion(prediccion);
        if (filled == null) throw new ValidacionException("Datos de predicción inválidos.");
        try {
            return repository.savePrediccion(filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar predicción.", e);
        }
    }

    @Override
    public Prediccion updatePrediccion(Prediccion prediccion) throws ValidacionException {
        Prediccion filled = prediccion.updatePrediccion(prediccion);
        if (filled == null) throw new ValidacionException("Datos de predicción inválidos para actualizar.");
        try {
            return repository.updatePrediccion(filled.getIdPrediccion(), filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar predicción.", e);
        }
    }

    @Override
    public void getPrediccionById(int id, Prediccion prediccion) {
        try {
            Prediccion p = repository.findPrediccionById(id)
                    .orElseThrow(() -> new EntidadNoEncontradaException("Prediccion", id));
            System.out.println("Id: " + p.getIdPrediccion() + " | Calculo: " + p.getFechaCalculo() + " | Prox. menstruacion: " + p.getProximaMenstruacionEstimada());
        } catch (EntidadNoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new BaseDatosException("Error al buscar predicción con id " + id, e);
        }
    }

    @Override
    public void getAllPredicciones(List<Prediccion> predicciones, Prediccion prediccion) {
        try {
            List<Prediccion> result = repository.findAllPredicciones();
            if (result.isEmpty()) {
                System.out.println("No hay predicciones registradas.");
            } else {
                result.forEach(p -> System.out.println("[" + p.getIdPrediccion() + "] Calculo: " + p.getFechaCalculo() + " | Prox. menstruacion: " + p.getProximaMenstruacionEstimada()));
            }
        } catch (Exception e) {
            throw new BaseDatosException("Error al obtener predicciones.", e);
        }
    }

    @Override
    public void deletePrediccion(int id) {
        try {
            repository.deletePrediccionById(id);
            System.out.println("Predicción con id " + id + " eliminada.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar predicción con id " + id, e);
        }
    }
}
