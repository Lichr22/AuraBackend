package domain.enums;

public enum EstadoVinculoEnum {

    ACTIVO("Activo"),
    INACTIVO("Inactivo"),
    PENDIENTE("Pendiente");

    private final String description;

    EstadoVinculoEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}