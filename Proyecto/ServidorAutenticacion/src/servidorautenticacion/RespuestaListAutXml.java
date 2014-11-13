/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorautenticacion;

/**
 *
 * @author JorgeLuis
 */

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

public class RespuestaListAutXml extends RespuestaListAut{
    public static void generarXmlListAut(String name, ArrayList<String> host,ArrayList<String> timestamp) throws Exception{
        //Considerar posibles causas de error para adjuntarlas al mensaje
        if(host.isEmpty() || timestamp.isEmpty() || host.size()!=timestamp.size()){
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
            for(int i=0; i<host.size();i++){
                //Item Node
                Element itemNode = document.createElement("AUT");
                //Key Node
                Element keyNode = document.createElement("HOST");
                Text nodeKeyValue = document.createTextNode(host.get(i));
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
    String nombre_archivo = "LIST-AUT";
        ArrayList vectorHost = new ArrayList();
        ArrayList vectorTimestamp = new ArrayList();
 
        vectorHost.add("iphost1");
        vectorTimestamp.add("fecha1");
        
        vectorHost.add("iphost2");
        vectorTimestamp.add("fecha2");
      
        try {
            generarXmlListAut(nombre_archivo, vectorHost, vectorTimestamp);
        } catch (Exception e) {}
    }
}
 