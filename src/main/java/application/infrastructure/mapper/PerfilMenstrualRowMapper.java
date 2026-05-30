package application.infrastructure.mapper;

import application.domain.PerfilMenstrual;
import application.domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PerfilMenstrualRowMapper {

    public PerfilMenstrual map(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("id_usuario"));

        return new PerfilMenstrual(
            rs.getInt("id_perfil"),
            usuario,
            rs.getInt("edad"),
            rs.getInt("ciclo_promedio"),
            rs.getInt("duracion_periodo_promedio"),
            rs.getBoolean("usa_anticonceptivo"),
            rs.getString("tipo_anticonceptivo")
        );
    }
}
