package infraestructure.out.mapper;

import domain.ActividadSexual;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActividadSexualRowMapper {

    public ActividadSexual map(ResultSet rs) throws SQLException {
        return new ActividadSexual(
                rs.getInt("id_actividad"),
                null,
                rs.getBoolean("uso_preservativo"),
                rs.getBoolean("orgasmo"),
                rs.getString("metodo_adicional")
        );
    }
}
