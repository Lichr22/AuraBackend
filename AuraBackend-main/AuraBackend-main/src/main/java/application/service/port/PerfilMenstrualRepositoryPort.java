package application.service.port;

import application.domain.PerfilMenstrual;

import java.util.List;
import java.util.Optional;

public interface PerfilMenstrualRepositoryPort {

    PerfilMenstrual savePerfilMenstrual(PerfilMenstrual perfilMenstrual);
    PerfilMenstrual updatePerfilMenstrual(int id, PerfilMenstrual perfilMenstrual);
    Optional<PerfilMenstrual> findPerfilMenstrualById(int id);
    List<PerfilMenstrual> findAllPerfilesMenstruales();
    void deletePerfilMenstrualById(int id);
}
