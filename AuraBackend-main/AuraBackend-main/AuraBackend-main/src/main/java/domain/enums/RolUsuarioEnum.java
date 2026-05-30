package domain.enums;

public enum RolUsuarioEnum {

    USUARIO("Usuario"),
    PAREJA("Pareja"),
    ADMINISTRADOR("Administrador");

    private final String description;

    RolUsuarioEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}