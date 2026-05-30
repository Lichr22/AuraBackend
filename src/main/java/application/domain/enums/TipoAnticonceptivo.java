package application.domain.enums;

public enum TipoAnticonceptivo {

    PILDORA("Píldora"),
    DIU("DIU"),
    IMPLANTE("Implante"),
    INYECCION("Inyección"),
    CONDON("Condón"),
    NINGUNO("Ninguno");

    private final String description;

    TipoAnticonceptivo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
