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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Tincho
 */
public class Mapper {
    Statement consulta;
        Statement consulta2;
        ResultSet tabla;
         
        //DefaultTableModel model;
              
        //COSULTAR CONEXION
        Conectar cc= new Conectar();
        Connection cn = cc.conexion();

    
    public Boolean add(String usernameADD, String passwordADD){     
        
        try{
            consulta= cn.createStatement();
            consulta.executeUpdate("INSERT INTO usuarios (username, password, timestamp) VALUES('"+usernameADD+"','"+passwordADD+"',"+"NOW())");
            System.out.println("Usuario ingresado correctamente");
            JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente");
            return true;
        }catch 
            (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al insertar");
            return false;
        }
    }
    
    //BORRAR
    
    public boolean remove(String usernameREMOVE){
                        
        try{
        consulta= cn.createStatement();
        tabla=consulta.executeQuery("SELECT username FROM usuarios WHERE username='"+usernameREMOVE+"'");
        
        if(tabla.next()){
            int consulta2 = consulta.executeUpdate("DELETE FROM usuarios WHERE username='"+usernameREMOVE+"'");
                 if (consulta2!=0){
                     System.out.println("Usuario borrado correctamente");
                     JOptionPane.showMessageDialog(null,"Usuario borrado correctamente");
                 return true;
                 }
                 else{
                     System.out.println("No se pudo borrar");
                     JOptionPane.showMessageDialog(null,"No se pudo borrar");
                 return false;
                 }      
        }
        else{
                JOptionPane.showMessageDialog(null, "El usuario no existe");
                return false;
        }            
        } catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al borrar"); 
            return false;
        }  
       
    }
    
    //MODIFICAR
     
    public boolean modify(String usernameMOD, String passwordMOD, String newpasswordMOD){
        
        try{
        consulta= cn.createStatement();
        tabla=consulta.executeQuery("SELECT username FROM usuarios WHERE username='"+usernameMOD+"'");
        
        if(tabla.next()){
            int consulta2 = consulta.executeUpdate("UPDATE  usuarios SET password='"+newpasswordMOD+"'WHERE username='"+usernameMOD+"' and password='"+passwordMOD+"'");
                 if (consulta2!=0){
                     System.out.println("Usuario modificado correctamente");
                     JOptionPane.showMessageDialog(null,"Usuario modificado correctamente");
                 return true;
                 }
                 else{
                     System.out.println("Contraseña invalida");
                     JOptionPane.showMessageDialog(null,"Contraseña invalida");
                 return false;
                 }      
        }
        else{
                JOptionPane.showMessageDialog(null, "El usuario no existe");
        }            
        } catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al modificar"); 
            return false;
        }
        return false;
    }
    
    //LISTAR
      
    public ResultSet listUsers(){     
         
        try{
            consulta= cn.createStatement();
            tabla = consulta.executeQuery("SELECT * FROM usuarios");
            
            System.out.println("Lista de usuarios: ");
//            DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            while(tabla.next()){
//            System.out.println( tabla.getString("username"));
//            System.out.println( tabla.getString("password"));
//            System.out.println( format.format(tabla.getTimestamp("timestamp")));
            return tabla;
//        }
       
        }catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al listar"); 
           
        }
    return null;
    }
   
  public boolean autenticar(String usernameAUT, String passwordAUT, String hostAUT){
        
        try{
        consulta= cn.createStatement();
        tabla=consulta.executeQuery("SELECT username FROM usuarios WHERE username='"+usernameAUT+"' AND password='"+passwordAUT+"'");
        
        if(tabla.next()){
            int consulta2 = consulta.executeUpdate("INSERT INTO autenticaciones (username, host, timestamp) VALUES('"+usernameAUT+"','"+hostAUT+"',"+"NOW())");
                 if (consulta2!=0){
                     System.out.println("Autenticacion exitosa");
                     JOptionPane.showMessageDialog(null,"Autenticacion exitosa");
                     return true;
                 }
                 else{
                     System.out.println("Usuario o contraseña invalida");
                     JOptionPane.showMessageDialog(null,"Usuario o contraseña invalida");
                     return false;
                 }      
        }
        else{
                JOptionPane.showMessageDialog(null, "El usuario no existe");
                return false;
        }            
        } catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al autenticar"); 
            return false;
        }
    }  
    
}
