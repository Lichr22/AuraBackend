package application.domain.enums;

public enum MetodoAdicional {

    PRESERVATIVO("Preservativo"),
    PILDORA("Píldora"),
    DIU("DIU"),
    NINGUNO("Ninguno");

    private final String description;

    MetodoAdicional(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
