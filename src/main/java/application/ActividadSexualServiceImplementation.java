package application;

import application.exceptions.BaseDatosException;
import application.exceptions.EntidadNoEncontradaException;
import application.exceptions.ValidacionException;
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
    public ActividadSexual createActividadSexual(ActividadSexual actividad) throws ValidacionException {
        ActividadSexual filled = actividad.createActividadSexual(actividad);
        if (filled == null) throw new ValidacionException("Datos de actividad sexual inválidos.");
        try {
            return repository.saveActividadSexual(filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar actividad sexual.", e);
        }
    }

    @Override
    public ActividadSexual updateActividadSexual(ActividadSexual actividad) throws ValidacionException {
        ActividadSexual filled = actividad.updateActividadSexual(actividad);
        if (filled == null) throw new ValidacionException("Datos de actividad sexual inválidos para actualizar.");
        try {
            return repository.updateActividadSexual(filled.getIdActividad(), filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar actividad sexual.", e);
        }
    }

    @Override
    public void getActividadSexualById(int id, ActividadSexual actividad) {
        try {
            ActividadSexual a = repository.findActividadSexualById(id)
                    .orElseThrow(() -> new EntidadNoEncontradaException("ActividadSexual", id));
            System.out.println("Id: " + a.getIdActividad() +
                    " | Preservativo: " + a.getUsoPreservativo() +
                    " | Orgasmo: " + a.getOrgasmo() +
                    " | Método: " + a.getMetodoAdicional());
        } catch (EntidadNoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new BaseDatosException("Error al buscar actividad sexual con id " + id, e);
        }
    }

    @Override
    public void getAllActividadesSexuales(List<ActividadSexual> actividades, ActividadSexual actividad) {
        try {
            List<ActividadSexual> result = repository.findAllActividadesSexuales();
            if (result.isEmpty()) {
                System.out.println("No hay actividades sexuales registradas.");
            } else {
                result.forEach(a -> System.out.println("[" + a.getIdActividad() + "] Preservativo: "
                        + a.getUsoPreservativo() + " | Método: " + a.getMetodoAdicional()));
            }
        } catch (Exception e) {
            throw new BaseDatosException("Error al obtener actividades sexuales.", e);
        }
    }

    @Override
    public void deleteActividadSexual(int id) {
        try {
            repository.deleteActividadSexualById(id);
            System.out.println("Actividad sexual con id " + id + " eliminada.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar actividad sexual con id " + id, e);
        }
    }
}
