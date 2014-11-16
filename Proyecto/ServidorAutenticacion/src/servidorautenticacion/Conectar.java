package servidorautenticacion;


import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates


/**
 * Clase que realiza con la conexión a la Base de Datos
 * @author Blanco-Matus-Herlein
 */
public class Conectar {
    Connection con=null;
    String urlconexion;
    String usuariodb;
    String passdb;
    private void obtenerPropiedadesConexion(){
        Properties propiedades = new Properties();
        InputStream archivo = null;
        
        try {
            archivo = new FileInputStream("ConfiguracionServer.properties");
            propiedades.load(archivo);
                                                     
            this.urlconexion= propiedades.getProperty("urlconexion");
            this.usuariodb= propiedades.getProperty("usuariodb");
            this.passdb= propiedades.getProperty("passdb");
   
        } catch (IOException ex) {
            }
        }
        
    
    /**
     * Conexión a la Base de Datos
     *   
     * @return Conexión el estado de la conexión.
     */
    public Connection conexion() {
        try{
            //obtenerPropiedadesConexion();
            Class.forName("com.mysql.jdbc.Driver");           
            //con=DriverManager.getConnection(urlconexion,usuariodb,passdb);
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/autentificaciones","root","");
            System.out.println("Conexion Establecida");
                       
            
        } catch (ClassNotFoundException | SQLException | HeadlessException e){
            System.out.println("Error de conexion: "+e);
        }
        return con;
    
    }
}
