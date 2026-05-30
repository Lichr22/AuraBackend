package application.infrastructure.db;

import application.domain.ActividadSexual;
import application.domain.RegistroDiario;
import application.infrastructure.mapper.ActividadSexualRowMapper;
import application.service.port.ActividadSexualRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActividadSexualDAO extends BaseDAO implements ActividadSexualRepositoryPort {

    private final ActividadSexualRowMapper mapper = new ActividadSexualRowMapper();


    @Override
    public ActividadSexual saveActividadSexual(ActividadSexual actividad) {
        String sql = "INSERT INTO actividades_sexuales (id_registro, uso_preservativo, orgasmo, metodo_adicional) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, actividad.getRegistroDiario().getIdRegistro());
            stmt.setBoolean(2, actividad.getUsoPreservativo());
            stmt.setBoolean(3, actividad.getOrgasmo());
            stmt.setString(4, actividad.getMetodoAdicional());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) actividad.setIdActividad(rs.getInt(1));
            return actividad;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar actividad sexual: " + e.getMessage(), e);
        }
    }

    @Override
    public ActividadSexual updateActividadSexual(int id, ActividadSexual actividad) {
        String sql = "UPDATE actividades_sexuales SET uso_preservativo=?, orgasmo=?, metodo_adicional=? WHERE id_actividad=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, actividad.getUsoPreservativo());
            stmt.setBoolean(2, actividad.getOrgasmo());
            stmt.setString(3, actividad.getMetodoAdicional());
            stmt.setInt(4, id);
            stmt.executeUpdate();
            return actividad;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar actividad sexual: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<ActividadSexual> findActividadSexualById(int id) {
        String sql = "SELECT * FROM actividades_sexuales WHERE id_actividad = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar actividad sexual: " + e.getMessage(), e);
        }
    }

    @Override
    public List<ActividadSexual> findAllActividadesSexuales() {
        String sql = "SELECT * FROM actividades_sexuales ORDER BY id_actividad DESC";
        List<ActividadSexual> lista = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar actividades sexuales: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deleteActividadSexualById(int id) {
        String sql = "DELETE FROM actividades_sexuales WHERE id_actividad = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar actividad sexual: " + e.getMessage(), e);
        }
    }

}
