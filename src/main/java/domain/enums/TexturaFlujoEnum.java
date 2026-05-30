package domain.enums;

public enum TexturaFlujoEnum {

    ACUOSO("Acuoso"),
    CREMOSO("Cremoso"),
    ESPESO("Espeso"),
    CON_COAGULOS("Con Coágulos");

    private final String description;

    TexturaFlujoEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}