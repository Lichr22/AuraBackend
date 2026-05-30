package domain.enums;

public enum NivelAccesoEnum {

    LECTURA("Lectura"),
    ESCRITURA("Escritura"),
    TOTAL("Total");

    private final String description;

    NivelAccesoEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
