package application.infrastructure.db;

import application.domain.Ciclo;
import application.domain.Usuario;
import application.infrastructure.mapper.CicloRowMapper;
import application.service.port.CicloRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CicloDAO extends BaseDAO implements CicloRepositoryPort {

    private final CicloRowMapper mapper = new CicloRowMapper();


    @Override
    public Ciclo saveCiclo(Ciclo ciclo) {
        String sql = "INSERT INTO ciclos (id_usuario, fecha_inicio, fecha_fin, duracion_total, es_regular) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, ciclo.getUsuario().getIdUsuario());
            stmt.setDate(2, Date.valueOf(ciclo.getFechaInicio()));
            stmt.setDate(3, ciclo.getFechaFin() != null ? Date.valueOf(ciclo.getFechaFin()) : null);
            stmt.setInt(4, ciclo.getDuracionTotal());
            stmt.setBoolean(5, ciclo.isEsRegular());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) ciclo.setIdCiclo(rs.getInt(1));
            return ciclo;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar ciclo: " + e.getMessage(), e);
        }
    }

    @Override
    public Ciclo updateCiclo(int id, Ciclo ciclo) {
        String sql = "UPDATE ciclos SET fecha_inicio=?, fecha_fin=?, duracion_total=?, es_regular=? WHERE id_ciclo=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(ciclo.getFechaInicio()));
            stmt.setDate(2, ciclo.getFechaFin() != null ? Date.valueOf(ciclo.getFechaFin()) : null);
            stmt.setInt(3, ciclo.getDuracionTotal());
            stmt.setBoolean(4, ciclo.isEsRegular());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            return ciclo;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar ciclo: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Ciclo> findCicloById(int id) {
        String sql = "SELECT * FROM ciclos WHERE id_ciclo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar ciclo: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Ciclo> findAllCiclos() {
        String sql = "SELECT * FROM ciclos ORDER BY fecha_inicio DESC";
        List<Ciclo> lista = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar ciclos: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deleteCicloById(int id) {
        String sql = "DELETE FROM ciclos WHERE id_ciclo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar ciclo: " + e.getMessage(), e);
        }
    }

}
