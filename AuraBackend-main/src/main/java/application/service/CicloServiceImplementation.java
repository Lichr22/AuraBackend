package application.service;

import application.domain.Ciclo;
import application.exception.BaseDatosException;
import application.exception.EntidadNoEncontradaException;
import application.exception.ValidacionException;
import application.service.outputs.CicloService;
import application.service.port.CicloRepositoryPort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CicloServiceImplementation implements CicloService {

    private final CicloRepositoryPort repositoryPort;
    private final Map<Integer, Ciclo> cache = new HashMap<>();

    public CicloServiceImplementation(CicloRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Ciclo createCiclo(Ciclo ciclo) {
        try {
            validarFechasCiclo(ciclo);
            validarDuracion(ciclo.getDuracionTotal());
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
            return null;
        }
        try {
            Ciclo guardado = repositoryPort.saveCiclo(ciclo);
            cache.put(guardado.getIdCiclo(), guardado);
            System.out.println("Ciclo creado con id: " + guardado.getIdCiclo());
            return guardado;
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar el ciclo.", e);
        }
    }

    @Override
    public Ciclo updateCiclo(Ciclo ciclo) {
        Optional<Ciclo> existente = repositoryPort.findCicloById(ciclo.getIdCiclo());
        if (existente.isEmpty()) throw new EntidadNoEncontradaException("Ciclo", ciclo.getIdCiclo());
        try {
            validarFechasCiclo(ciclo);
            validarDuracion(ciclo.getDuracionTotal());
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
            return null;
        }
        try {
            Ciclo actualizado = repositoryPort.updateCiclo(ciclo.getIdCiclo(), ciclo);
            cache.put(actualizado.getIdCiclo(), actualizado);
            System.out.println("Ciclo actualizado.");
            return actualizado;
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar el ciclo.", e);
        }
    }

    @Override
    public void getCicloById(int id, Ciclo ciclo) {
        if (cache.containsKey(id)) { imprimirCiclo(cache.get(id)); return; }
        Optional<Ciclo> encontrado = repositoryPort.findCicloById(id);
        if (encontrado.isEmpty()) throw new EntidadNoEncontradaException("Ciclo", id);
        cache.put(id, encontrado.get());
        imprimirCiclo(encontrado.get());
    }

    @Override
    public void getAllCiclos(List<Ciclo> ciclos, Ciclo ciclo) {
        List<Ciclo> lista = repositoryPort.findAllCiclos();
        if (lista.isEmpty()) { System.out.println("No hay ciclos registrados."); return; }
        lista.stream()
                .sorted((a, b) -> b.getFechaInicio().compareTo(a.getFechaInicio()))
                .forEach(c -> System.out.println("[" + c.getIdCiclo() + "] " + c.getFechaInicio() + " → " + c.getFechaFin() + " | Regular: " + c.isEsRegular()));
        System.out.println("Total: " + lista.size());
    }

    @Override
    public void deleteCiclo(int id) {
        if (repositoryPort.findCicloById(id).isEmpty()) throw new EntidadNoEncontradaException("Ciclo", id);
        try {
            repositoryPort.deleteCicloById(id);
            cache.remove(id);
            System.out.println("Ciclo " + id + " eliminado.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar el ciclo.", e);
        }
    }

    // Validaciones de negocio
    private void validarFechasCiclo(Ciclo ciclo) throws ValidacionException {
        if (ciclo.getFechaFin() != null && ciclo.getFechaInicio() != null
                && ciclo.getFechaFin().isBefore(ciclo.getFechaInicio())) {
            throw new ValidacionException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }
    }

    private void validarDuracion(int dias) throws ValidacionException {
        if (dias < 21 || dias > 45) {
            throw new ValidacionException("La duración del ciclo debe estar entre 21 y 45 días. Se ingresaron: " + dias);
        }
    }

    private void imprimirCiclo(Ciclo c) {
        System.out.println("──────────────────────────────");
        System.out.println("ID:         " + c.getIdCiclo());
        System.out.println("Inicio:     " + c.getFechaInicio());
        System.out.println("Fin:        " + c.getFechaFin());
        System.out.println("Duración:   " + c.getDuracionTotal() + " días");
        System.out.println("Regular:    " + c.isEsRegular());
        System.out.println("──────────────────────────────");
    }
}