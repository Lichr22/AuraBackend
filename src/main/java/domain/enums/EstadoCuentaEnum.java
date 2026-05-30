package domain.enums;

public enum EstadoCuentaEnum {

    ACTIVO("Activo"),
    INACTIVO("Inactivo"),
    SUSPENDIDO("Suspendido");

    private final String description;

    EstadoCuentaEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
