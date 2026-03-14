package application;

import application.domain.*;

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

        PermisosCompartidos permisosCompartidos = new PermisosCompartidos();
        permisosCompartidos.createPermiso(permisosCompartidos);
        permisosCompartidos.getPermisoById(1, permisosCompartidos);
        RecomendacionIA recomendacionIA = new RecomendacionIA();
        recomendacionIA.createRecomendacion(recomendacionIA);
        recomendacionIA.getRecomendacionById(1, recomendacionIA);

        RecomendacionIA recomendacionIA1 = new RecomendacionIA();
        recomendacionIA1.getRecomendacionById(1, recomendacionIA);
        recomendacionIA1.deleteRecomendacion(1);
        recomendacionIA1.getAllRecomendaciones();
        recomendacionIA1.updateRecomendacion(recomendacionIA);
        recomendacionIA1.createRecomendacion(recomendacionIA);

        VinculoPareja vinculoPareja = new VinculoPareja();
        vinculoPareja.createVinculo(vinculoPareja);
        vinculoPareja.getVinculoById(1, vinculoPareja);
        vinculoPareja.deleteVinculo(1);
        vinculoPareja.getAllVinculos();
        vinculoPareja.updateVinculo(vinculoPareja);


    }
}