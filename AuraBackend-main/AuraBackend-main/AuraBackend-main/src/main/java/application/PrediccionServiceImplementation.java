package application;

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
    public Prediccion createPrediccion(Prediccion prediccion) {
        Prediccion filled = prediccion.createPrediccion(prediccion);
        return filled != null ? repository.savePrediccion(filled) : null;
    }

    @Override
    public Prediccion updatePrediccion(Prediccion prediccion) {
        Prediccion filled = prediccion.updatePrediccion(prediccion);
        return filled != null ? repository.updatePrediccion(filled.getIdPrediccion(), filled) : null;
    }

    @Override
    public void getPrediccionById(int id, Prediccion prediccion) {
        repository.findPrediccionById(id)
                .ifPresentOrElse(
                        p -> System.out.println("Id: " + p.getIdPrediccion() + " | Calculo: " + p.getFechaCalculo() + " | Prox. menstruacion: " + p.getProximaMenstruacionEstimada()),
                        () -> System.out.println("Predicción con id " + id + " no encontrada.")
                );
    }

    @Override
    public void getAllPredicciones(List<Prediccion> predicciones, Prediccion prediccion) {
        List<Prediccion> result = repository.findAllPredicciones();
        if (result.isEmpty()) {
            System.out.println("No hay predicciones registradas.");
        } else {
            result.forEach(p -> System.out.println("[" + p.getIdPrediccion() + "] Calculo: " + p.getFechaCalculo() + " | Prox. menstruacion: " + p.getProximaMenstruacionEstimada()));
        }
    }

    @Override
    public void deletePrediccion(int id) {
        repository.deletePrediccionById(id);
        System.out.println("Predicción con id " + id + " eliminada.");
    }
}
