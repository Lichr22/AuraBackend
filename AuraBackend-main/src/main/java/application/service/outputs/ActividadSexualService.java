package application.service.outputs;

import application.domain.ActividadSexual;

import java.util.List;

public interface ActividadSexualService {

    ActividadSexual createActividadSexual(ActividadSexual actividad);

    ActividadSexual updateActividadSexual(ActividadSexual actividad);

    void getActividadSexualById(int id, ActividadSexual actividad);

    void getAllActividadesSexuales(List<ActividadSexual> actividades, ActividadSexual actividad);

    void deleteActividadSexual(int id);

}
