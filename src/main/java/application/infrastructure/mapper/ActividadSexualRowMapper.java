package application.infrastructure.mapper;

import application.domain.ActividadSexual;
import application.domain.RegistroDiario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActividadSexualRowMapper {

    public ActividadSexual map(ResultSet rs) throws SQLException {
        RegistroDiario registroDiario = new RegistroDiario(rs.getInt("id_registro"));

        return new ActividadSexual(
            rs.getInt("id_actividad"),
            registroDiario,
            rs.getBoolean("uso_preservativo"),
            rs.getBoolean("orgasmo"),
            rs.getString("metodo_adicional")
        );
    }
}
