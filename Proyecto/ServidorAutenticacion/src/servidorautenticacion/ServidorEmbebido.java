/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorautenticacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Tincho
 */
public class ServidorEmbebido {
    
    private ArrayList<String> error = new ArrayList<>();
    private String passAdmin;
    
    public ServidorEmbebido(){
        obtenerPropiedadesConexion();
    }
    
    private void obtenerPropiedadesConexion() {
        Properties propiedades = new Properties();
        InputStream archivo = null;

        try {
            archivo = new FileInputStream("ConfiguracionServer.properties");
            propiedades.load(archivo);
            this.passAdmin = propiedades.getProperty("passwordadmin");
            System.out.println(this.passAdmin);

        } catch (IOException e) {

        }
    }
    
    
    
    
    public ArrayList<String> addEmbebido(String username, String password, String passwordAdmin){
        if(this.passAdmin.equals(passwordAdmin)){
        
        error = new Mapper().add(username, password);
        }
        else{
        error.add("ERROR");
        error.add("Contraseña de administrador incorrecta");
        }
        
        return error; 
    }
    
    
    public ArrayList<String> removeEmbebido(String username, String passwordAdmin){
        if(this.passAdmin.equals(passwordAdmin)){
        
        error = new Mapper().remove(username);
        }
        else{
        error.add("ERROR");
        error.add("Contraseña de administrador incorrecta");
        }
        
        return error; 
    }
    
     public ArrayList<String> modifiyEmbebido(String username, String password,String newpassword, String passwordAdmin){
        if(this.passAdmin.equals(passwordAdmin)){
        
        error = new Mapper().modify(username, password, newpassword);
        }
        else{
        error.add("ERROR");
        error.add("Contraseña de administrador incorrecta");
        }
        
        return error; 
    }
     
    public ResultSet ListUsersEmbebido(String passwordAdmin){
        ResultSet resultado =null;
        if(this.passAdmin.equals(passwordAdmin)){
        
        resultado = new Mapper().listUsers();
        }
        else{
        
        System.out.println("Contraseña de administrador incorrecta");
        
        }
        
        return resultado; 
    }
    
    
    
    
    public ResultSet ListAutEmbebido(String username, String passwordAdmin){
        ResultSet resultado =null;
        if(this.passAdmin.equals(passwordAdmin)){
        
        resultado = new Mapper().listAut(username);
        }
        else{
        
        System.out.println("Contraseña de administrador incorrecta");
        
        }
        
        return resultado; 
    }
    
    public ArrayList<String> autenticarEmbebido(String username, String password) throws UnknownHostException{
        String host = InetAddress.getLocalHost().getHostAddress();
        
        error = new Mapper().autenticar(username, password, host);
               
                
        return error; 
    }
    
    
    
}