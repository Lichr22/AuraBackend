package application.domain.enums;

public enum RolUsuario {

    USUARIO("Usuario"),
    PAREJA("Pareja"),
    ADMINISTRADOR("Administrador");

    private final String description;

    RolUsuario(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}