package application;

import application.exceptions.BaseDatosException;
import application.exceptions.EntidadNoEncontradaException;
import application.exceptions.ValidacionException;
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
    public PermisosCompartidos createPermiso(PermisosCompartidos permiso) throws ValidacionException {
        PermisosCompartidos filled = permiso.createPermiso(permiso);
        if (filled == null) throw new ValidacionException("Datos de permiso inválidos.");
        try {
            return repository.savePermiso(filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar permiso.", e);
        }
    }

    @Override
    public PermisosCompartidos updatePermiso(PermisosCompartidos permiso) throws ValidacionException {
        PermisosCompartidos filled = permiso.updatePermiso(permiso);
        if (filled == null) throw new ValidacionException("Datos de permiso inválidos para actualizar.");
        try {
            return repository.updatePermiso(filled.getIdPermiso(), filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar permiso.", e);
        }
    }

    @Override
    public void getPermisoById(Long id, PermisosCompartidos permiso) {
        try {
            PermisosCompartidos p = repository.findPermisoById(id)
                    .orElseThrow(() -> new EntidadNoEncontradaException("PermisosCompartidos", id));
            System.out.println("Id: " + p.getIdPermiso() + " | Nivel: " + p.getNivelAcceso() + " | Estado: " + p.getEstado());
        } catch (EntidadNoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new BaseDatosException("Error al buscar permiso con id " + id, e);
        }
    }

    @Override
    public void getAllPermisos(List<PermisosCompartidos> permisos, PermisosCompartidos permiso) {
        try {
            List<PermisosCompartidos> result = repository.findAllPermisos();
            if (result.isEmpty()) {
                System.out.println("No hay permisos registrados.");
            } else {
                result.forEach(p -> System.out.println("[" + p.getIdPermiso() + "] Nivel: " + p.getNivelAcceso() + " | Estado: " + p.getEstado()));
            }
        } catch (Exception e) {
            throw new BaseDatosException("Error al obtener permisos.", e);
        }
    }

    @Override
    public void deletePermiso(Long id) {
        try {
            repository.deletePermisoById(id);
            System.out.println("Permiso con id " + id + " eliminado.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar permiso con id " + id, e);
        }
    }
}
