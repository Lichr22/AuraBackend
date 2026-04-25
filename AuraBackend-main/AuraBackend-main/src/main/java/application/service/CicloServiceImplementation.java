package application.service;

import application.domain.Ciclo;
import application.domain.Usuario;
import application.service.outputs.CicloService;

import java.util.List;

public class CicloServiceImplementation implements CicloService {

    public CicloServiceImplementation(CicloServiceImplementation cicloServiceImplementation, Ciclo ciclo) {
    }

    public CicloServiceImplementation() {

    }

    @Override
    public Ciclo createCiclo(Ciclo ciclo) {
        ciclo.createCiclo(ciclo);
        return ciclo;
    }

    @Override
    public void deleteCiclo(int id) {
    }

    @Override
    public List<Ciclo> getCicloById(int id) {
        return List.of();
    }

}
