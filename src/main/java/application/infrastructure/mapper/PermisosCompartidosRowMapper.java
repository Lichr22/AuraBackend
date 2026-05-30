package application.infrastructure.mapper;

import application.domain.PermisosCompartidos;
import application.domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PermisosCompartidosRowMapper {

    public PermisosCompartidos map(ResultSet rs) throws SQLException {
        Usuario propietario = new Usuario();
        propietario.setIdUsuario(rs.getInt("id_usuario_propietario"));

        Usuario invitado = new Usuario();
        invitado.setIdUsuario(rs.getInt("id_usuario_invitado"));

        return new PermisosCompartidos(
            rs.getLong("id_permiso"),
            propietario,
            invitado,
            rs.getString("nivel_acceso"),
            rs.getString("estado")
        );
    }
}
