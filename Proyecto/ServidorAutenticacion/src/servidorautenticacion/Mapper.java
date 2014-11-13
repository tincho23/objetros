/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorautenticacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Tincho
 */
public class Mapper {
    Mapper(){
    Connection conexion;
        Statement consulta;
        ResultSet tabla;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
           
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/autentificaciones","root","");
            
            consulta=conexion.createStatement();
            tabla=consulta.executeQuery("INSERT INTO `usuarios`(`username`, `password`) VALUES ('prueba','prueba')");
            conexion.close();
            
        }catch(ClassNotFoundException |SQLException e){}
        
    }
    
    
    
}
