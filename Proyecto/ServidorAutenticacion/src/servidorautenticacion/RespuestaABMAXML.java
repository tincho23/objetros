/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorautenticacion;
import static java.lang.System.out;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

 
/**
 * Clase que genera las respuestas ACK a los mensajes de alta, baja, modificación y autenticación
 * @author Blanco - Matus - Herlein
 */
public class RespuestaABMAXML{

       /**
        * Método que genera las respuestas XML a los mensajes de alta, baja, modificación y autenticación
        * @param error Variable que indica el estado y el tipo de error en caso de que se produzca el mismo
        * @return Mensaje XML
        */     
       public String generarXmlABMA(ArrayList<String> error){
   
            String estado;
            String descripcion;
            if ("ERROR".equals(error.get(0))){
                estado="ERROR";
                descripcion=error.get(1);
            }else{
                estado="OK";
                descripcion="";
            }
          String mensaje= "<ACK STATUS=\""+estado+"\"><DESC>"+descripcion+"</DESC></ACK>";   
          return mensaje;
          
    }
        
}
 
