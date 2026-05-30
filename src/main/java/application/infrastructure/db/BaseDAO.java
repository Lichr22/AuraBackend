package application.infrastructure.db;

import java.sql.Connection;

/**
 * Clase base para los Objetos de Acceso a Datos (DAOs).
 * Aplica el principio DRY (Don't Repeat Yourself) al unificar
 * la declaración y obtención de la conexión a la base de datos.
 *
 * También respeta SRP (Single Responsibility Principle) al delegar
 * la gestión del ciclo de vida de la conexión a DatabaseConnection.
 */
public abstract class BaseDAO {
    protected final Connection connection;

    public BaseDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
}
