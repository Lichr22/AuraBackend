package application.infrastructure.mapper;

import application.domain.Ciclo;
import application.domain.RegistroDiario;
import application.domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroDiarioRowMapper {

    public RegistroDiario map(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("id_usuario"));

        Ciclo ciclo = new Ciclo(rs.getInt("id_ciclo"));

        return new RegistroDiario(
            rs.getInt("id_registro"),
            usuario,
            ciclo,
            rs.getDate("fecha").toLocalDate(),
            rs.getDouble("temperatura_basal"),
            rs.getDouble("peso"),
            rs.getString("calidad_sueno"),
            rs.getString("notas_libres")
        );
    }
}
