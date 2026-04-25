package application.domain.enums;

public enum RegistroMenstrualEnums {

    PILL("Pill"),
    IUD("IUD"),
    IMPLANT("Implant"),
    INJECTION("Injection"),
    CONDOM("Condom"),
    NONE("None");

    private final String description;

    RegistroMenstrualEnums(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
