package application.domain.enums;

public enum EstadoVinculo {

    ACTIVO("Activo"),
    INACTIVO("Inactivo"),
    PENDIENTE("Pendiente");

    private final String description;

    EstadoVinculo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}