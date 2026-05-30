package application.domain;

import java.util.Scanner;

public class DetalleDeSintoma extends RegistroDetalle {

    Scanner sc = new Scanner(System.in);

    //Atributes
    private int idDetalle;
    private int intensidad;
    private RegistroDiario registroDiario;
    private Sintoma sintoma;

    // Constructors

    public DetalleDeSintoma(int idDetalle, int intensidad, RegistroDiario registroDiario, Sintoma sintoma) {
        this.idDetalle = idDetalle;
        this.intensidad = intensidad;
        this.registroDiario = registroDiario;
        this.sintoma = sintoma;
    }

    // Getters ans Setters

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(int intensidad) {
        this.intensidad = intensidad;
    }

    @Override
    public RegistroDiario getRegistroDiario() {
        return registroDiario;
    }

    @Override
    public void setRegistroDiario(RegistroDiario registroDiario) {
        this.registroDiario = registroDiario;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    //Methods
    public DetalleDeSintoma createDetalleSintoma() {

        DetalleDeSintoma detalle = new DetalleDeSintoma(idDetalle, intensidad, registroDiario, sintoma);

        System.out.println("Ingrese el id del detalle");
        int id = sc.nextInt();
        detalle.setIdDetalle(id);

        System.out.println("Ingrese la intensidad del sintoma (1-10)");
        int intensidad = sc.nextInt();
        detalle.setIntensidad(intensidad);

        sc.nextLine();

        return detalle;

    }

    @Override
    public int getId() {
        return idDetalle;
    }

    @Override
    public void setId(int id) {
        this.idDetalle = id;
    }

    @Override
    public String obtenerResumen() {
        return "Detalle de Síntoma - " + (sintoma != null ? sintoma.getNombre() : "Síntoma Desconocido") + 
               " (Intensidad: " + intensidad + "/10)";
    }
}

