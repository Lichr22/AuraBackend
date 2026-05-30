package domain.enums;

public enum MetodoAdicionalEnum {

    PRESERVATIVO("Preservativo"),
    PILDORA("Píldora"),
    DIU("DIU"),
    NINGUNO("Ninguno");

    private final String description;

    MetodoAdicionalEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
