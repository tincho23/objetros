package servidorautenticacion;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conectar {
    Connection con=null;
    public Connection conexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");           
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/autentificaciones","root","");
            System.out.println("Conexion Establecida");
            JOptionPane.showMessageDialog(null, "Conexion Establecida");
            
            
        } catch (ClassNotFoundException | SQLException | HeadlessException e){
            System.out.println("Error de conexion");
            JOptionPane.showMessageDialog(null, "Error de conexion");
            
            
        }
        return con;
    
    }
}
