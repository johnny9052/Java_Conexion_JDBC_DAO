/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClsUsuario;
import DAO.UsuarioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Johnny
 */
public class CtlUsuario {

    
    UsuarioDAO usuDAO = new UsuarioDAO();
       
    public boolean SolicitudGuardar(String cedula, String nombre, String apellido, int edad) {
        ClsUsuario usuario = new ClsUsuario(cedula, nombre, apellido, edad);        
        return usuDAO.guardarUsuario(usuario);
    }
      
    

    public List<String> SolicitudBuscar(String cedula) {        
        return usuDAO.buscarUsuario(cedula);
    }

    public boolean SolicitudModificar(String cedula, String nombre, String apellido, int edad) {
        ClsUsuario usuario = new ClsUsuario(cedula, nombre, apellido, edad);        
        return usuDAO.modificarUsuario(usuario);
    }

    public boolean solicitudEliminar(String cedula) {        
        return usuDAO.eliminarUsuario(cedula);
    }

    public DefaultTableModel SolicitudListar() {        
        return usuDAO.listarUsuario();        
    }
}
