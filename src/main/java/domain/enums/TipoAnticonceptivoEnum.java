package domain.enums;

public enum TipoAnticonceptivoEnum {

    PILDORA("Píldora"),
    DIU("DIU"),
    IMPLANTE("Implante"),
    INYECCION("Inyección"),
    CONDON("Condón"),
    NINGUNO("Ninguno");

    private final String description;

    TipoAnticonceptivoEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
