package org.example.persistencia;

import com.sun.source.tree.BreakTree;
import org.example.modelo.Futbol;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FutbolDAO implements InterfazDAO{

    public FutbolDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO futbol2(liga, equipo, mejorJugador, edadJugador, nacionalidadJugador, url) VALUES (?, ?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("futbol2.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Futbol)obj).getLiga());
        pstm.setString(2, ((Futbol)obj).getEquipo());
        pstm.setString(3, ((Futbol)obj).getMejorJugador());
        pstm.setString(4, ((Futbol)obj).getEdadJugador());
        pstm.setString(5, ((Futbol)obj).getNacionalidadJugador());
        pstm.setString(6, ((Futbol)obj).getURL());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE futbol2 SET liga = ?, equipo = ?, mejorJugador = ?, edadJugador = ?, nacionalidadJugador = ?, url = ? WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("futbol2.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Futbol)obj).getLiga());
        pstm.setString(2, ((Futbol)obj).getEquipo());
        pstm.setString(3, ((Futbol)obj).getMejorJugador());
        pstm.setString(4, ((Futbol)obj).getEdadJugador());
        pstm.setString(5, ((Futbol)obj).getNacionalidadJugador());
        pstm.setString(6, ((Futbol)obj).getURL());
        pstm.setInt(7, ((Futbol)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM futbol2 WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("futbol2.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM futbol2";
        ArrayList<Futbol> resultado = new ArrayList<>();

            Statement stm = ConexionSingleton.getInstance("futbol2.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
                resultado.add(new Futbol(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5), rst.getString(6), rst.getString(7)));
            }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM futbol2 WHERE id = ? ; ";
        Futbol futbol = null;
            PreparedStatement pstm = ConexionSingleton.getInstance("futbol2.db").getConnection().prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            ResultSet rst = pstm.executeQuery();
            if (rst.next()){
                futbol =  new Futbol(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5), rst.getString(6), rst.getString(7));
                return futbol;
            }
        return null;
    }

}
