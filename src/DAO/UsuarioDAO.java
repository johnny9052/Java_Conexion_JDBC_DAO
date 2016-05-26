/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsUsuario;
import Infraestructura.ClsConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Johnny
 */
public class UsuarioDAO {

    ClsConexion conexion;

    public UsuarioDAO() {
        conexion = new ClsConexion();
    }

    public boolean guardarUsuario(ClsUsuario usuDAO) {
        String consulta = "insert into usuario"
                + "(cedula,nombre,apellido,edad) values('" + usuDAO.getCedula() + "','" + usuDAO.getNombre() + "','" + usuDAO.getApellido() + "'," + usuDAO.getEdad() + ")";
        return conexion.ejecutar(consulta);
    }

    public List<String> buscarUsuario(String cedula) {

        List<String> temp = new ArrayList<>();

        String consulta = "select cedula,nombre,apellido,edad from usuario where cedula='" + cedula + "'";

        conexion.ejecutarRetorno(consulta);

        try {
            if (conexion.getResultadoDB().next()) {
                temp.add(conexion.getResultadoDB().getString("cedula"));
                temp.add(conexion.getResultadoDB().getString("nombre"));
                temp.add(conexion.getResultadoDB().getString("apellido"));
                temp.add(conexion.getResultadoDB().getInt("edad") + "");
            }
        } catch (SQLException ex) {
            System.out.println("Esto se tosto");
        } catch (Exception ex) {
            
        }
        return temp;
    }

    public boolean modificarUsuario(ClsUsuario usuDAO) {
        String consulta = "update usuario set nombre='" + usuDAO.getNombre() + "',apellido='" + usuDAO.getApellido() + "'," + "edad=" + usuDAO.getEdad() + " where cedula='" + usuDAO.getCedula() + "'";
        return conexion.ejecutar(consulta);
    }

    public boolean eliminarUsuario(String cedula) {
        String consulta = "delete from usuario where cedula='" + cedula + "'";
        return conexion.ejecutar(consulta);
    }

    public DefaultTableModel listarUsuario() {

        DefaultTableModel temp;
        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido", "Edad"};
        temp = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        String consulta = "select cedula,nombre,apellido,edad from usuario";
        conexion.ejecutarRetorno(consulta);

        try {
            while (conexion.getResultadoDB().next()) {
                temp.addRow(new Object[]{
                    conexion.getResultadoDB().getString("cedula"),
                    conexion.getResultadoDB().getString("nombre"),
                    conexion.getResultadoDB().getString("apellido"),
                    conexion.getResultadoDB().getInt("edad")});
            }
        } catch (SQLException ex) {

        }
        return temp;
    }
}
