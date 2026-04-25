package application.domain.enums;

public enum CategoriaRecomendacion {

    NUTRICION("Nutrición"),
    EJERCICIO("Ejercicio"),
    BIENESTAR("Bienestar"),
    MEDICO("Médico");

    private final String description;

    CategoriaRecomendacion(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}