package org.example.modelo;

import org.example.persistencia.FutbolDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaFutbol implements TableModel {
    public static final int COLS = 7;
    private ArrayList<Futbol> datos = new ArrayList<>();
    private FutbolDAO fdao;

    public ModeloTablaFutbol() {
        fdao = new FutbolDAO();
    }

    public ModeloTablaFutbol(ArrayList<Futbol> datos) {
        this.datos = datos;
        fdao = new FutbolDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex){
            case 0:
                return "Id";
            case 1:
                return "Liga";
            case 2:
                return "Equipo";
            case 3:
                return "Mejor Jugador";
            case 4:
                return "Edad";
            case 5:
                return "Nacionalidad";
            case 6:
                return "Foto";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Futbol tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getLiga();
            case 2:
                return tmp.getEquipo();
            case 3:
                return tmp.getMejorJugador();
            case 4:
                return tmp.getEdadJugador();
            case 5:
                return tmp.getNacionalidadJugador();
            case 6:
                return tmp.getURL();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).setId();
                break;
            case 1:
                datos.get(rowIndex).setLiga( (String) aValue );
                break;
            case 2:
                datos.get(rowIndex).setEquipo( (String) aValue );
                break;
            case 3:
                datos.get(rowIndex).setMejorJugador( (String) aValue );
                break;
            case 4:
                datos.get(rowIndex).setEdadJugador( (String) aValue );
                break;
            case 5:
                datos.get(rowIndex).setNacionalidadJugador( (String) aValue );
                break;
            case 6:
                datos.get(rowIndex).setURL( (String) aValue );
                break;
            default:
                System.out.println("No se modifica nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos(){
        try {
            datos = fdao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

    }
    public boolean agregarFutbol(Futbol futbol) {
        boolean resultado = false;
        try {
            if (fdao.insertar(futbol)) {
                datos.add(futbol);
                resultado = true;
            }else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        }
        return resultado;
    }

    public Futbol getFutbolAtIndex(int idx){
        return datos.get(idx);
    }
    public boolean eliminarDatos(String index){
        boolean resultado = true;

        try {
            if (fdao.delete(index)){
                System.out.println("Se elimino correctamente");
                resultado = true;
            }else {
                System.out.println("No se pudo eliminar");
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public boolean actualizarDatos(Futbol futbol){
        boolean resultado = false;

        try {
            if (fdao.update(futbol)){
                System.out.println("Se modifico correctamente");
                resultado = true;
            }else {
                System.out.println("No se pudo modificar");
                resultado = false;
            }
        }catch (SQLException slqe){
            System.out.println(slqe.getMessage());
        }
        return resultado;
    }

}
