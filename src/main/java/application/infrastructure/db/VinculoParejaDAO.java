package application.infrastructure.db;

import application.domain.Usuario;
import application.domain.VinculoPareja;
import application.infrastructure.mapper.VinculoParejaRowMapper;
import application.service.port.VinculoParejaRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VinculoParejaDAO extends BaseDAO implements VinculoParejaRepositoryPort {

    private final VinculoParejaRowMapper mapper = new VinculoParejaRowMapper();


    @Override
    public VinculoPareja saveVinculo(VinculoPareja vinculo) {
        String sql = "INSERT INTO vinculos_pareja (id_mujer, id_pareja, estado_vinculo, fecha_vinculacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, vinculo.getMujer().getIdUsuario());
            stmt.setInt(2, vinculo.getPareja().getIdUsuario());
            stmt.setString(3, vinculo.getEstadoVinculo());
            stmt.setDate(4, Date.valueOf(vinculo.getFechaVinculacion()));
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) vinculo.setIdVinculoPareja(rs.getLong(1));
            return vinculo;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar vínculo pareja: " + e.getMessage(), e);
        }
    }

    @Override
    public VinculoPareja updateVinculo(Long id, VinculoPareja vinculo) {
        String sql = "UPDATE vinculos_pareja SET estado_vinculo=? WHERE id_vinculo_pareja=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vinculo.getEstadoVinculo());
            stmt.setLong(2, id);
            stmt.executeUpdate();
            return vinculo;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar vínculo pareja: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<VinculoPareja> findVinculoById(Long id) {
        String sql = "SELECT * FROM vinculos_pareja WHERE id_vinculo_pareja = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar vínculo pareja: " + e.getMessage(), e);
        }
    }

    @Override
    public List<VinculoPareja> findAllVinculos() {
        String sql = "SELECT * FROM vinculos_pareja ORDER BY fecha_vinculacion DESC";
        List<VinculoPareja> lista = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar vínculos pareja: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deleteVinculoById(Long id) {
        String sql = "DELETE FROM vinculos_pareja WHERE id_vinculo_pareja = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar vínculo pareja: " + e.getMessage(), e);
        }
    }

}
