package application.infrastructure.mapper;

import application.domain.RecomendacionIA;
import application.domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecomendacionIARowMapper {

    public RecomendacionIA map(ResultSet rs) throws SQLException {
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
