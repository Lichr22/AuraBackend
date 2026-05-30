package application.exception;

public class BaseDatosException extends RuntimeException {
    public BaseDatosException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
// Unchecked: errores de infraestructura graves