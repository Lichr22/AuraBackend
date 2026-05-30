package infraestructure.out.adapter;

import infraestructure.out.db.DataBaseConnectionMySQL;
import java.sql.Connection;

/**
 * Clase base para los adaptadores de persistencia en base de datos.
 * Aplica el principio DRY (Don't Repeat Yourself) para reutilizar
 * la declaración y obtención de la conexión a la base de datos MySQL.
 */
public abstract class BaseRepositoryDB {
    protected final Connection connection;

    public BaseRepositoryDB() {
        this.connection = DataBaseConnectionMySQL.getInstance().getConnection();
    }
}
