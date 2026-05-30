package application.infrastructure.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    // Cambia estos valores según tu configuración local
    private static final String URL      = "jdbc:postgresql://localhost:5432/aura_db";
    private static final String USER     = "postgres";
    private static final String PASSWORD = "tu_password";

    private DatabaseConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✔ Conexión a la base de datos establecida.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver PostgreSQL no encontrado. Revisa el pom.xml.", e);
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo conectar a la base de datos: " + e.getMessage(), e);
        }
    }

    // Patrón Singleton — una sola conexión en toda la aplicación (req. 6)
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
