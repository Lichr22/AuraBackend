package application.view;

import application.domain.PermisosCompartidos;
import application.service.PermisosCompartidosServiceImplementation;

public class PermisosCompartidosView {

    private final PermisosCompartidosServiceImplementation permisosCompartidosServiceImplementation;
    private final PermisosCompartidos permisosCompartidos;

    public PermisosCompartidosView(PermisosCompartidosServiceImplementation permisosCompartidosServiceImplementation, PermisosCompartidos permisosCompartidos) {
        this.permisosCompartidosServiceImplementation = permisosCompartidosServiceImplementation;
        this.permisosCompartidos = permisosCompartidos;
    }

    public void createPermiso() {
        permisosCompartidosServiceImplementation.createPermiso(permisosCompartidos);
    }

    public void updatePermiso() {
        permisosCompartidosServiceImplementation.updatePermiso(permisosCompartidos);
    }

}
