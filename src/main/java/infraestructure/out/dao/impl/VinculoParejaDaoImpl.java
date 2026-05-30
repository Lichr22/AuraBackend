package infraestructure.out.dao.impl;

import domain.VinculoPareja;
import infraestructure.out.dao.VinculoParejaDao;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.VinculoParejaRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VinculoParejaDaoImpl implements VinculoParejaDao {

    private final Connection connection;
    private final VinculoParejaRowMapper mapper = new VinculoParejaRowMapper();

    public VinculoParejaDaoImpl() {
        this.connection = DataBaseConnectionMySQL.getInstance().getConnection();
    }

    @Override
    public VinculoPareja save(VinculoPareja v) {
        String sql = "INSERT INTO vinculo_pareja (id_vinculo_pareja, id_mujer, id_pareja, estado_vinculo, fecha_vinculacion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, v.getIdVinculoPareja());
            ps.setObject(2, v.getMujer() != null ? v.getMujer().getIdUsuario() : null);
            ps.setObject(3, v.getPareja() != null ? v.getPareja().getIdUsuario() : null);
            ps.setString(4, v.getEstadoVinculo());
            ps.setDate(5, Date.valueOf(v.getFechaVinculacion()));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar vínculo: " + e.getMessage());
        }
        return v;
    }

    @Override
    public VinculoPareja update(Long id, VinculoPareja v) {
        String sql = "UPDATE vinculo_pareja SET estado_vinculo=? WHERE id_vinculo_pareja=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, v.getEstadoVinculo());
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar vínculo: " + e.getMessage());
        }
        return v;
    }

    @Override
    public Optional<VinculoPareja> findById(Long id) {
        String sql = "SELECT * FROM vinculo_pareja WHERE id_vinculo_pareja = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al buscar vínculo: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<VinculoPareja> findAll() {
        List<VinculoPareja> lista = new ArrayList<>();
        String sql = "SELECT * FROM vinculo_pareja";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al listar vínculos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM vinculo_pareja WHERE id_vinculo_pareja = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar vínculo: " + e.getMessage());
        }
    }
}
