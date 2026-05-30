package application.infrastructure.db;

import application.domain.Ciclo;
import application.domain.RegistroDiario;
import application.domain.Usuario;
import application.infrastructure.mapper.RegistroDiarioRowMapper;
import application.service.port.RegistroDiarioRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegistroDiarioDAO extends BaseDAO implements RegistroDiarioRepositoryPort {

    private final RegistroDiarioRowMapper mapper = new RegistroDiarioRowMapper();


    @Override
    public RegistroDiario saveRegistroDiario(RegistroDiario registro) {
        String sql = "INSERT INTO registros_diarios (id_usuario, id_ciclo, fecha, temperatura_basal, peso, calidad_sueno, notas_libres) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, registro.getUsuario().getIdUsuario());
            stmt.setInt(2, registro.getCiclo().getIdCiclo());
            stmt.setDate(3, Date.valueOf(registro.getFecha()));
            stmt.setDouble(4, registro.getTemperaturaBasal());
            stmt.setDouble(5, registro.getPeso());
            stmt.setString(6, registro.getCalidadSueno());
            stmt.setString(7, registro.getNotasLibres());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) registro.setIdRegistro(rs.getInt(1));
            return registro;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar registro diario: " + e.getMessage(), e);
        }
    }

    @Override
    public RegistroDiario updateRegistroDiario(int id, RegistroDiario registro) {
        String sql = "UPDATE registros_diarios SET fecha=?, temperatura_basal=?, peso=?, calidad_sueno=?, notas_libres=? WHERE id_registro=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(registro.getFecha()));
            stmt.setDouble(2, registro.getTemperaturaBasal());
            stmt.setDouble(3, registro.getPeso());
            stmt.setString(4, registro.getCalidadSueno());
            stmt.setString(5, registro.getNotasLibres());
            stmt.setInt(6, id);
            stmt.executeUpdate();
            return registro;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar registro diario: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<RegistroDiario> findRegistroDiarioById(int id) {
        String sql = "SELECT * FROM registros_diarios WHERE id_registro = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar registro diario: " + e.getMessage(), e);
        }
    }

    @Override
    public List<RegistroDiario> findAllRegistrosDiarios() {
        String sql = "SELECT * FROM registros_diarios ORDER BY fecha DESC";
        List<RegistroDiario> lista = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar registros diarios: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deleteRegistroDiarioById(int id) {
        String sql = "DELETE FROM registros_diarios WHERE id_registro = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar registro diario: " + e.getMessage(), e);
        }
    }

}
