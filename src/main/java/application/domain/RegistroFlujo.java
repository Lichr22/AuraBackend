package application.domain;

import java.util.Scanner;

public class RegistroFlujo {

    Scanner sc = new Scanner(System.in);

    private int idFlujo;
    private RegistroDiario registro;
    private String tipoTextura;
    private String color;
    private String cantidad;

//CONSTRUCTORES
//Vacio
public RegistroFlujo() {
        }

//Con los atributos
public RegistroFlujo(int idFlujo, RegistroDiario registro, String tipoTextura, String color, String cantidad) {
    this.idFlujo = idFlujo;
    this.registro = registro;
    this.tipoTextura = tipoTextura;
    this.color = color;
    this.cantidad = cantidad;
}

//Solo ID
public RegistroFlujo(int idFlujo) {
    this.idFlujo = idFlujo;
}

// GETTERS Y SETTERS

    public int getIdFlujo() { return idFlujo; }

    public void setIdFlujo(int idFlujo) { this.idFlujo = idFlujo; }

    public RegistroDiario getRegistro() { return registro; }

    public void setRegistro(RegistroDiario registro) { this.registro = registro; }

    public String getTipoTextura() { return tipoTextura; }

    public void setTipoTextura(String tipoTextura) { this.tipoTextura = tipoTextura; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public String getCantidad() {  return cantidad; }

    public void setCantidad(String cantidad) { this.cantidad = cantidad; }

// METODOS

public RegistroFlujo createRegistroFlujo(RegistroFlujo flujo){

   System.out.println("Ingrese el id del flujo");
   int idFlujo = sc.nextInt();
   flujo.idFlujo = idFlujo;
   sc.nextLine();

   System.out.println("Ingrese el tipo de textura del flujo");
   String tipoTextura = sc.nextLine();
   flujo.tipoTextura = tipoTextura;

   System.out.println("Ingrese el color del flujo");
   String color = sc.nextLine();
   flujo.color = color;

   System.out.println("Ingrese la cantidad del flujo");
   String cantidad = sc.nextLine();
   flujo.cantidad = cantidad;

   return flujo;
}

//Get

public void getRegistroFlujo(int id){

   if(this.idFlujo == id){

   System.out.println("Id Flujo: " + this.idFlujo + "\n" +
   "Tipo de textura: " + this.tipoTextura + "\n" +
   "Color: " + this.color + "\n" +
   "Cantidad: " + this.cantidad + "\n");

   } else {

   System.out.println("Valide el id del flujo que está consultando");

   }

 }

}


