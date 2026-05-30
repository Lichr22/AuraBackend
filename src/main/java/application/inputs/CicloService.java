package application.inputs;

import application.exceptions.ValidacionException;
import domain.Ciclo;

import java.util.List;

public interface CicloService {

    Ciclo createCiclo(Ciclo ciclo) throws ValidacionException;

    Ciclo updateCiclo(Ciclo ciclo) throws ValidacionException;

    void getCicloById(int id, Ciclo ciclo);

    void getAllCiclos(List<Ciclo> ciclos, Ciclo ciclo);

    void deleteCiclo(int id);

}
