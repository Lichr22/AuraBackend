package application.infrastructure.db;

import application.domain.Usuario;
import application.domain.VinculoPareja;
import application.service.port.VinculoParejaRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VinculoParejaDAO implements VinculoParejaRepositoryPort {

    private final Connection connection;

    public VinculoParejaDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

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
            if (rs.next()) return Optional.of(mapear(rs));
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
            while (rs.next()) lista.add(mapear(rs));
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

    private VinculoPareja mapear(ResultSet rs) throws SQLException {
        // Asociación bidireccional: VinculoPareja tiene dos Usuarios (req. 9)
        Usuario mujer = new Usuario();
        mujer.setIdUsuario(rs.getInt("id_mujer"));

        Usuario pareja = new Usuario();
        pareja.setIdUsuario(rs.getInt("id_pareja"));

        return new VinculoPareja(
            rs.getLong("id_vinculo_pareja"),
            mujer,
            pareja,
            rs.getString("estado_vinculo"),
            rs.getDate("fecha_vinculacion").toLocalDate()
        );
    }
}
