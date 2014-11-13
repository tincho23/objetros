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
 * @author JorgeLuis
 */
public class RespuestaListUsersXML extends RespuestaListUsers{
    public static void generarXmlListUsers(String name, ArrayList<String> username,ArrayList<String> timestamp) throws Exception{
        //Considerar posibles causas de error para adjuntarlas al mensaje
        if(username.isEmpty() || timestamp.isEmpty() || username.size()!=timestamp.size()){
            System.out.println("ERROR");
        }else{
 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");
 
            //Main Node
            Element raiz = document.getDocumentElement();
            //Por cada key creamos un item que contendrá la key y el value
            for(int i=0; i<username.size();i++){
                //Item Node
                Element itemNode = document.createElement("USER");
                //Key Node
                Element keyNode = document.createElement("USERNAME");
                Text nodeKeyValue = document.createTextNode(username.get(i));
                keyNode.appendChild(nodeKeyValue);
                itemNode.appendChild(keyNode);
                
                Element keyNode1 = document.createElement("TIMESTAMP");
                Text nodeKeyValue1 = document.createTextNode(timestamp.get(i));
                keyNode1.appendChild(nodeKeyValue1); 
                   
                itemNode.appendChild(keyNode1);
                //append itemNode to raiz
                raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"
            }                
            //Generar XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File(name+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
    }
    
  public static void main(String[] args) {
    String nombre_archivo = "LIST-USERS";
        ArrayList vectorUsername = new ArrayList();
        ArrayList vectorTimestamp = new ArrayList();
 
        vectorUsername.add("usuario1");
        vectorTimestamp.add("fecha1");
        
        vectorUsername.add("usuario2");
        vectorTimestamp.add("fecha2");
      
        try {
            generarXmlListUsers(nombre_archivo, vectorUsername, vectorTimestamp);
        } catch (Exception e) {}
    }
}
