package application;

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
    public RegistroFlujo createRegistroFlujo(RegistroFlujo flujo) {
        RegistroFlujo filled = RegistroFlujo.createRegistroFlujo(flujo);
        return filled != null ? repository.saveRegistroFlujo(filled) : null;
    }

    @Override
    public RegistroFlujo updateRegistroFlujo(RegistroFlujo flujo) {
        RegistroFlujo filled = flujo.updateRegistroFlujo(flujo);
        return filled != null ? repository.updateRegistroFlujo(filled.getIdFlujo(), filled) : null;
    }

    @Override
    public void getRegistroFlujoById(int id, RegistroFlujo flujo) {
        repository.findRegistroFlujoById(id)
                .ifPresentOrElse(
                        f -> System.out.println("Id: " + f.getIdFlujo() + " | Textura: " + f.getTipoTextura() + " | Color: " + f.getColor() + " | Cantidad: " + f.getCantidad()),
                        () -> System.out.println("Flujo con id " + id + " no encontrado.")
                );
    }

    @Override
    public void getAllRegistrosFlujo(List<RegistroFlujo> flujos, RegistroFlujo flujo) {
        List<RegistroFlujo> result = repository.findAllRegistrosFlujo();
        if (result.isEmpty()) {
            System.out.println("No hay registros de flujo registrados.");
        } else {
            result.forEach(f -> System.out.println("[" + f.getIdFlujo() + "] Textura: " + f.getTipoTextura() + " | Color: " + f.getColor() + " | Cantidad: " + f.getCantidad()));
        }
    }

    @Override
    public void deleteRegistroFlujo(int id) {
        repository.deleteRegistroFlujoById(id);
        System.out.println("Registro de flujo con id " + id + " eliminado.");
    }
}
