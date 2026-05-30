package infraestructure.out.mapper;

import domain.Prediccion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrediccionRowMapper {

    public Prediccion map(ResultSet rs) throws SQLException {
        return new Prediccion(
                rs.getInt("id_prediccion"),
                null,
                rs.getDate("fecha_calculo").toLocalDate(),
                rs.getDate("proxima_menstruacion_estimada").toLocalDate(),
                rs.getDate("inicio_ventana_fertil").toLocalDate(),
                rs.getDate("fin_ventana_fertil").toLocalDate(),
                rs.getString("probabilidad_embarazo")
        );
    }
}
