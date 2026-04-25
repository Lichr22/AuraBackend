package application.domain.enums;

public enum NivelAcceso {

    LECTURA("Lectura"),
    ESCRITURA("Escritura"),
    TOTAL("Total");

    private final String description;

    NivelAcceso(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
