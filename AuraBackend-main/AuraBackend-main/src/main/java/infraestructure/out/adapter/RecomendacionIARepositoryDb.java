package infraestructure.out.adapter;

import application.ports.RecomendacionIARepositoryPort;
import domain.RecomendacionIA;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.RecomendacionIARowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecomendacionIARepositoryDb extends BaseRepositoryDB implements RecomendacionIARepositoryPort {

    private final RecomendacionIARowMapper mapper = new RecomendacionIARowMapper();


    @Override
    public RecomendacionIA saveRecomendacion(RecomendacionIA r) {
        String sql = "INSERT INTO recomendacion_ia (id_usuario, titulo, contenido, fecha_creacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setObject(1, r.getUsuario() != null ? r.getUsuario().getIdUsuario() : null);
            ps.setString(2, r.getTitulo());
            ps.setString(3, r.getContenido());
            ps.setTimestamp(4, Timestamp.valueOf(r.getFechaCreacion()));
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) r.setIdRecomendacion(keys.getLong(1));
        } catch (SQLException e) {
            System.out.println("Error al guardar recomendación: " + e.getMessage());
        }
        return r;
    }

    @Override
    public RecomendacionIA updateRecomendacion(Long id, RecomendacionIA r) {
        String sql = "UPDATE recomendacion_ia SET titulo=?, contenido=? WHERE id_recomendacion=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, r.getTitulo());
            ps.setString(2, r.getContenido());
            ps.setLong(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar recomendación: " + e.getMessage());
        }
        return r;
    }

    @Override
    public Optional<RecomendacionIA> findRecomendacionById(Long id) {
        String sql = "SELECT * FROM recomendacion_ia WHERE id_recomendacion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al buscar recomendación: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<RecomendacionIA> findAllRecomendaciones() {
        List<RecomendacionIA> lista = new ArrayList<>();
        String sql = "SELECT * FROM recomendacion_ia";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al listar recomendaciones: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deleteRecomendacionById(Long id) {
        String sql = "DELETE FROM recomendacion_ia WHERE id_recomendacion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar recomendación: " + e.getMessage());
        }
    }
}
