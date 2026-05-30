package application.exception;

public class EntidadNoEncontradaException extends RuntimeException {
    public EntidadNoEncontradaException(String entidad, int id) {
        super(entidad + " con id " + id + " no encontrado.");
    }
}
// Para cuando no encuentras algo
