package domain.enums;

public enum CategoriaRecomendacionEnum {

    NUTRICION("Nutrición"),
    EJERCICIO("Ejercicio"),
    BIENESTAR("Bienestar"),
    MEDICO("Médico");

    private final String description;

    CategoriaRecomendacionEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}