package application.infrastructure.mapper;

import application.domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UsuarioRowMapper {

    public Usuario map(ResultSet rs) throws SQLException {
        Timestamp ts = rs.getTimestamp("fecha_registro");
        return new Usuario(
            rs.getInt("id_usuario"),
            rs.getString("nombre"),
            rs.getString("email"),
            rs.getString("contrasena_hash"),
            rs.getString("rol"),
            rs.getString("codigo_vinculacion"),
            ts != null ? ts.toLocalDateTime() : LocalDateTime.now(),
            rs.getString("estado_cuenta")
        );
    }
}
