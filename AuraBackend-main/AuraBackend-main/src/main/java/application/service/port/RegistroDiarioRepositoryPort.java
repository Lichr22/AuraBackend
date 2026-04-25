package application.service.port;

import application.domain.RegistroDiario;

import java.util.List;
import java.util.Optional;

public interface RegistroDiarioRepositoryPort {

    RegistroDiario saveRegistroDiario(RegistroDiario registroDiario);
    RegistroDiario updateRegistroDiario(int id, RegistroDiario registroDiario);
    Optional<RegistroDiario> findRegistroDiarioById(int id);
    List<RegistroDiario> findAllRegistrosDiarios();
    void deleteRegistroDiarioById(int id);
}