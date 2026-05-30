package application.service.port;

import application.domain.PermisosCompartidos;

import java.util.List;
import java.util.Optional;

public interface PermisosCompartidosRepositoryPort {

    PermisosCompartidos savePermiso(PermisosCompartidos permiso);
    PermisosCompartidos updatePermiso(Long id, PermisosCompartidos permiso);
    Optional<PermisosCompartidos> findPermisoById(Long id);
    List<PermisosCompartidos> findAllPermisos();
    void deletePermisoById(Long id);
}