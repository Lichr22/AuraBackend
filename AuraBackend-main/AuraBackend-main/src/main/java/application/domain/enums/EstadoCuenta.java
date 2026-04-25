package application.domain.enums;

public enum EstadoCuenta {

    ACTIVO("Activo"),
    INACTIVO("Inactivo"),
    SUSPENDIDO("Suspendido");

    private final String description;

    EstadoCuenta(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
