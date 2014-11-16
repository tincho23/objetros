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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase que realiza las consultas a la Base de Datos
 * @author Blanco-Matus-Herlein
 */
public class Mapper {
    
    
    
        Statement consulta;
        Statement consulta2;
        ResultSet tabla;
         
        
              
        //COSULTAR CONEXION
        Conectar cc= new Conectar();
        Connection cn = cc.conexion();
ArrayList<String> error = new ArrayList<>();
    
/**
 * Método del mapper para dar de alta a un usuario
 * @param usernameADD Nombre del usuario a ingresar
 * @param passwordADD Contraseña del usuario a ingresar
 * @return Estado de la operación
 */
    public ArrayList<String> add(String usernameADD, String passwordADD){     
        
        try{
            consulta= cn.createStatement();
            consulta.executeUpdate("INSERT INTO usuarios (username, password, timestamp) VALUES('"+usernameADD+"','"+passwordADD+"',"+"NOW())");
            error.add("TRUE");
            return error;
        }catch 
            (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al insertar");
            error.add("ERROR");
            error.add("Se ha producido una excepcion");
            return error;
        }
    }
    
    //BORRAR
    
    /**
     * Método del mapper para dar de baja a un usuario
     * @param usernameREMOVE Nombre del usuario a borrar
     * @return Estado de la operación
     */
    public ArrayList<String> remove(String usernameREMOVE){
                        
        try{
        consulta= cn.createStatement();
        tabla=consulta.executeQuery("SELECT username FROM usuarios WHERE username='"+usernameREMOVE+"'");
        
        if(tabla.next()){
            int consulta2 = consulta.executeUpdate("DELETE FROM usuarios WHERE username='"+usernameREMOVE+"'");
                 if (consulta2!=0){
                    error.add("OK");
                 return error;
                 }
                 else{
                    error.add("ERROR");
                    error.add("Se ha producido un error durante la eliminacion");
                 return error;
                 }      
        }
        else{
                error.add("ERROR");
                error.add("El usuario a eliminar no existe");
                return error;
        }            
        } catch (SQLException e){
            System.out.println(e);
            error.add("ERROR");
            error.add("Se ha producido una excepcion al borrar");
            return error;
        }  
       
    }
    
    //MODIFICAR
    /**
     * Método del para modificar la contraseña de un usuario
     * @param usernameMOD Nombre del usuario a modificarle la contraseña
     * @param passwordMOD Antigua contraseña del usuario
     * @param newpasswordMOD Nueva contraseña del usuario
     * @return Estado de la operación
     */ 
    public ArrayList<String> modify(String usernameMOD, String passwordMOD, String newpasswordMOD){
        
        try{
        consulta= cn.createStatement();
        tabla=consulta.executeQuery("SELECT username FROM usuarios WHERE username='"+usernameMOD+"'");
        
        if(tabla.next()){
            int consulta2 = consulta.executeUpdate("UPDATE  usuarios SET password='"+newpasswordMOD+"'WHERE username='"+usernameMOD+"' and password='"+passwordMOD+"'");
                 if (consulta2!=0){
                    System.out.println("Usuario modificado correctamente");
                    error.add("OK");
                 return error;
                 }
                 else{
                    error.add("ERROR");
                    error.add("Nombre de usuario o contraseña no validos");
                 return error;
                 }      
        }
        else{
                error.add("ERROR");
                error.add("El usuario ingresado no existe");
        }            
        } catch (SQLException e){
            System.out.println(e);
            error.add("ERROR");
            error.add("Se ha producido una excepcion");
            return error ;
        }
        return null;
    }
    
    //LISTAR
    /**
     * Método del Mapper para listar los usuarios 
     * @return Lista de usuarios
     */  
    public ResultSet listUsers(){     
         
        try{
            consulta= cn.createStatement();
            tabla = consulta.executeQuery("SELECT * FROM usuarios");
            System.out.println("Lista de usuarios: ");
            return tabla;
        }catch (SQLException e){
            System.out.println(e);
        }
    return null;
    }
   
    /**
     * Método del Mapper para listar los usuarios autenticados
     * @param usernameMOD Nombre del usuario a mostrar en la lista
     * @return Lista de autenticaciones
     */
    public ResultSet listAut(String usernameMOD){     
         
        try{
            consulta= cn.createStatement();
            tabla = consulta.executeQuery("SELECT host,timestamp FROM autenticaciones WHERE username='"+usernameMOD+"'");
            return tabla;
        }catch (SQLException e){
            System.out.println(e);
        }
    return null;
    }
    
    
  /**
   * Método del Mapper para autenticar a un usuario
   * @param usernameAUT Nombre del usuario a autenticar
   * @param passwordAUT Contraseña del usuario a autenticar
   * @param hostAUT Dirección IP de usuario a autenticar
   * @return Estado de la operación
   */  
  public ArrayList<String> autenticar(String usernameAUT, String passwordAUT, String hostAUT){
        
    try{
        consulta= cn.createStatement();
        tabla=consulta.executeQuery("SELECT username FROM usuarios WHERE username='"+usernameAUT+"' AND password='"+passwordAUT+"'");
        if(tabla.next()){
            consulta.executeUpdate("INSERT INTO autenticaciones (username, host, timestamp) VALUES('"+usernameAUT+"','"+hostAUT+"',"+"NOW())");
            error.add("OK");
            return error;
        }else{
            error.add("ERROR");
            error.add("Usuario o contraseña invalidos");
            return error;
            }
        }      
        catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al autenticar");
            error.add("ERROR");
            error.add("Se ha producido una excepcion");
            return error;
         }
    }  
}
