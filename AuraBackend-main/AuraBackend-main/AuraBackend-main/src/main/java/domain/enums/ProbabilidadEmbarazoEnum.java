package domain.enums;

public enum ProbabilidadEmbarazoEnum {

    ALTA("Alta"),
    MEDIA("Media"),
    BAJA("Baja"),
    MUY_BAJA("Muy Baja");

    private final String description;

    ProbabilidadEmbarazoEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
