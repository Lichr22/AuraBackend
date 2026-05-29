package application.service;

import application.domain.ActividadSexual;

import java.util.List;

public interface ActividadSexualService {

    ActividadSexual createActividadSexual(ActividadSexual actividad);

    void deleteActividadSexual(int id);

    List<ActividadSexual> getActividadSexualById(int id);

}
