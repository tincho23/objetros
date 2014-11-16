/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorautenticacion;
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;
/**
 * Clase que instancia el servidor
 * @author Blanco-Matus-Herlein
 */
public class ServidorAutenticacion {
    
    String passAdmin;
    int puerto;
    
    /**
     * Método del Servidor para la coordinación
     * @param args
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
          new ServidorAutenticacion();
       
    }
    public ServidorAutenticacion(){
         
       obtenerPropiedadesConfig();
       ServerSocket servidor = null;
       Socket socket = null;
       
        try{
          servidor = new ServerSocket(this.puerto);
  
          while (true){
              socket = servidor.accept();  
                      
              new Thread (new ControlServidorXML(socket,passAdmin)).start();
          }
    
         }
      catch (Exception e) { e.printStackTrace(); }      
    
 /*      try {
            servidor = new ServerSocket(puerto);
            socket = servidor.accept();
            //Obtener direccion IP del host que se conecta al servidor
            SocketAddress remoteaddress = socket.getRemoteSocketAddress();
            String iphost = remoteaddress.toString();
            iphost = iphost.substring(1,iphost.indexOf(":"));
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String datosEntrada = in.readLine();
          
            String respuesta= new ParserXML().respuesta(datosEntrada,iphost,passAdmin);
            out.println(respuesta);
     
          
       } catch (IOException | ParserConfigurationException | SAXException | XPathExpressionException | SQLException e) {
     } */
    }
        
    /**
     * Método para obtener las propiedades de configutación
     */
private void obtenerPropiedadesConfig() {
        
        Properties propiedades = new Properties();
        InputStream archivo = null;
        
        try {
            archivo = new FileInputStream("ConfiguracionServer.properties");
            // cargamos el archivo de propiedades
            propiedades.load(archivo);
            // obtenemos las propiedades y las almacenamos

                                          
            this.passAdmin= propiedades.getProperty("passwordadmin");
            this.puerto=Integer.parseInt(propiedades.getProperty("puerto"));
            
   
        } catch (IOException ex) {
            }
        }
}
