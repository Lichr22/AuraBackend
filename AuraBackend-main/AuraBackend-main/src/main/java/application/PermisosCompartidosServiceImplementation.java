package application;

import application.inputs.PermisosCompartidosService;
import application.ports.PermisosCompartidosRepositoryPort;
import domain.PermisosCompartidos;

import java.util.List;

public class PermisosCompartidosServiceImplementation implements PermisosCompartidosService {

    private final PermisosCompartidosRepositoryPort repository;

    public PermisosCompartidosServiceImplementation(PermisosCompartidosRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PermisosCompartidos createPermiso(PermisosCompartidos permiso) {
        PermisosCompartidos filled = permiso.createPermiso(permiso);
        return filled != null ? repository.savePermiso(filled) : null;
    }

    @Override
    public PermisosCompartidos updatePermiso(PermisosCompartidos permiso) {
        PermisosCompartidos filled = permiso.updatePermiso(permiso);
        return filled != null ? repository.updatePermiso(filled.getIdPermiso(), filled) : null;
    }

    @Override
    public void getPermisoById(Long id, PermisosCompartidos permiso) {
        repository.findPermisoById(id)
                .ifPresentOrElse(
                        p -> System.out.println("Id: " + p.getIdPermiso() + " | Nivel: " + p.getNivelAcceso() + " | Estado: " + p.getEstado()),
                        () -> System.out.println("Permiso con id " + id + " no encontrado.")
                );
    }

    @Override
    public void getAllPermisos(List<PermisosCompartidos> permisos, PermisosCompartidos permiso) {
        List<PermisosCompartidos> result = repository.findAllPermisos();
        if (result.isEmpty()) {
            System.out.println("No hay permisos registrados.");
        } else {
            result.forEach(p -> System.out.println("[" + p.getIdPermiso() + "] Nivel: " + p.getNivelAcceso() + " | Estado: " + p.getEstado()));
        }
    }

    @Override
    public void deletePermiso(Long id) {
        repository.deletePermisoById(id);
        System.out.println("Permiso con id " + id + " eliminado.");
    }
}
