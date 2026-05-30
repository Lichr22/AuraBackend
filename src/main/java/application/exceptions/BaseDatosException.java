package application.exceptions;

public class BaseDatosException extends RuntimeException {
    public BaseDatosException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
