package org.example;

import org.example.controlador.ControladorFutbol;
import org.example.vista.VentanaFutbol;

public class Main {
    public static void main(String[] args) {
        VentanaFutbol ventanaFutbol = new VentanaFutbol("Ventana");
        ControladorFutbol controlador = new ControladorFutbol(ventanaFutbol);
    }
}
