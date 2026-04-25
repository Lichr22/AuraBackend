package application.service;

import application.domain.Ciclo;

import java.util.List;

public class CicloServiceImplementation implements CicloService {

    @Override
    public Ciclo createCiclo(Ciclo ciclo) {
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
