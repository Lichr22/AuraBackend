package infraestructure.out.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionMySQL {

    private final Connection connection;
    private static DataBaseConnectionMySQL instance;

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=aura_db;encrypt=false;trustServerCertificate=true";
    private static final String USER = "aura_user";
    private static final String PASSWORD = "Aura1234!";

    private DataBaseConnectionMySQL() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static synchronized DataBaseConnectionMySQL getInstance() {
        if (instance == null) {
            instance = new DataBaseConnectionMySQL();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
