package application;

import application.exceptions.BaseDatosException;
import application.exceptions.EntidadNoEncontradaException;
import application.exceptions.ValidacionException;
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
    public VinculoPareja createVinculo(VinculoPareja vinculo) throws ValidacionException {
        VinculoPareja filled = vinculo.createVinculo(vinculo);
        if (filled == null) throw new ValidacionException("Datos de vínculo inválidos.");
        try {
            return repository.saveVinculo(filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar vínculo.", e);
        }
    }

    @Override
    public VinculoPareja updateVinculo(VinculoPareja vinculo) throws ValidacionException {
        VinculoPareja filled = vinculo.updateVinculo(vinculo);
        if (filled == null) throw new ValidacionException("Datos de vínculo inválidos para actualizar.");
        try {
            return repository.updateVinculo(filled.getIdVinculoPareja(), filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar vínculo.", e);
        }
    }

    @Override
    public void getVinculoById(Long id, VinculoPareja vinculo) {
        try {
            VinculoPareja v = repository.findVinculoById(id)
                    .orElseThrow(() -> new EntidadNoEncontradaException("VinculoPareja", id));
            System.out.println("Id: " + v.getIdVinculoPareja() + " | Estado: " + v.getEstadoVinculo() + " | Fecha: " + v.getFechaVinculacion());
        } catch (EntidadNoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new BaseDatosException("Error al buscar vínculo con id " + id, e);
        }
    }

    @Override
    public void getAllVinculos(List<VinculoPareja> vinculos, VinculoPareja vinculo) {
        try {
            List<VinculoPareja> result = repository.findAllVinculos();
            if (result.isEmpty()) {
                System.out.println("No hay vínculos registrados.");
            } else {
                result.forEach(v -> System.out.println("[" + v.getIdVinculoPareja() + "] Estado: " + v.getEstadoVinculo() + " | Fecha: " + v.getFechaVinculacion()));
            }
        } catch (Exception e) {
            throw new BaseDatosException("Error al obtener vínculos.", e);
        }
    }

    @Override
    public void deleteVinculo(Long id) {
        try {
            repository.deleteVinculoById(id);
            System.out.println("Vínculo con id " + id + " eliminado.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar vínculo con id " + id, e);
        }
    }
}
