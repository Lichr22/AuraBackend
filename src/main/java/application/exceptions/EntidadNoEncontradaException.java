package application.exceptions;

public class EntidadNoEncontradaException extends RuntimeException {
    public EntidadNoEncontradaException(String entidad, int id) {
        super(entidad + " con id " + id + " no encontrado.");
    }

    public EntidadNoEncontradaException(String entidad, Long id) {
        super(entidad + " con id " + id + " no encontrado.");
    }
}
