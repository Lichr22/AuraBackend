package application;

import application.config.Config;
import application.userinterface.MenuApp;

public class Main {

    public static void main(String[] args) {
        MenuApp menuApp = Config.createMenuApp();
        menuApp.iniciar();
    }
}