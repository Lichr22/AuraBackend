package application.infrastructure.mapper;

import application.domain.Ciclo;
import application.domain.Usuario;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CicloRowMapper {

    public Ciclo map(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("id_usuario"));

        Date fechaFin = rs.getDate("fecha_fin");
        return new Ciclo(
            rs.getInt("id_ciclo"),
            usuario,
            rs.getDate("fecha_inicio").toLocalDate(),
            fechaFin != null ? fechaFin.toLocalDate() : null,
            rs.getInt("duracion_total"),
            rs.getBoolean("es_regular")
        );
    }
}
