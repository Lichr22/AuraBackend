package application.inputs;

import application.exceptions.ValidacionException;
import domain.ActividadSexual;

import java.util.List;

public interface ActividadSexualService {

    ActividadSexual createActividadSexual(ActividadSexual actividad) throws ValidacionException;

    ActividadSexual updateActividadSexual(ActividadSexual actividad) throws ValidacionException;

    void getActividadSexualById(int id, ActividadSexual actividad);

    void getAllActividadesSexuales(List<ActividadSexual> actividades, ActividadSexual actividad);

    void deleteActividadSexual(int id);

}
