package infraestructure.out.mapper;

import domain.Ciclo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CicloRowMapper {

    public Ciclo map(ResultSet rs) throws SQLException {
        return new Ciclo(
                rs.getInt("id_ciclo"),
                null,
                rs.getDate("fecha_inicio").toLocalDate(),
                rs.getDate("fecha_fin") != null ? rs.getDate("fecha_fin").toLocalDate() : null,
                rs.getInt("duracion_total"),
                rs.getBoolean("es_regular")
        );
    }
}
