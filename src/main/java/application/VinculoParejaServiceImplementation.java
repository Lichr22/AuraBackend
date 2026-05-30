package application;

import application.inputs.VinculoParejaService;
import application.ports.VinculoParejaRepositoryPort;
import domain.VinculoPareja;

import java.util.List;

public class VinculoParejaServiceImplementation implements VinculoParejaService {

    private final VinculoParejaRepositoryPort repository;

    public VinculoParejaServiceImplementation(VinculoParejaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public VinculoPareja createVinculo(VinculoPareja vinculo) {
        VinculoPareja filled = vinculo.createVinculo(vinculo);
        return filled != null ? repository.saveVinculo(filled) : null;
    }

    @Override
    public VinculoPareja updateVinculo(VinculoPareja vinculo) {
        VinculoPareja filled = vinculo.updateVinculo(vinculo);
        return filled != null ? repository.updateVinculo(filled.getIdVinculoPareja(), filled) : null;
    }

    @Override
    public void getVinculoById(Long id, VinculoPareja vinculo) {
        repository.findVinculoById(id)
                .ifPresentOrElse(
                        v -> System.out.println("Id: " + v.getIdVinculoPareja() + " | Estado: " + v.getEstadoVinculo() + " | Fecha: " + v.getFechaVinculacion()),
                        () -> System.out.println("Vínculo con id " + id + " no encontrado.")
                );
    }

    @Override
    public void getAllVinculos(List<VinculoPareja> vinculos, VinculoPareja vinculo) {
        List<VinculoPareja> result = repository.findAllVinculos();
        if (result.isEmpty()) {
            System.out.println("No hay vínculos registrados.");
        } else {
            result.forEach(v -> System.out.println("[" + v.getIdVinculoPareja() + "] Estado: " + v.getEstadoVinculo() + " | Fecha: " + v.getFechaVinculacion()));
        }
    }

    @Override
    public void deleteVinculo(Long id) {
        repository.deleteVinculoById(id);
        System.out.println("Vínculo con id " + id + " eliminado.");
    }
}
