package application.domain;

import java.util.Scanner;

public class Sintoma {

    Scanner sc = new Scanner(System.in);

    //Sintoma Atributes

    private int idSintoma;
    private String nombre;
    private String categoria;

    //Constructores


    public Sintoma(Scanner sc, int idSintoma, String nombre, String categoria) {
        this.sc = sc;
        this.idSintoma = idSintoma;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    //Getters and Setters
    public long getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(int idSintoma) {
        this.idSintoma = idSintoma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Class Methods
    public Sintoma createSintoma(Sintoma sintoma){

        System.out.println("Ingrese el id del sintoma");
        int id = sc.nextInt();
        sintoma.idSintoma = id;
        sc.nextLine();

        System.out.println("Ingrese el nombre del sintoma");
        String nombre = sc.nextLine();
        sintoma.nombre = nombre;

        System.out.println("Ingrese la categoria del sintoma");
        String categoria = sc.nextLine();
        sintoma.categoria = categoria;

        return sintoma;
    }

    public void getSintomaById(Long id, Sintoma sintoma){

        if(this.idSintoma == id){

            System.out.println("Id Sintoma: " + sintoma.idSintoma + "\n" +
                    "Nombre: " + sintoma.nombre + "\n" +
                    "Categoria: " + sintoma.categoria);

        } else {

            System.out.println("El id del sintoma no coincide");
        }

    }

}
