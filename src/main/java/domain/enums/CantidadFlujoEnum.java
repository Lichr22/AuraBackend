package domain.enums;

public enum CantidadFlujoEnum {

    LEVE("Leve"),
    MODERADO("Moderado"),
    ABUNDANTE("Abundante"),
    MUY_ABUNDANTE("Muy Abundante");

    private final String description;

    CantidadFlujoEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
