package application.domain.enums;

public enum CantidadFlujo {

    LEVE("Leve"),
    MODERADO("Moderado"),
    ABUNDANTE("Abundante"),
    MUY_ABUNDANTE("Muy Abundante");

    private final String description;

    CantidadFlujo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
