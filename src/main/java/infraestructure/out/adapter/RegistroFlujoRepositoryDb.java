package infraestructure.out.adapter;

import application.ports.RegistroFlujoRepositoryPort;
import domain.RegistroFlujo;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.RegistroFlujoRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegistroFlujoRepositoryDb implements RegistroFlujoRepositoryPort {

    private final Connection connection;
    private final RegistroFlujoRowMapper mapper = new RegistroFlujoRowMapper();

    public RegistroFlujoRepositoryDb() {
        this.connection = DataBaseConnectionMySQL.getInstance().getConnection();
    }

    @Override
    public RegistroFlujo saveRegistroFlujo(RegistroFlujo f) {
        String sql = "INSERT INTO registro_flujo (id_flujo, id_registro, tipo_textura, color, cantidad) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, f.getIdFlujo());
            ps.setObject(2, f.getRegistro() != null ? f.getRegistro().getIdRegistro() : null);
            ps.setString(3, f.getTipoTextura());
            ps.setString(4, f.getColor());
            ps.setString(5, f.getCantidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar registro de flujo: " + e.getMessage());
        }
        return f;
    }

    @Override
    public RegistroFlujo updateRegistroFlujo(int id, RegistroFlujo f) {
        String sql = "UPDATE registro_flujo SET tipo_textura=?, color=?, cantidad=? WHERE id_flujo=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, f.getTipoTextura());
            ps.setString(2, f.getColor());
            ps.setString(3, f.getCantidad());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar registro de flujo: " + e.getMessage());
        }
        return f;
    }

    @Override
    public Optional<RegistroFlujo> findRegistroFlujoById(int id) {
        String sql = "SELECT * FROM registro_flujo WHERE id_flujo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al buscar registro de flujo: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<RegistroFlujo> findAllRegistrosFlujo() {
        List<RegistroFlujo> lista = new ArrayList<>();
        String sql = "SELECT * FROM registro_flujo";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al listar registros de flujo: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deleteRegistroFlujoById(int id) {
        String sql = "DELETE FROM registro_flujo WHERE id_flujo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar registro de flujo: " + e.getMessage());
        }
    }
}
