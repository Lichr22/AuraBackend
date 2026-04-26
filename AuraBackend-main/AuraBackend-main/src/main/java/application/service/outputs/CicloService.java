package application.service.outputs;

import application.domain.Ciclo;

import java.util.List;

public interface CicloService {

    Ciclo createCiclo(Ciclo ciclo);

    Ciclo updateCiclo(Ciclo ciclo);

    void getCicloById(int id, Ciclo ciclo);

    void getAllCiclos(List<Ciclo> ciclos, Ciclo ciclo);

    void deleteCiclo(int id);

}
