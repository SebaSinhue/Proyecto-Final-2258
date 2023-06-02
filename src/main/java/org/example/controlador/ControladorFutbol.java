package org.example.controlador;

import org.example.modelo.Futbol;
import org.example.modelo.ModeloTablaFutbol;
import org.example.vista.VentanaFutbol;
import org.example.persistencia.FutbolDAO;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class ControladorFutbol extends MouseAdapter {
    private VentanaFutbol vista;
    private ModeloTablaFutbol modelo;

    public ControladorFutbol(VentanaFutbol vista) {

        this.vista = vista;
        modelo = new ModeloTablaFutbol();
        this.vista.getTblTablaFutbol().setModel(modelo);

        this.vista.getBtnCargar().addMouseListener(this);
        this.vista.getBtnAgregar().addMouseListener(this);
        this.vista.getBtnEliminar().addMouseListener(this);
        this.vista.getBtnActualizar().addMouseListener(this);

        this.vista.getTblTablaFutbol().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == this.vista.getBtnCargar()) {
            modelo.cargarDatos();
            this.vista.getTblTablaFutbol().setModel(modelo);
            this.vista.getTblTablaFutbol().updateUI();
        }
        if (e.getSource() == this.vista.getBtnAgregar()) {
            String liga = this.vista.getTxtLiga().getText();
            String equipo = this.vista.getTxtEquipo().getText();
            String mejorJugador = this.vista.getTxtMejorJugador().getText();
            String edadJugador = this.vista.getTxtEdadJugador().getText();
            String nacionalidadJugador = this.vista.getTxtNacionalidadJugador().getText();
            String url = this.vista.getTxtURL().getText();

            if (liga.isEmpty() || equipo.isEmpty() || mejorJugador.isEmpty() || edadJugador.isEmpty() || nacionalidadJugador.isEmpty() || url.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "No puedes dejar vacio los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Futbol futbol = new Futbol();
            futbol.setId(0);
            futbol.setLiga(this.vista.getTxtLiga().getText());
            futbol.setEquipo(this.vista.getTxtEquipo().getText());
            futbol.setMejorJugador(this.vista.getTxtMejorJugador().getText());
            futbol.setEdadJugador(this.vista.getTxtEdadJugador().getText());
            futbol.setNacionalidadJugador(this.vista.getTxtNacionalidadJugador().getText());
            futbol.setURL(this.vista.getTxtURL().getText());

            if (modelo.agregarFutbol(futbol)) {
                JOptionPane.showMessageDialog(vista, "Se agregó correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.vista.getTblTablaFutbol().updateUI();
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo agregar a la Base de Datos. Por favor, revisa la conexión", "Error al insertar", JOptionPane.ERROR_MESSAGE);
            }

            modelo.cargarDatos();
            this.vista.getTblTablaFutbol().setModel(modelo);
            this.vista.getTblTablaFutbol().updateUI();
        }

            if (e.getSource() == this.vista.getTblTablaFutbol()){


                int index = this.vista.getTblTablaFutbol().getSelectedRow();
                Futbol tmp = modelo.getFutbolAtIndex(index);

                try {
                    this.vista.getFoto().setIcon(tmp.getImagen());
                    this.vista.getFoto().setText("");
                }catch (MalformedURLException murle){
                    JOptionPane.showMessageDialog(vista, "La URL es incorrecta ingresa una nueva", "Aviso", JOptionPane.ERROR_MESSAGE );
                    System.out.println(e.toString());
                }
            }
        if (e.getSource() == this.vista.getBtnEliminar()){

            int row = this.vista.getTblTablaFutbol().getSelectedRow();
            String index = String.valueOf(this.modelo.getValueAt(row, 0));
            int respuesta = JOptionPane.showConfirmDialog(vista, "Estas seguro de borrar el registro?", "Alerta", JOptionPane.INFORMATION_MESSAGE);


            if (respuesta == JOptionPane.YES_NO_OPTION){
                modelo.eliminarDatos(index);
                JOptionPane.showMessageDialog(vista, "Se elimino correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(vista, "No se pudo eliminar", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }

            modelo.cargarDatos();
            this.vista.getTblTablaFutbol().setModel(modelo);
            this.vista.getTblTablaFutbol().updateUI();

        }


        if (e.getSource() == this.vista.getBtnActualizar()) {
            
            String liga = this.vista.getTxtLiga().getText();
            String equipo = this.vista.getTxtEquipo().getText();
            String mejorJugador = this.vista.getTxtMejorJugador().getText();
            String edadJugador = this.vista.getTxtEdadJugador().getText();
            String nacionalidadJugador = this.vista.getTxtNacionalidadJugador().getText();
            String url = this.vista.getTxtURL().getText();

            if (liga.isEmpty() || equipo.isEmpty() || mejorJugador.isEmpty() || edadJugador.isEmpty() || nacionalidadJugador.isEmpty() || url.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int row = this.vista.getTblTablaFutbol().getSelectedRow();
            String index = String.valueOf(this.modelo.getValueAt(row,0));

            Futbol futbol = new Futbol();

            futbol.setId(Integer.parseInt(index));
            futbol.setLiga(this.vista.getTxtLiga().getText());
            futbol.setEquipo(this.vista.getTxtEquipo().getText());
            futbol.setMejorJugador(this.vista.getTxtMejorJugador().getText());
            futbol.setEdadJugador(this.vista.getTxtEdadJugador().getText());
            futbol.setNacionalidadJugador(this.vista.getTxtNacionalidadJugador().getText());
            futbol.setURL(this.vista.getTxtURL().getText());

            if (modelo.actualizarDatos(futbol)){
                JOptionPane.showMessageDialog(vista, "Se modifico correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(vista, "No se pudo modificar", "Alerta", JOptionPane.ERROR_MESSAGE);
                this.vista.getTblTablaFutbol().updateUI();
            }

            modelo.cargarDatos();
            this.vista.getTblTablaFutbol().setModel(modelo);
            this.vista.getTblTablaFutbol().updateUI();

        }

        this.vista.getTblTablaFutbol().updateUI();


            this.vista.limpiar();
        }

    }


