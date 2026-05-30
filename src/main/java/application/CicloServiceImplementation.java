package application;

import application.exceptions.BaseDatosException;
import application.exceptions.EntidadNoEncontradaException;
import application.exceptions.ValidacionException;
import application.inputs.CicloService;
import application.ports.CicloRepositoryPort;
import domain.Ciclo;

import java.util.List;

public class CicloServiceImplementation implements CicloService {

    private final CicloRepositoryPort repository;

    public CicloServiceImplementation(CicloRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Ciclo createCiclo(Ciclo ciclo) throws ValidacionException {
        Ciclo filled = ciclo.createCiclo(ciclo);
        if (filled == null) throw new ValidacionException("Datos de ciclo inválidos.");
        try {
            return repository.saveCiclo(filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar ciclo.", e);
        }
    }

    @Override
    public Ciclo updateCiclo(Ciclo ciclo) throws ValidacionException {
        Ciclo filled = ciclo.updateCiclo(ciclo);
        if (filled == null) throw new ValidacionException("Datos de ciclo inválidos para actualizar.");
        try {
            return repository.updateCiclo(filled.getIdCiclo(), filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar ciclo.", e);
        }
    }

    @Override
    public void getCicloById(int id, Ciclo ciclo) {
        try {
            Ciclo c = repository.findCicloById(id)
                    .orElseThrow(() -> new EntidadNoEncontradaException("Ciclo", id));
            System.out.println("Id: " + c.getIdCiclo() + " | Inicio: " + c.getFechaInicio() + " | Fin: " + c.getFechaFin() + " | Regular: " + c.isEsRegular());
        } catch (EntidadNoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new BaseDatosException("Error al buscar ciclo con id " + id, e);
        }
    }

    @Override
    public void getAllCiclos(List<Ciclo> ciclos, Ciclo ciclo) {
        try {
            List<Ciclo> result = repository.findAllCiclos();
            if (result.isEmpty()) {
                System.out.println("No hay ciclos registrados.");
            } else {
                result.forEach(c -> System.out.println("[" + c.getIdCiclo() + "] " + c.getFechaInicio() + " - " + c.getFechaFin() + " | Regular: " + c.isEsRegular()));
            }
        } catch (Exception e) {
            throw new BaseDatosException("Error al obtener ciclos.", e);
        }
    }

    @Override
    public void deleteCiclo(int id) {
        try {
            repository.deleteCicloById(id);
            System.out.println("Ciclo con id " + id + " eliminado.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar ciclo con id " + id, e);
        }
    }
}
