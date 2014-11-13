/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorautenticacion;

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
        public static void generarXmlABMA(String name, boolean error, String descripcionError) throws Exception{
       
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");
 
            //Main Node
            Element raiz = document.getDocumentElement();
            Element itemNode = document.createElement("ACK");
            if (error){
               
                Element keyNode1 = document.createElement("DESC");
                Text nodeKeyValue1 = document.createTextNode(descripcionError);
                keyNode1.appendChild(nodeKeyValue1);
            }else{
                name= name+"'OK'";
            }
                                //append itemNode to raiz
                raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"
                           
            //Generar XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File(name+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        
    }
    
  public static void main(String[] args) {
    String nombre_archivo = "ACK";
       boolean error=true;
       String descripcionError="Motivo del error";
        try {
            generarXmlABMA(nombre_archivo, error, descripcionError);
        } catch (Exception e) {}
    }
}
