package domain.enums;

public enum CategoriaSintomaEnum {

    FISICO("Físico"),
    EMOCIONAL("Emocional"),
    DIGESTIVO("Digestivo"),
    NEUROLOGICO("Neurológico");

    private final String description;

    CategoriaSintomaEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}