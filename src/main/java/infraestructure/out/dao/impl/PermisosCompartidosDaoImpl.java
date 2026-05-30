package infraestructure.out.dao.impl;

import domain.PermisosCompartidos;
import infraestructure.out.dao.PermisosCompartidosDao;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.PermisosCompartidosRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PermisosCompartidosDaoImpl implements PermisosCompartidosDao {

    private final Connection connection;
    private final PermisosCompartidosRowMapper mapper = new PermisosCompartidosRowMapper();

    public PermisosCompartidosDaoImpl() {
        this.connection = DataBaseConnectionMySQL.getInstance().getConnection();
    }

    @Override
    public PermisosCompartidos save(PermisosCompartidos p) {
        String sql = "INSERT INTO permisos_compartidos (id_permiso, id_propietario, id_invitado, nivel_acceso, estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, p.getIdPermiso());
            ps.setObject(2, p.getUsuarioPropietario() != null ? p.getUsuarioPropietario().getIdUsuario() : null);
            ps.setObject(3, p.getUsuarioInvitado() != null ? p.getUsuarioInvitado().getIdUsuario() : null);
            ps.setString(4, p.getNivelAcceso());
            ps.setString(5, p.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar permiso: " + e.getMessage());
        }
        return p;
    }

    @Override
    public PermisosCompartidos update(Long id, PermisosCompartidos p) {
        String sql = "UPDATE permisos_compartidos SET nivel_acceso=?, estado=? WHERE id_permiso=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getNivelAcceso());
            ps.setString(2, p.getEstado());
            ps.setLong(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar permiso: " + e.getMessage());
        }
        return p;
    }

    @Override
    public Optional<PermisosCompartidos> findById(Long id) {
        String sql = "SELECT * FROM permisos_compartidos WHERE id_permiso = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al buscar permiso: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<PermisosCompartidos> findAll() {
        List<PermisosCompartidos> lista = new ArrayList<>();
        String sql = "SELECT * FROM permisos_compartidos";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al listar permisos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM permisos_compartidos WHERE id_permiso = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar permiso: " + e.getMessage());
        }
    }
}
