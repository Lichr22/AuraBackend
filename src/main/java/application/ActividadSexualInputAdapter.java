package application;

import application.inputs.ActividadSexualService;
import domain.ActividadSexual;

import java.util.List;

public class ActividadSexualInputAdapter implements ActividadSexualService {

    @Override
    public ActividadSexual createActividadSexual(ActividadSexual actividad) {
        return actividad.createActividadSexual(actividad);
    }

    @Override
    public ActividadSexual updateActividadSexual(ActividadSexual actividad) {
        return actividad.updateActividadSexual(actividad);
    }

    @Override
    public void getActividadSexualById(int id, ActividadSexual actividad) {
        actividad.getActividadSexualById(id);
    }

    @Override
    public void getAllActividadesSexuales(List<ActividadSexual> actividades, ActividadSexual actividad) {
        actividad.getAllActividadesSexuales(actividades);
    }

    @Override
    public void deleteActividadSexual(int id) {
        new ActividadSexual().deleteActividadSexual(id);
    }

}
