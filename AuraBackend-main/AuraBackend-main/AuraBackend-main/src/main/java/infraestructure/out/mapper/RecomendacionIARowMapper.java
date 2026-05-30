package infraestructure.out.mapper;

import domain.RecomendacionIA;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecomendacionIARowMapper {

    public RecomendacionIA map(ResultSet rs) throws SQLException {
        return new RecomendacionIA(
                rs.getLong("id_recomendacion"),
                null,
                rs.getString("titulo"),
                rs.getString("contenido"),
                rs.getTimestamp("fecha_creacion").toLocalDateTime()
        );
    }
}
