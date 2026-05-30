import infraestructure.config.Config;
import userinterface.MenuApp;

public class Main {

    public static void main(String[] args) {
        MenuApp menuApp = Config.createMenuApp();
        menuApp.iniciar();
    }
}