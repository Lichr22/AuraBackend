package application.infrastructure.db;

import application.domain.RegistroDiario;
import application.domain.RegistroFlujo;
import application.service.port.RegistroFlujoRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegistroFlujoDAO implements RegistroFlujoRepositoryPort {

    private final Connection connection;

    public RegistroFlujoDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public RegistroFlujo saveRegistroFlujo(RegistroFlujo flujo) {
        String sql = "INSERT INTO registros_flujo (id_registro, tipo_textura, color, cantidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, flujo.getRegistro().getIdRegistro());
            stmt.setString(2, flujo.getTipoTextura());
            stmt.setString(3, flujo.getColor());
            stmt.setString(4, flujo.getCantidad());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) flujo.setIdFlujo(rs.getInt(1));
            return flujo;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar registro flujo: " + e.getMessage(), e);
        }
    }

    @Override
    public RegistroFlujo updateRegistroFlujo(int id, RegistroFlujo flujo) {
        String sql = "UPDATE registros_flujo SET tipo_textura=?, color=?, cantidad=? WHERE id_flujo=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, flujo.getTipoTextura());
            stmt.setString(2, flujo.getColor());
            stmt.setString(3, flujo.getCantidad());
            stmt.setInt(4, id);
            stmt.executeUpdate();
            return flujo;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar registro flujo: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<RegistroFlujo> findRegistroFlujoById(int id) {
        String sql = "SELECT * FROM registros_flujo WHERE id_flujo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapear(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar registro flujo: " + e.getMessage(), e);
        }
    }

    @Override
    public List<RegistroFlujo> findAllRegistrosFlujo() {
        String sql = "SELECT * FROM registros_flujo ORDER BY id_flujo DESC";
        List<RegistroFlujo> lista = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar registros flujo: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deleteRegistroFlujoById(int id) {
        String sql = "DELETE FROM registros_flujo WHERE id_flujo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar registro flujo: " + e.getMessage(), e);
        }
    }

    private RegistroFlujo mapear(ResultSet rs) throws SQLException {
        // Agregación: RegistroFlujo agrega a RegistroDiario (req. 9)
        RegistroDiario registroDiario = new RegistroDiario(rs.getInt("id_registro"));

        return new RegistroFlujo(
            rs.getInt("id_flujo"),
            registroDiario,
            rs.getString("tipo_textura"),
            rs.getString("color"),
            rs.getString("cantidad")
        );
    }
}
