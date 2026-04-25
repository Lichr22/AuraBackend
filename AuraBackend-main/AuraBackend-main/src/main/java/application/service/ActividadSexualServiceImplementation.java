package application.service;

import application.domain.ActividadSexual;
import application.service.outputs.ActividadSexualService;

import java.util.List;

public class ActividadSexualServiceImplementation implements ActividadSexualService {

    @Override
    public ActividadSexual createActividadSexual(ActividadSexual actividad) {
        actividad.createActividadSexual(actividad);
        return actividad;
    }

    @Override
    public void deleteActividadSexual(int id) {
    }

    @Override
    public List<ActividadSexual> getActividadSexualById(int id) {
        return List.of();
    }

}
