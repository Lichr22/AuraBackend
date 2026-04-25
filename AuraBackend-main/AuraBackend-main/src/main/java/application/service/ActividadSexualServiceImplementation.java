package application.service;

import application.domain.ActividadSexual;

import java.util.List;

public class ActividadSexualServiceImplementation implements ActividadSexualService {

    @Override
    public ActividadSexual createActividadSexual(ActividadSexual actividad) {
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
