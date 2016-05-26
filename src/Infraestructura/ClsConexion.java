/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestructura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Johnny
 */
public class ClsConexion {

    private final String driver = "org.postgresql.Driver"; //nombre del driver
    private final String connectString = 
            "jdbc:postgresql://localhost:5432/ingeSoftwareMVC"; //ubicacion de la base de datos, para postgres esta es por defecto
    private final String user = "postgres"; //usuario de la base de datos
    private final String password = "admin"; //password de la base de datos
    private Connection conexionDB; // variable que permite la conexion
    private Statement sentenciaSQL; //permite la ejecucion de sentencias SQL
    private ResultSet resultadoDB;//almacena el resultado de una consulta

    

    
    
    public ResultSet getResultadoDB() {
        return resultadoDB;
    }

    public void setResultadoDB(ResultSet resultadoDB) {
        this.resultadoDB = resultadoDB;
    }

    /**
     * Permite la conexion de la base de datos
     *
     * @author Johnny Alexander Salazar
     * @version 15 febrero 2012
     */
    public void conectar() {
        try {
            Class.forName(driver); //se carga el driver en memoria
            conexionDB = DriverManager.getConnection(connectString,
                    user, password);//conexion a la base de datos
            sentenciaSQL = conexionDB.createStatement();//variable que permite ejecutar las sentencias SQL                                
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Desconecta la conexion de la base de datos
     *
     * @author Johnny Alexander Salazar
     * @version 15 febrero 2012
     */
    public void desconectar() {
        try {
            //sentenciaSQL.close();//cierra la consulta
            conexionDB.close();//cierra conexion
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean ejecutar(String sentencia) {
        try {
            conectar();
            sentenciaSQL.executeUpdate(sentencia);
            desconectar();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void ejecutarRetorno(String sentencia) {
        try {
            conectar();
            resultadoDB = sentenciaSQL.executeQuery(sentencia);
            desconectar();
        } catch (Exception e) {

        }
    }

}
