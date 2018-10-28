/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author FranciscoAntonio
 */


public class Conexion {
    
        Connection conexion = null;
        Statement sentencia = null;
        PreparedStatement preparada = null;
        ResultSet resultado = null;
    
    public static void conectar(){
    DataSource datasource;
        try {
            Context contextoInicial = new InitialContext();
            datasource = (DataSource) contextoInicial.lookup("java:comp/env/jdbc/controlAves");
        } catch (NamingException ex) {
            System.out.println("Problemas en el acceso a la BD");
            ex.printStackTrace();
        }
    }
    
    public static void desconectar(Connection conexion)throws ConnectionException {
        try {
            conexion.close();
        }catch (SQLException  e) {
            throw new ConnectionException("Ha ocurrido un error al intentar cerrar la conexion con la BBDD. Error:" + e.getMessage());


        }

    }
}