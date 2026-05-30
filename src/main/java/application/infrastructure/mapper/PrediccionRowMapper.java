package application.infrastructure.mapper;

import application.domain.Prediccion;
import application.domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrediccionRowMapper {

    public Prediccion map(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("id_usuario"));

        return new Prediccion(
            rs.getInt("id_prediccion"),
            usuario,
            rs.getDate("fecha_calculo").toLocalDate(),
            rs.getDate("proxima_menstruacion_estimada").toLocalDate(),
            rs.getDate("inicio_ventana_fertil").toLocalDate(),
            rs.getDate("fin_ventana_fertil").toLocalDate(),
            rs.getString("probabilidad_embarazo")
        );
    }
}
