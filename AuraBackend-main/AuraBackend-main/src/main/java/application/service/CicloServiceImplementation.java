package application.service;

import application.domain.Ciclo;
import application.service.outputs.CicloService;

import java.util.List;

public class CicloServiceImplementation implements CicloService {

    public CicloServiceImplementation() {}

    @Override
    public Ciclo createCiclo(Ciclo ciclo) {
        return ciclo.createCiclo(ciclo);
    }

    @Override
    public Ciclo updateCiclo(Ciclo ciclo) {
        return ciclo.updateCiclo(ciclo);
    }

    @Override
    public void getCicloById(int id, Ciclo ciclo) {
        ciclo.getCicloById(id);
    }

    @Override
    public void getAllCiclos(List<Ciclo> ciclos, Ciclo ciclo) {
        ciclo.getAllCiclos(ciclos);
    }

    @Override
    public void deleteCiclo(int id) {
        new Ciclo().deleteCiclo(id);
    }

}
