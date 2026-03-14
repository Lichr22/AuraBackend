package application.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VinculoPareja {

    Scanner sc = new Scanner(System.in);

    Long idVinculoPareja;
    Usuario mujer;
    Usuario pareja;
    String estadoVinculo;
    LocalDate fechaVinculacion;

    public VinculoPareja(Long idVinculoPareja, Usuario mujer, Usuario pareja, String estadoVinculo, LocalDate fechaVinculacion) {
        this.idVinculoPareja = idVinculoPareja;
        this.mujer = mujer;
        this.pareja = pareja;
        this.estadoVinculo = estadoVinculo;
        this.fechaVinculacion = fechaVinculacion;
    }

    public VinculoPareja() {
    }

    public Long getIdVinculoPareja() {
        return idVinculoPareja;
    }

    public void setIdVinculoPareja(Long idVinculoPareja) {
        this.idVinculoPareja = idVinculoPareja;
    }

    public Usuario getMujer() {
        return mujer;
    }

    public void setMujer(Usuario mujer) {
        this.mujer = mujer;
    }

    public Usuario getPareja() {
        return pareja;
    }

    public void setPareja(Usuario pareja) {
        this.pareja = pareja;
    }

    public String getEstadoVinculo() {
        return estadoVinculo;
    }

    public void setEstadoVinculo(String estadoVinculo) {
        this.estadoVinculo = estadoVinculo;
    }

    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(LocalDate fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public VinculoPareja createVinculo(VinculoPareja vinculo) {
        System.out.println("Ingrese el estado del vinculo");
        vinculo.estadoVinculo = sc.nextLine();

        vinculo.fechaVinculacion = LocalDate.now();

        return vinculo;
    }

    public VinculoPareja updateVinculo(VinculoPareja vinculo) {
        System.out.println("Actualizar estado del vinculo");
        vinculo.estadoVinculo = sc.nextLine();

        return vinculo;
    }

    public List<VinculoPareja> getAllVinculos() {
        return null;
    }

    public void getVinculoById(int idVinculoPareja, VinculoPareja vinculo) {
        if (this.idVinculoPareja.equals(idVinculoPareja)) {
            System.out.println("Id Vinculo: " + vinculo.idVinculoPareja +
                    "\nMujer: " + vinculo.mujer.getNombre() +
                    "\nPareja: " + vinculo.pareja.getNombre() +
                    "\nEstado Vinculo: " + vinculo.estadoVinculo +
                    "\nFecha Vinculacion: " + vinculo.fechaVinculacion + "\n");
        }
    }

    public void deleteVinculo(int idVinculoPareja) {}
}
