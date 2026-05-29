package application.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class UsuarioRespository {

    Scanner sc = new Scanner(System.in);

    private int idUsuario;
    private String nombre;
    private String email;
    private String contrasenaHash;
    private String rol;
    private String codigoVinculacion;
    private LocalDateTime fechaRegistro;
    private String estadoCuenta;

    public UsuarioRespository() {
    }



    public UsuarioRespository(int idUsuario, String nombre, String email, String contrasenaHash, String rol,
                              String codigoVinculacion, LocalDateTime fechaRegistro, String estadoCuenta) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.contrasenaHash = contrasenaHash;
        this.rol = rol;
        this.codigoVinculacion = codigoVinculacion;
        this.fechaRegistro = fechaRegistro;
        this.estadoCuenta = estadoCuenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCodigoVinculacion() {
        return codigoVinculacion;
    }

    public void setCodigoVinculacion(String codigoVinculacion) {
        this.codigoVinculacion = codigoVinculacion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }


    public UsuarioRespository createUser(UsuarioRespository usuario){

        System.out.println("Ingrese el nombre del usuario");
        String nombre = sc.nextLine();
        usuario.nombre = nombre;

        System.out.println("Ingrese el email");
        String email = sc.nextLine();
        usuario.email = email;

        System.out.println("Ingrese la contraseña (hash)");
        String contrasenaHash = sc.nextLine();
        usuario.contrasenaHash = contrasenaHash;

        System.out.println("Ingrese el rol del usuario");
        String rol = sc.nextLine();
        usuario.rol = rol;

        System.out.println("Ingrese el codigo de vinculacion");
        String codigo = sc.nextLine();
        usuario.codigoVinculacion = codigo;

        System.out.println("Ingrese el estado de la cuenta");
        String estado = sc.nextLine();
        usuario.estadoCuenta = estado;

        usuario.fechaRegistro = LocalDateTime.now();

        return usuario;
    }

    public UsuarioRespository updateUser(UsuarioRespository usuario){

        System.out.println("Actualizar nombre");
        usuario.nombre = sc.nextLine();

        System.out.println("Actualizar email");
        usuario.email = sc.nextLine();

        System.out.println("Actualizar rol");
        usuario.rol = sc.nextLine();

        System.out.println("Actualizar estado de cuenta");
        usuario.estadoCuenta = sc.nextLine();

        return usuario;
    }

    public List<UsuarioRespository> getAllUsers(){
        return null;
    }

    public void getUserById(int idUsuario, UsuarioRespository usuario){

        if (this.idUsuario == idUsuario){
            System.out.println("Id Usuario: " + usuario.idUsuario +
                    "\n" + "Nombre: " + usuario.nombre +
                    "\n" + "Email: " + usuario.email +
                    "\n" + "Rol: " + usuario.rol +
                    "\n" + "Codigo Vinculacion: " + usuario.codigoVinculacion +
                    "\n" + "Fecha Registro: " + usuario.fechaRegistro +
                    "\n" + "Estado Cuenta: " + usuario.estadoCuenta + "\n");
        }

    }

    public void deleteUser(int idUsuario){

    }

}