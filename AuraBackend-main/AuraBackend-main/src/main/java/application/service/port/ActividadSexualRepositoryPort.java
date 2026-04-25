package application.service.port;

import application.domain.ActividadSexual;

import java.util.List;
import java.util.Optional;

public interface ActividadSexualRepositoryPort {

    ActividadSexual saveActividadSexual(ActividadSexual actividadSexual);
    ActividadSexual updateActividadSexual(int id, ActividadSexual actividadSexual);
    Optional<ActividadSexual> findActividadSexualById(int id);
    List<ActividadSexual> findAllActividadesSexuales();
    void deleteActividadSexualById(int id);
}
