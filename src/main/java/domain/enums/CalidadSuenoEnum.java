package domain.enums;

public enum CalidadSuenoEnum {

    EXCELENTE("Excelente"),
    BUENO("Bueno"),
    REGULAR("Regular"),
    MALO("Malo");

    private final String description;

    CalidadSuenoEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
