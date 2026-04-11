package application.service;

import application.domain.Ciclo;

import java.util.List;

public interface CicloService {

    Ciclo createCiclo(Ciclo ciclo);

    void deleteCiclo(int id);

    List<Ciclo> getCicloById(int id);

}
