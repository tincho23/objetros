/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package autentificacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ARMAU {
        
    
        Statement consulta;
        Statement consulta2;
        ResultSet tabla;
        
        //DefaultTableModel model;
              
        //COSULTAR CONEXION
        conectar cc= new conectar();
        Connection cn = cc.conexion();
    
    //INSERTAR
        
        
    public void add(String usernameADD, String passwordADD){     
        
        try{
        consulta= cn.createStatement();
        consulta.executeUpdate("INSERT INTO usuarios (username, password, timestamp) VALUES('"+usernameADD+"','"+passwordADD+"',"+"NOW())");
        System.out.println("Usuario ingresado correctamente");
        JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente");
        }
        catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al insertar");          
        }
    }
    
    //BORRAR
    
    public void remove(String usernameREMOVE){
        try{
        consulta= cn.createStatement();
        consulta.executeUpdate("DELETE FROM usuarios WHERE username='"+usernameREMOVE+"'");
        System.out.println("Usuario borrado correctamente");
        JOptionPane.showMessageDialog(null, "Usuario borrado correctamente");
        }
        catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al borrar");          
        }
    }
    
    //MODIFICAR
     
    public void modify(String usernameMOD, String passwordMOD, String newpasswordMOD){
        
        try{
        consulta= cn.createStatement();
        tabla=consulta.executeQuery("SELECT username FROM usuarios WHERE username='"+usernameMOD+"'");
        
        if(tabla.next()){
            int consulta2 = consulta.executeUpdate("UPDATE  usuarios SET password='"+newpasswordMOD+"'WHERE username='"+usernameMOD+"' and password='"+passwordMOD+"'");
                 if (consulta2!=0){
                     System.out.println("Usuario modificado correctamente");
                     JOptionPane.showMessageDialog(null,"Usuario modificado correctamente");
                 }
                 else{
                     System.out.println("Contraseña invalida");
                     JOptionPane.showMessageDialog(null,"Contraseña invalida");
                 }      
        }
        else{
                JOptionPane.showMessageDialog(null, "El usuario no existe");
        }            
        } catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al modificar");          
        }
    }
    
    //LISTAR
    public void list(){     
         
        try{
            
        consulta= cn.createStatement();
        tabla = consulta.executeQuery("SELECT * FROM usuarios");
        String [] registro = new String[5];
        //model = new DefaultTableModel(null,titulos);
        
        while(tabla.next()){
            registro[2]=tabla.getString("username");
                       
        }
  
        
        System.out.println("Lista de usuarios: "+ registro + "--");
        JOptionPane.showMessageDialog(null, "Lista de Usuarios");
        }
        catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al listar");          
        }
    }
    
     
    
    
    
    
    
    
}
