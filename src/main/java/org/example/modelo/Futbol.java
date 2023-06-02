package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Futbol {
    private int id;
    private String liga;
    private String equipo;
    private String mejorJugador;
    private String edadJugador;
    private String nacionalidadJugador;
    private String URL;

    public Futbol() {
    }

    public Futbol(int id, String liga, String equipo, String mejorJugador, String edadJugador, String nacionalidadJugador, String URL) {
        this.id = id;
        this.liga = liga;
        this.equipo = equipo;
        this.mejorJugador = mejorJugador;
        this.edadJugador = edadJugador;
        this.nacionalidadJugador = nacionalidadJugador;
        this.URL = URL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getMejorJugador() {
        return mejorJugador;
    }

    public void setMejorJugador(String mejorJugador) {
        this.mejorJugador = mejorJugador;
    }

    public String getEdadJugador() {
        return edadJugador;
    }

    public void setEdadJugador(String edadJugador) {
        this.edadJugador = edadJugador;
    }

    public String getNacionalidadJugador() {
        return nacionalidadJugador;
    }

    public void setNacionalidadJugador(String nacionalidadJugador) {
        this.nacionalidadJugador = nacionalidadJugador;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Futbol{" +
                "id=" + id +
                ", liga='" + liga + '\'' +
                ", equipo='" + equipo + '\'' +
                ", mejorJugador='" + mejorJugador + '\'' +
                ", edadJugador='" + edadJugador + '\'' +
                ", nacionalidadJugador='" + nacionalidadJugador + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {

        java.net.URL urlImagen = new URL(this.URL);
        return new ImageIcon(urlImagen);
    }

}
