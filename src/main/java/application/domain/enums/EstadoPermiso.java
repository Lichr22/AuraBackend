package application.domain.enums;

public enum EstadoPermiso {

    ACTIVO("Activo"),
    INACTIVO("Inactivo"),
    PENDIENTE("Pendiente");

    private final String description;

    EstadoPermiso(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
