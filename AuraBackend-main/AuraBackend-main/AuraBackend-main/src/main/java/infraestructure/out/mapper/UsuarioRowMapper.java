package infraestructure.out.mapper;

import domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UsuarioRowMapper {

    public Usuario map(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getInt("id_usuario"),
                rs.getString("nombre"),
                rs.getString("email"),
                rs.getString("contrasena_hash"),
                rs.getString("rol"),
                rs.getString("codigo_vinculacion"),
                rs.getTimestamp("fecha_registro") != null
                        ? rs.getTimestamp("fecha_registro").toLocalDateTime()
                        : LocalDateTime.now(),
                rs.getString("estado_cuenta")
        );
    }
}
