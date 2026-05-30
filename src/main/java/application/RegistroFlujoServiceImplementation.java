package application;

import application.exceptions.BaseDatosException;
import application.exceptions.EntidadNoEncontradaException;
import application.exceptions.ValidacionException;
import application.inputs.RegistroFlujoService;
import application.ports.RegistroFlujoRepositoryPort;
import domain.RegistroFlujo;

import java.util.List;

public class RegistroFlujoServiceImplementation implements RegistroFlujoService {

    private final RegistroFlujoRepositoryPort repository;

    public RegistroFlujoServiceImplementation(RegistroFlujoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public RegistroFlujo createRegistroFlujo(RegistroFlujo flujo) throws ValidacionException {
        RegistroFlujo filled = RegistroFlujo.createRegistroFlujo(flujo);
        if (filled == null) throw new ValidacionException("Datos de registro de flujo inválidos.");
        try {
            return repository.saveRegistroFlujo(filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar registro de flujo.", e);
        }
    }

    @Override
    public RegistroFlujo updateRegistroFlujo(RegistroFlujo flujo) throws ValidacionException {
        RegistroFlujo filled = flujo.updateRegistroFlujo(flujo);
        if (filled == null) throw new ValidacionException("Datos de registro de flujo inválidos para actualizar.");
        try {
            return repository.updateRegistroFlujo(filled.getIdFlujo(), filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar registro de flujo.", e);
        }
    }

    @Override
    public void getRegistroFlujoById(int id, RegistroFlujo flujo) {
        try {
            RegistroFlujo f = repository.findRegistroFlujoById(id)
                    .orElseThrow(() -> new EntidadNoEncontradaException("RegistroFlujo", id));
            System.out.println("Id: " + f.getIdFlujo() + " | Textura: " + f.getTipoTextura() + " | Color: " + f.getColor() + " | Cantidad: " + f.getCantidad());
        } catch (EntidadNoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new BaseDatosException("Error al buscar registro de flujo con id " + id, e);
        }
    }

    @Override
    public void getAllRegistrosFlujo(List<RegistroFlujo> flujos, RegistroFlujo flujo) {
        try {
            List<RegistroFlujo> result = repository.findAllRegistrosFlujo();
            if (result.isEmpty()) {
                System.out.println("No hay registros de flujo registrados.");
            } else {
                result.forEach(f -> System.out.println("[" + f.getIdFlujo() + "] Textura: " + f.getTipoTextura() + " | Color: " + f.getColor() + " | Cantidad: " + f.getCantidad()));
            }
        } catch (Exception e) {
            throw new BaseDatosException("Error al obtener registros de flujo.", e);
        }
    }

    @Override
    public void deleteRegistroFlujo(int id) {
        try {
            repository.deleteRegistroFlujoById(id);
            System.out.println("Registro de flujo con id " + id + " eliminado.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar registro de flujo con id " + id, e);
        }
    }
}
