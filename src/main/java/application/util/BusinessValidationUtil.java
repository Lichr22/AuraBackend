package application.util;

import application.exception.ValidacionException;

public class BusinessValidationUtil {

    public static void validarEmailUnico(String email, java.util.List<application.domain.Usuario> usuarios)
            throws application.exception.ValidacionException {
        boolean existe = usuarios.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email));
        if (existe) {
            throw new ValidacionException("El email '" + email + "' ya está registrado.");
        }
    }

    public static void validarDuracionCiclo(int dias)
            throws application.exception.ValidacionException {
        if (dias < 21 || dias > 45) {
            throw new ValidacionException("La duración del ciclo debe estar entre 21 y 45 días.");
        }
    }

    public static void validarFechas(java.time.LocalDate inicio, java.time.LocalDate fin)
            throws application.exception.ValidacionException {
        if (fin.isBefore(inicio)) {
            throw new ValidacionException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }
    }
}