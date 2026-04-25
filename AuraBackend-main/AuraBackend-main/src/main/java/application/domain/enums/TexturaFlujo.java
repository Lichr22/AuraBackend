package application.domain.enums;

public enum TexturaFlujo {

    ACUOSO("Acuoso"),
    CREMOSO("Cremoso"),
    ESPESO("Espeso"),
    CON_COAGULOS("Con Coágulos");

    private final String description;

    TexturaFlujo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}