package domain.enums;

public enum ColorFlujoEnum {

    ROJO_BRILLANTE("Rojo Brillante"),
    ROJO_OSCURO("Rojo Oscuro"),
    MARRON("Marrón"),
    ROSADO("Rosado"),
    NEGRO("Negro");

    private final String description;

    ColorFlujoEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}