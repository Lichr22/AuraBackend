package application;

import application.domain.Usuario;
import application.domain.PerfilMenstrual;
import application.domain.Ciclo;
import application.domain.RegistroDiario;

public class Main {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();

        /*
        usuario.setIdUsuario(1L);
        usuario.setNombre("Juliana");
        usuario.setContrasenaHash("123456");
        usuario.setRol("USER");
        usuario.setCodigoVinculacion("ABC123");
        usuario.setEstadoCuenta("ACTIVA");

        System.out.println(usuario.getIdUsuario());
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getEmail());
        */

        PerfilMenstrual perfilMenstrual = new PerfilMenstrual();
        perfilMenstrual.setUsuario(usuario);
        perfilMenstrual.createPerfil(perfilMenstrual);
        perfilMenstrual.getPerfilById(1, perfilMenstrual);


        Ciclo ciclo = new Ciclo();
        ciclo.setUsuario(usuario);
        ciclo.createCiclo(ciclo);
        ciclo.getCicloById(1, ciclo);


        RegistroDiario registroDiario = new RegistroDiario();
        registroDiario.setUsuario(usuario);
        registroDiario.setCiclo(ciclo);
        registroDiario.createRegistro(registroDiario);
        registroDiario.getRegistroById(1, registroDiario);

    }
}