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
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Tincho
 */
public class RespuestaABMAXML extends RespuestaABMA{
 
        public String generarXmlABMA(boolean error){
   
            String estado;
            String descripcion;
            if (!error){
                estado="ERROR";
                descripcion="No se ha podido ingresar el usuario";
            }else{
                estado="OK";
                descripcion="";
            }
          String mensaje= "<ACK STATUS=\""+estado+"\"><DESC>"+descripcion+"</DESC></ACK>";   
          return mensaje;
    }
        
}
 
