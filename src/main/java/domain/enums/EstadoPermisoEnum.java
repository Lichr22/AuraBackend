package domain.enums;

public enum EstadoPermisoEnum {

    ACTIVO("Activo"),
    INACTIVO("Inactivo"),
    PENDIENTE("Pendiente");

    private final String description;

    EstadoPermisoEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
