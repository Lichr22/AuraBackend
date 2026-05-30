package application;

import application.service.CicloService;
import application.service.port.CicloRepositoryPort;
import application.domain.Ciclo;

import java.util.List;

public class CicloServiceImplementation implements CicloService {

    private final CicloRepositoryPort repository;

    public CicloServiceImplementation(CicloRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Ciclo createCiclo(Ciclo ciclo) {
        Ciclo filled = ciclo.createCiclo(ciclo);
        return filled != null ? repository.saveCiclo(filled) : null;
    }

    @Override
    public Ciclo updateCiclo(Ciclo ciclo) {
        Ciclo filled = ciclo.updateCiclo(ciclo);
        return filled != null ? repository.updateCiclo(filled.getIdCiclo(), filled) : null;
    }

    @Override
    public void getCicloById(int id, Ciclo ciclo) {
        repository.findCicloById(id)
                .ifPresentOrElse(
                        c -> System.out.println("Id: " + c.getIdCiclo() + " | Inicio: " + c.getFechaInicio() + " | Fin: " + c.getFechaFin() + " | Regular: " + c.isEsRegular()),
                        () -> System.out.println("Ciclo con id " + id + " no encontrado.")
                );
    }

    @Override
    public void getAllCiclos(List<Ciclo> ciclos, Ciclo ciclo) {
        List<Ciclo> result = repository.findAllCiclos();
        if (result.isEmpty()) {
            System.out.println("No hay ciclos registrados.");
        } else {
            result.forEach(c -> System.out.println("[" + c.getIdCiclo() + "] " + c.getFechaInicio() + " - " + c.getFechaFin() + " | Regular: " + c.isEsRegular()));
        }
    }

    @Override
    public void deleteCiclo(int id) {
        repository.deleteCicloById(id);
        System.out.println("Ciclo con id " + id + " eliminado.");
    }

    @Override
    public List<Ciclo> getCicloById(int id) {
        return null;
    }
}
