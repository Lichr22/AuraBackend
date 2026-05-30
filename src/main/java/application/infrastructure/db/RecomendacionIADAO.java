package application.infrastructure.db;

import application.domain.RecomendacionIA;
import application.domain.Usuario;
import application.service.port.RecomendacionIARepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecomendacionIADAO implements RecomendacionIARepositoryPort {

    private final Connection connection;

    public RecomendacionIADAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public RecomendacionIA saveRecomendacion(RecomendacionIA recomendacion) {
        String sql = "INSERT INTO recomendaciones_ia (id_usuario, titulo, contenido, fecha_creacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, recomendacion.getUsuario().getIdUsuario());
            stmt.setString(2, recomendacion.getTitulo());
            stmt.setString(3, recomendacion.getContenido());
            stmt.setTimestamp(4, Timestamp.valueOf(recomendacion.getFechaCreacion()));
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) recomendacion.setIdRecomendacion(rs.getLong(1));
            return recomendacion;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar recomendación IA: " + e.getMessage(), e);
        }
    }

    @Override
    public RecomendacionIA updateRecomendacion(Long id, RecomendacionIA recomendacion) {
        String sql = "UPDATE recomendaciones_ia SET titulo=?, contenido=? WHERE id_recomendacion=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, recomendacion.getTitulo());
            stmt.setString(2, recomendacion.getContenido());
            stmt.setLong(3, id);
            stmt.executeUpdate();
            return recomendacion;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar recomendación IA: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<RecomendacionIA> findRecomendacionById(Long id) {
        String sql = "SELECT * FROM recomendaciones_ia WHERE id_recomendacion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapear(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar recomendación IA: " + e.getMessage(), e);
        }
    }

    @Override
    public List<RecomendacionIA> findAllRecomendaciones() {
        String sql = "SELECT * FROM recomendaciones_ia ORDER BY fecha_creacion DESC";
        List<RecomendacionIA> lista = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar recomendaciones IA: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deleteRecomendacionById(Long id) {
        String sql = "DELETE FROM recomendaciones_ia WHERE id_recomendacion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar recomendación IA: " + e.getMessage(), e);
        }
    }

    private RecomendacionIA mapear(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("id_usuario"));

        return new RecomendacionIA(
            rs.getLong("id_recomendacion"),
            usuario,
            rs.getString("titulo"),
            rs.getString("contenido"),
            rs.getTimestamp("fecha_creacion").toLocalDateTime()
        );
    }
}
