/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorautenticacion;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Clase que parsea los mensajes XML de agregar usuario
 * @author Blanco-Matus-Herlein
 */
public class ParserAddXML{
    
    /**
     * Método que obtiene los atributos de los mensajes XML de agregar usuario
     * @param entrada Mensaje XML
     * @return Nombre de Usuario, Contraseña y Contraseña del Administrador
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws XPathExpressionException 
     */
    public ArrayList<String> getAtributos(String entrada)throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{
        InputSource is = new InputSource(new StringReader(entrada));
        org.w3c.dom.Document xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
        XPath xpath = XPathFactory.newInstance().newXPath();
        ArrayList<String> atributosAdd = new ArrayList<String>();
        
        atributosAdd.add((String)xpath.evaluate("USERNAME",xmlDoc.getDocumentElement(),XPathConstants.STRING));
        
        atributosAdd.add((String)xpath.evaluate("PASSWORD",xmlDoc.getDocumentElement(),XPathConstants.STRING));
        atributosAdd.add((String)xpath.evaluate("ADM-PASS",xmlDoc.getDocumentElement(),XPathConstants.STRING)); 
       
        return atributosAdd;
    }
}
