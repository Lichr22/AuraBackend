package infraestructure.out.adapter;

import application.ports.UsuarioRepositoryPort;
import domain.Usuario;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.UsuarioRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryDB extends BaseRepositoryDB implements UsuarioRepositoryPort {

    private final UsuarioRowMapper mapper = new UsuarioRowMapper();


    @Override
    public Usuario saveUsuario(Usuario u) {
        String sql = "INSERT INTO usuario (nombre, email, contrasena_hash, rol, codigo_vinculacion, fecha_registro, estado_cuenta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getContrasenaHash());
            ps.setString(4, u.getRol());
            ps.setString(5, u.getCodigoVinculacion());
            ps.setTimestamp(6, Timestamp.valueOf(u.getFechaRegistro()));
            ps.setString(7, u.getEstadoCuenta());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) u.setIdUsuario(keys.getInt(1));
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e.getMessage());
        }
        return u;
    }

    @Override
    public Usuario updateUsuario(int id, Usuario u) {
        String sql = "UPDATE usuario SET nombre=?, email=?, rol=?, estado_cuenta=? WHERE id_usuario=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getRol());
            ps.setString(4, u.getEstadoCuenta());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
        return u;
    }

    @Override
    public Optional<Usuario> findUsuarioById(int id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deleteUsuarioById(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}
