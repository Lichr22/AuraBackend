package application.domain.enums;

public enum CategoriaSintoma {

    FISICO("Físico"),
    EMOCIONAL("Emocional"),
    DIGESTIVO("Digestivo"),
    NEUROLOGICO("Neurológico");

    private final String description;

    CategoriaSintoma(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}