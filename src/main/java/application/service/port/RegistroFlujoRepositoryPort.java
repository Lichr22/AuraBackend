package application.service.port;

import application.domain.RegistroFlujo;

import java.util.List;
import java.util.Optional;

public interface RegistroFlujoRepositoryPort {

    RegistroFlujo saveRegistroFlujo(RegistroFlujo registroFlujo);
    RegistroFlujo updateRegistroFlujo(int id, RegistroFlujo registroFlujo);
    Optional<RegistroFlujo> findRegistroFlujoById(int id);
    List<RegistroFlujo> findAllRegistrosFlujo();
    void deleteRegistroFlujoById(int id);
}