package application.exception;

public class ValidacionException extends Exception {
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}
// Checked: el llamador DEBE manejarla (ej: validación de negocio)
