package application.domain.enums;

public enum ColorFlujo {

    ROJO_BRILLANTE("Rojo Brillante"),
    ROJO_OSCURO("Rojo Oscuro"),
    MARRON("Marrón"),
    ROSADO("Rosado"),
    NEGRO("Negro");

    private final String description;

    ColorFlujo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}