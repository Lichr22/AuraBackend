package application.service.port;

import application.domain.Ciclo;

import java.util.List;
import java.util.Optional;

public interface CicloRepositoryPort {

    Ciclo saveCiclo(Ciclo ciclo);
    Ciclo updateCiclo(int id, Ciclo ciclo);
    Optional<Ciclo> findCicloById(int id);
    List<Ciclo> findAllCiclos();
    void deleteCicloById(int id);
}
