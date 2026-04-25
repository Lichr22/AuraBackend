package application.domain.enums;

public enum CalidadSueno {

    EXCELENTE("Excelente"),
    BUENO("Bueno"),
    REGULAR("Regular"),
    MALO("Malo");

    private final String description;

    CalidadSueno(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
