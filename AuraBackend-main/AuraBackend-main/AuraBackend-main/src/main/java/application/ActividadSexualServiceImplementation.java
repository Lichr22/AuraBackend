package application;

import application.inputs.ActividadSexualService;
import application.ports.ActividadSexualRepositoryPort;
import domain.ActividadSexual;

import java.util.List;

public class ActividadSexualServiceImplementation implements ActividadSexualService {

    private final ActividadSexualRepositoryPort repository;

    public ActividadSexualServiceImplementation(ActividadSexualRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ActividadSexual createActividadSexual(ActividadSexual actividad) {
        ActividadSexual filled = actividad.createActividadSexual(actividad);
        return filled != null ? repository.saveActividadSexual(filled) : null;
    }

    @Override
    public ActividadSexual updateActividadSexual(ActividadSexual actividad) {
        ActividadSexual filled = actividad.updateActividadSexual(actividad);
        return filled != null ? repository.updateActividadSexual(filled.getIdActividad(), filled) : null;
    }

    @Override
    public void getActividadSexualById(int id, ActividadSexual actividad) {
        repository.findActividadSexualById(id)
                .ifPresentOrElse(
                        a -> System.out.println("Id: " + a.getIdActividad() +
                                " | Preservativo: " + a.getUsoPreservativo() +
                                " | Orgasmo: " + a.getOrgasmo() +
                                " | Método: " + a.getMetodoAdicional()),
                        () -> System.out.println("Actividad con id " + id + " no encontrada.")
                );
    }

    @Override
    public void getAllActividadesSexuales(List<ActividadSexual> actividades, ActividadSexual actividad) {
        List<ActividadSexual> result = repository.findAllActividadesSexuales();
        if (result.isEmpty()) {
            System.out.println("No hay actividades sexuales registradas.");
        } else {
            result.forEach(a -> System.out.println("[" + a.getIdActividad() + "] Preservativo: "
                    + a.getUsoPreservativo() + " | Método: " + a.getMetodoAdicional()));
        }
    }

    @Override
    public void deleteActividadSexual(int id) {
        repository.deleteActividadSexualById(id);
        System.out.println("Actividad sexual con id " + id + " eliminada.");
    }
}
