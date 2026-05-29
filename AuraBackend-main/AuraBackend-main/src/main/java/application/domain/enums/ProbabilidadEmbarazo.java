package application.domain.enums;

public enum ProbabilidadEmbarazo {

    ALTA("Alta"),
    MEDIA("Media"),
    BAJA("Baja"),
    MUY_BAJA("Muy Baja");

    private final String description;

    ProbabilidadEmbarazo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
